package com.vlasovartem.wotalyzer.utils.uri.wot.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlasovartem.wotalyzer.entity.wot.api.APIResponse;
import com.vlasovartem.wotalyzer.utils.exception.WotAPIException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.APPLICATION_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FIELDS_PARAM;

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
    private final Class type;

    public MainUtils(Class type) {
        this.type = type;
        restTemplate = new RestTemplate();

    }

    /**
     * Create APIResponse from response from API
     *
     * @param queryParams params that should be add to basic api url
     * @return APIResponse return that contains data that is represent as map with key tank id and value requested object.
     */
    public APIResponse<T> getApiResponse(Map<String, Object> queryParams) {
        String url = buildUri(queryParams, getAPIConstants(), getAPIBaseUrl());
        return getApiResponse(url);
    }

    public APIResponse<List<T>> getApiResponseList(Map<String, Object> queryParams) {
        String url = buildUri(queryParams, getAPIConstants(), getAPIBaseUrl());
        return getApiResponseList(url);
    }

    public APIResponse<Map<String, T>> getApiResponseMap(Map<String, Object> queryParams) {
        String url = buildUri(queryParams, getAPIConstants(), getAPIBaseUrl());
        return getApiResponseMap(url);
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    public APIResponse<List<T>> getApiResponseList(String url) {
        return getApiResponse(url, createJavaType(List.class));
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    public APIResponse<Map<String, T>> getApiResponseMap(String url) {
        return getApiResponse(url, createJavaType(Map.class));
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    public APIResponse<T> getApiResponse(String url) {
        return getApiResponse(url, createJavaType(Object.class));
    }

    public abstract String getAPIBaseUrl();

    public abstract List<String> getAPIConstants();

    public abstract List<String> getRequiredAPIParams();

    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.emptyList();
    }

    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        if (checkRequiredFields(queryParams)) {
            List<Function<Map<String, Object>, Boolean>> validationFunctions = getValidationFunctions();
            return !validationFunctions.isEmpty() || validationFunctions.stream().allMatch(mapBooleanFunction -> mapBooleanFunction.apply(queryParams));
        }
        return false;
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
        builder.queryParam(APPLICATION_ID_PARAM, applicationId);
        if (Objects.nonNull(queryParams)) {
            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                if (FIELDS_PARAM.equals(entry.getKey())) {
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

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    private <F> APIResponse<F> getApiResponse(String url, JavaType javaType) {
        if (Objects.nonNull(url)) {
            JavaType type = objectMapper.getTypeFactory().constructParametrizedType(APIResponse.class, APIResponse.class,
                    javaType);
            try {
                return objectMapper.readValue(getUrlResponse(url), type);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return null;
    }

    /**
     * Build API URI with provided query params.
     *
     * @param queryParams map of query params, that matches with List of possible url parameters
     * @return Build url with provided parameters and application id.
     */
    private String buildUri(Map<String, Object> queryParams, List<String> constants, String basicUrl) {
        if (validateQueryParamsValue(queryParams) && Objects.nonNull(constants)) {
            return convertURL(convertParams(queryParams, constants), basicUrl);
        }
        return null;
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

    private Map<String, Object> convertParams(Map<String, Object> queryParams, List<String> constants) {
        return queryParams.entrySet().stream()
                .filter(params ->
                        constants.contains(params.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private <F> JavaType createJavaType(Class<F> returnedType)  {
        if (returnedType.isAssignableFrom(List.class)) {
            return objectMapper.getTypeFactory().constructArrayType(type);
        } else if (returnedType.isAssignableFrom(Map.class)) {
            return objectMapper.getTypeFactory().constructMapType(Map.class, String.class, type);
        } else {
            return objectMapper.getTypeFactory().uncheckedSimpleType(type);
        }
    }
}
