package com.vlasovartem.wotalyzer.utils.wot;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.vlasovartem.wotalyzer.entity.wot.api.WotApiError;
import com.vlasovartem.wotalyzer.entity.wot.api.response.*;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIException;
import com.vlasovartem.wotalyzer.exception.wot.api.WotAPIValidationException;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.*;
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
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    protected MainUtils() {
        restTemplate = new RestTemplate();
    }

    /**
     * Create APIResponse from response from API
     *
     * @param queryParams params that should be add to basic api url
     * @return APIResponse return that contains data that is represent as map with key tank id and value requested object.
     */
    protected APIResponse<T> getApiResponse(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponse(url, getParametrizedType(APIResponse.class, createJavaType()));
    }

    protected APIResponse<List<T>> getApiResponseList(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponse(url, getParametrizedType(APIResponse.class, createListType()));
    }

    protected APIResponse<Map<String, T>> getApiResponseMap(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponse(url, getParametrizedType(APIResponse.class, createMapType()));
    }

    protected APIResponse<Map<String, List<T>>> getApiResponseMapList(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponse(url, getParametrizedType(APIResponse.class, createListType()));
    }

    protected APIResponse<T> getApiResponse(String url) {
        return getApiResponse(url, getParametrizedType(APIResponse.class, createJavaType()));
    }

    protected APIResponse<List<T>> getApiResponseList(String url) {
        return getApiResponse(url, getParametrizedType(APIResponse.class, createListType()));
    }

    protected APIResponse<Map<String, T>> getApiResponseMap(String url) {
        return getApiResponse(url, getParametrizedType(APIResponse.class, createMapType()));
    }

    protected APIResponse<Map<String, List<T>>> getApiResponseMapList(String url) {
        return getApiResponse(url, getParametrizedType(APIResponse.class, createMapListType()));
    }

    protected abstract BasicAPIConstants getAPIConstants();

    protected Map<String, String> getDefaultValueMap() {
        return Collections.emptyMap();
    }

    protected List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.emptyList();
    }

    /**
     * Build API URI with provided query params.
     *
     * @param queryParams map of query params, that matches with List of possible url parameters
     * @return Build url with provided parameters and application id.
     */
    private String buildUri(Map<String, Object> queryParams) {
        if (validateQueryParamsValue(queryParams) && Objects.nonNull(getAPIConstants())) {
            return convertURL(convertParams(queryParams, getAPIConstants().getBasicApiConstants()), getAPIConstants().getBasicUrl());
        }
        return null;
    }

    protected boolean validateQueryParamsValue(Map<String, Object> queryParams) {
        prepareQueryParams(queryParams);
        if (checkRequiredFields(queryParams)) {
            List<Function<Map<String, Object>, Boolean>> validationFunctions = getValidationFunctions();
            return validationFunctions.isEmpty() || validationFunctions.stream().allMatch(mapBooleanFunction -> mapBooleanFunction.apply(queryParams));
        }
        return false;
    }

    private void prepareQueryParams(Map<String, Object> queryParams) {
        if (!getDefaultValueMap().isEmpty()) {
            getDefaultValueMap().entrySet().forEach(defaultValueSet -> {
                if (Objects.isNull(queryParams.get(defaultValueSet.getKey())) && getAPIConstants().getRequiredParams().contains(defaultValueSet.getKey())) {
                    queryParams.put(defaultValueSet.getKey(), defaultValueSet.getValue());
                }
            });
        }
    }

    /**
     * Create url from provided query params and basic url of the particular API.
     *
     * @param queryParams List of query params that associated with particular API
     * @param basicUrl    basic url of particular API
     * @return Prepared API URL
     */
    private String convertURL(Map<String, Object> queryParams, String basicUrl) {
        String convertedBasicUrl = basicUrl.endsWith("/") ? basicUrl : basicUrl + "/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(convertedBasicUrl);
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
        Set<String> paramKeys = Optional.ofNullable(queryMap).orElse(Collections.emptyMap()).keySet();
        List<String> missingRequiredParams = getAPIConstants().getRequiredParams()
                .stream()
                .filter(param -> !paramKeys.contains(param))
                .collect(Collectors.toList());
        if (!missingRequiredParams.isEmpty()) {
            String message = String.format("Api %s required next fields: %s (one of a fields is missing)", getAPIConstants().getBasicUrl(), missingRequiredParams.stream().collect(Collectors.joining(", ")));
            LOGGER.warn(message);
            throw new WotAPIValidationException(message);
        }
        return true;
    }

    /**
     * WotMap provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return APIResponse
     */
    private <F extends APIResponse> F getApiResponse(String url, JavaType parametrizedType) {
        if (Objects.isNull(url) || url.isEmpty()) {
            url = convertURL(null, getAPIConstants().getBasicUrl());
        }
        if (Objects.nonNull(url) && !url.isEmpty() && Objects.nonNull(parametrizedType)) {
            try {
                return objectMapper.readValue(getUrlResponse(url), parametrizedType);
            } catch (Exception e) {
                throw new WotAPIException(e.getMessage());
            }
        }
        return (F) NullAPIResponse.getNullResponse();
    }

    /**
     * Collect data string from api url response
     *
     * @param url API full url
     * @return String that contains response data
     * @throws IOException
     */
    private String getUrlResponse(String url) throws IOException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        JsonNode status = objectMapper.readTree(responseEntity.getBody());
        if (status.findValue("status").toString().contains("error")) {
            WotApiError error = objectMapper.readValue(responseEntity.getBody(), objectMapper.constructType(WotApiError.class));
            LOGGER.warn(error.getError());
            throw new WotAPIException(responseEntity.getBody());
        }
        return responseEntity.getBody();
    }

    private Map<String, Object> convertParams(Map<String, Object> queryParams, List<String> constants) {
        return queryParams.entrySet().stream()
                .filter(params ->
                        constants.contains(params.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private CollectionType createListType() {
        return objectMapper.getTypeFactory().constructCollectionType(List.class, getType());
    }

    private MapType createMapType() {
        return objectMapper.getTypeFactory().constructMapType(Map.class, String.class, getType());
    }

    private JavaType createJavaType() {
        return objectMapper.getTypeFactory().constructType(getType());
    }

    private MapType createMapListType() {
        return objectMapper.getTypeFactory().constructMapType(Map.class, objectMapper.constructType(String.class), createListType());
    }

    private <F extends APIResponse> JavaType getParametrizedType(Class<F> responseType, JavaType contentType) {
        return objectMapper.getTypeFactory().constructParametrizedType(responseType, responseType, contentType);
    }

    protected abstract Class<T> getType();
}
