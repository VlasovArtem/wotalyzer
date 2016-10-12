package com.vlasovartem.wotalyzer.utils.uri.wot.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlasovartem.wotalyzer.entity.wot.api.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.exception.WotAPIException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by artemvlasov on 28/09/16.
 */
public abstract class MainUtils<T> {

    private static final Logger LOGGER = LogManager.getLogger(MainUtils.class);
    @Value("${applicationId:#{null}}")
    private String applicationId;
    protected RestTemplate restTemplate;
    @Autowired
    protected ObjectMapper objectMapper;
    private final Class<T> type;

    public MainUtils(Class<T> type) {
        this.type = type;
        restTemplate = new RestTemplate();

    }

    /**
     * Build API URI with provided query params.
     *
     * @param queryParams map of query params, that matches with List of possible url parameters
     * @return Build url with provided parameters and application id.
     */
    public String buildUri(Map<String, Object> queryParams, List<String> constants, String basicUrl) {
        if (validateQueryParamsValue(queryParams) && Objects.nonNull(constants)) {
            return convertURL(convertParams(queryParams, constants), basicUrl);
        }
        return null;
    }

    /**
     * Create APIResponse from response from API
     *
     * @param queryParams params that should be add to basic api url
     * @return APIResponse return that contains data that is represent as map with key tank id and value requested object.
     */
    public APIResponse<Map<String, T>> getApiResponse(Map<String, Object> queryParams) {
        String url = buildUri(queryParams, getAPIConstants(), getAPIBaseUrl());
        return getApiResponse(url);
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    public APIResponse<Map<String, T>> getApiResponse(String url) {
        if (Objects.nonNull(url)) {
            JavaType type = objectMapper.getTypeFactory().constructParametrizedType(APIResponse.class, APIResponse.class,
                    objectMapper.getTypeFactory().constructMapType(Map.class, String.class, this.type));
            try {
                return objectMapper.readValue(getUrlResponse(url), type);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

    public abstract String getAPIBaseUrl();

    public abstract List<String> getAPIConstants();

    public abstract List<String> getRequiredAPIParams();

    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        return checkRequiredFields(queryParams);
    }

    /**
     * Create url from provided query params and basic url of the particular API.
     *
     * @param queryParams List of query params that associated with particular API
     * @param basicUrl    basic url of particular API
     * @return Prepared API URL
     */
    protected String convertURL(Map<String, Object> queryParams, String basicUrl) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(basicUrl);
        builder.queryParam(BasicAPIConstants.APPLICATION_ID_PARAM, applicationId);
        if (Objects.nonNull(queryParams)) {
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                if (BasicAPIConstants.FIELDS_PARAM.equals(entry.getKey())) {
                    if (entry.getValue() instanceof List) {
                        builder.queryParam(entry.getKey(), ((List) entry.getValue()).stream().collect(Collectors.joining(",")).toString());
                    } else {
                        builder.queryParam(entry.getKey(), entry.getValue());
                    }
                } else {
                    builder.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        return builder.build().encode().toString();
    }

    /**
     * Collect data string from api url response
     *
     * @param url API full url
     * @return String that contains response data
     * @throws IOException
     */
    private String getUrlResponse(String url) throws IOException {
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        JsonNode status = objectMapper.readTree(responseEntity.getBody().toString());
        if (responseEntity.getStatusCode().is4xxClientError() || responseEntity.getStatusCode().is5xxServerError() || "error".equals(status.findValue("status").toString().replace("\"", ""))) {
            LOGGER.warn(responseEntity.getBody());
            throw new WotAPIException(responseEntity.getBody().toString());
        }
        return responseEntity.getBody().toString();
    }

    protected boolean checkRequiredFields(Map<String, Object> queryMap) {
        boolean hasNoError = true;
        if ((Objects.isNull(queryMap) || queryMap.isEmpty()) && getRequiredAPIParams().size() > 0) {
            hasNoError = false;
        }
        if (!hasNoError) {
            hasNoError = !queryMap.keySet()
                    .stream()
                    .allMatch(s -> getRequiredAPIParams()
                            .stream()
                            .anyMatch(s1 -> s1.equals(s)));
        }
        if (!hasNoError) {
            LOGGER.error("Api {} required next fields: {} (one of a fields is missing)", getAPIBaseUrl(), getRequiredAPIParams().stream().collect(Collectors.joining(", ")));
        }
        return hasNoError;
    }

    private Map<String, Object> convertParams(Map<String, Object> queryParams, List<String> constants) {
        return queryParams.entrySet().stream()
                .filter(params ->
                        constants.contains(params.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
