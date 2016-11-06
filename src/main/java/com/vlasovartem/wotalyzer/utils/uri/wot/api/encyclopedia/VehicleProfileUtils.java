package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.fasterxml.jackson.databind.JavaType;
import com.vlasovartem.wotalyzer.entity.wot.api.response.AbstractAPIResponse;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.info.Info;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleProfileConstants;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FIELDS_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.TANK_ID_PARAM;

/**
 * Util that help create API URL
 */
@Component
public class VehicleProfileUtils extends MainUtils<VehicleProfile> {
    private static final Logger LOGGER = LogManager.getLogger(VehicleProfileUtils.class);

    public VehicleProfileUtils() {
        super(VehicleProfile.class);
    }

    /**
     * Build VehicleUtils API URI with provided query params. Tank id is required query param for this uri builder.
     * @param queryParams map of query params, that matches with List of possible url parameters
     * @return Build url with provided parameters, application id and tank id
     */
    public String vehicleUri(Map<String, Object> queryParams) {
        if (Objects.isNull(queryParams) || !queryParams.containsKey(TANK_ID_PARAM)) {
            LOGGER.error("Tank id is required");
            throw new RuntimeException("Tank id is required");
        }
        return convertURL(queryParams.entrySet().stream()
                .filter(params ->
                        VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()) ||
                                VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)), VehicleProfileConstants.BASIC_URL);
    }

    /**
     * Find VehicleUtils with single parameter tank id
     * @param tankId tank id
     * @return AbstractAPIResponse with associated array.
     */
    public AbstractAPIResponse<Map<String, VehicleProfile>> getVehicleApiResponse(long tankId) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        return getApiResponseMap(params);
    }

    /**
     * Find VehicleUtils with single parameter tank id, that will contains or not contains particular fields
     * @param tankId tank id
     * @param fields list of fields that should include or exclude from response
     * @return AbstractAPIResponse with associated array.
     *
     */
    public AbstractAPIResponse<Map<String, VehicleProfile>> getVehicleApiResponse(long tankId, List<String> fields) {
        Map<String, Object> params = new HashMap<>();
        params.put(TANK_ID_PARAM, tankId);
        params.put(FIELDS_PARAM, fields);
        return getApiResponseMap(params);
    }


    /**
     * Convert Tankopedia object from API Response
     * @param queryParams params for request
     * @return APIReponse with data that contains object Info
     */
    public AbstractAPIResponse<Info> getTankopediaAPIResponse(Map<String, Object> queryParams) {
        String tankopediaAPIUrl = "https://api.worldoftanks.ru/wot/encyclopedia/info/";
        String url = convertURL(queryParams, tankopediaAPIUrl);
        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(AbstractAPIResponse.class, AbstractAPIResponse.class, Info.class);
        try {
            return objectMapper.readValue(restTemplate.getForObject(convertURL(null, url), String.class), type);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleProfileConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleProfileConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleProfileConstants.REQUIRED_PARAMS;
    }
}
