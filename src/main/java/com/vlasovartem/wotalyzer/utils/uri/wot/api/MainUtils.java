package com.vlasovartem.wotalyzer.utils.uri.wot.api;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vlasovartem.wotalyzer.entity.wot.api.response.*;
import com.vlasovartem.wotalyzer.utils.exception.WotAPIException;
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
    protected RestTemplate restTemplate;
    @Autowired
    protected ObjectMapper objectMapper;

    public MainUtils() {
        restTemplate = new RestTemplate();

    }

    /**
     * Create AbstractAPIResponse from response from API
     *
     * @param queryParams params that should be add to basic api url
     * @return AbstractAPIResponse return that contains data that is represent as map with key tank id and value requested object.
     */
    protected APIResponse<T> getApiResponse(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponse(url);
    }

    protected APIResponseList<T> getApiResponseList(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponseList(url);
    }

    protected APIResponseMap<T> getApiResponseMap(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponseMap(url);
    }

    protected APIResponseMapList<T> getApiResponseMapList(Map<String, Object> queryParams) {
        String url = buildUri(queryParams);
        return getApiResponseMapList(url);
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return AbstractAPIResponse
     */
    protected APIResponseList<T> getApiResponseList(String url) {
        return getApiResponse(url, getParametrizedType(APIResponseList.class, createJavaType(List.class)));
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return AbstractAPIResponse
     */
    protected APIResponseMap<T> getApiResponseMap(String url) {
        return getApiResponse(url, getParametrizedType(APIResponseMap.class, createJavaType(Map.class)));
    }

    private APIResponseMapList<T> getApiResponseMapList(String url) {
        return getApiResponse(url, getParametrizedType(APIResponseMapList.class, createExtendedMapJavaType(List.class)));
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return AbstractAPIResponse
     */
    private APIResponse<T> getApiResponse(String url) {
        return getApiResponse(url, getParametrizedType(APIResponse.class, createJavaType(Object.class)));
    }

    public abstract String getAPIBaseUrl();

    public abstract List<String> getAPIConstants();

    public abstract List<String> getRequiredAPIParams();

    public Map<String, String> getDefaultValueMap() {
        return Collections.emptyMap();
    }

    public List<Function<Map<String, Object>, Boolean>> getValidationFunctions() {
        return Collections.emptyList();
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
                if (Objects.isNull(queryParams.get(defaultValueSet.getKey())) && getRequiredAPIParams().contains(defaultValueSet.getKey())) {
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
    protected String convertURL(Map<String, Object> queryParams, String basicUrl) {
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
        List<String> missingRequiredParams = getRequiredAPIParams()
                .stream()
                .filter(param -> !paramKeys.contains(param))
                .collect(Collectors.toList());
        if (!missingRequiredParams.isEmpty()) {
            String message = String.format("Api %s required next fields: %s (one of a fields is missing)", getAPIBaseUrl(), missingRequiredParams.stream().collect(Collectors.joining(", ")));
            LOGGER.error(message);
            throw new WotAPIException(message);
        }
        return true;
    }

    /**
     * Map provide String url response to APIRepsonse object
     *
     * @param url full url
     * @return AbstractAPIResponse
     */
    private <F extends AbstractAPIResponse> F getApiResponse(String url, JavaType paremetrizedType) {
        if (Objects.nonNull(url) && Objects.nonNull(paremetrizedType)) {
            try {
                return objectMapper.readValue(getUrlResponse(url), paremetrizedType);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return (F) NullAPIResponse.getNullResponse();
    }

    /**
     * Build API URI with provided query params.
     *
     * @param queryParams map of query params, that matches with List of possible url parameters
     * @return Build url with provided parameters and application id.
     */
    private String buildUri(Map<String, Object> queryParams) {
        if (validateQueryParamsValue(queryParams) && Objects.nonNull(getAPIConstants())) {
            return convertURL(convertParams(queryParams, getAPIConstants()), getAPIBaseUrl());
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
        if (Collection.class.isAssignableFrom(returnedType)) {
            return objectMapper.getTypeFactory().constructCollectionType((Class<? extends Collection>) returnedType, getType());
        } else if (Map.class.isAssignableFrom(returnedType)) {
            return objectMapper.getTypeFactory().constructMapType(Map.class, String.class, getType());
        } else {
            return objectMapper.getTypeFactory().uncheckedSimpleType(getType());
        }
    }

    private <F> JavaType createExtendedMapJavaType(Class<F> valueTypeClass) {
        JavaType keyType = objectMapper.getTypeFactory().uncheckedSimpleType(String.class);
        if (valueTypeClass.isAssignableFrom(List.class)) {
            JavaType valueType = createJavaType(List.class);
            return objectMapper.getTypeFactory().constructMapType(Map.class, keyType, valueType);
        } else {
            return objectMapper.getTypeFactory().constructMapType(Map.class, String.class, getType());
        }
    }

    private <F extends AbstractAPIResponse> JavaType getParametrizedType(Class<F> responseType, JavaType contentType) {
        return objectMapper.getTypeFactory().constructParametrizedType(responseType, responseType, contentType);
    }

    protected abstract Class getType();
}
