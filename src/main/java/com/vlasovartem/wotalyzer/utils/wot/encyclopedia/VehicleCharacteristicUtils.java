package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleCharacteristic;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleCharacteristicConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToList;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Util that help create API URL
 */
@Component
public class VehicleCharacteristicUtils extends MainUtils<VehicleCharacteristic> {
    private static final Logger LOGGER = LogManager.getLogger(VehicleCharacteristicUtils.class);

    public Optional<VehicleCharacteristic> getVehicleProfile(long tankId) {
        return convertMapToObject(getApiResponseMap(VehicleParamBuilder.newBuilder().withTankId(tankId).build()));
    }

    public List<VehicleCharacteristic> getVehicleProfiles(List<Integer> tankIds) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder().withTankIds(tankIds).build()));
    }

    public List<VehicleCharacteristic> getVehicleProfiles(List<Integer> tankIds, List<String> fields) {
        return convertMapToList(getApiResponseMap(VehicleParamBuilder.newBuilder()
                .withTankIds(tankIds)
                .withFields(fields)
                .build()));
    }

    public VehicleCharacteristic getTopModuleVehicleProfile(VehicleModuleInfo moduleInfo) {
        if (Objects.nonNull(moduleInfo)) {
            if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
                APIResponse<Map<String, VehicleCharacteristic>> apiResponse = getApiResponseMap(moduleInfo.getTopModuleUrl());
                Optional<Map<String, VehicleCharacteristic>> content = apiResponse.getContent();
                if (content.isPresent()) {
                    return content.get().get(String.valueOf(moduleInfo.getTankId()));
                }
            } else {
                APIResponse<Map<String, VehicleCharacteristic>> apiResponse = getApiResponseMap(VehicleParamBuilder.newBuilder()
                        .withTankId(moduleInfo.getTankId())
                        .customParam(ENGINE_ID_PARAM, moduleInfo.getTopModules().getEngineId())
                        .customParam(GUN_ID_PARAM, moduleInfo.getTopModules().getGunId())
                        .customParam(SUSPENSION_ID_PARAM, moduleInfo.getTopModules().getSuspensionId())
                        .customParam(RADIO_ID_PARAM, moduleInfo.getTopModules().getRadioId())
                        .customParam(TURRET_ID_PARAM, moduleInfo.getTopModules().getTurretId())
                        .build());
                Optional<Map<String, VehicleCharacteristic>> content = apiResponse.getContent();
                if (content.isPresent()) {
                    return content.get().get(moduleInfo.getTankId());
                }
            }
        }
        return null;
//            if (Objects.isNull(fields) || fields.isEmpty()) {
//                return wotApiURIUtils.getApiResponseMap(moduleInfo.getTopModuleUrl()).getData().get(String.valueOf(moduleInfo.getTankId()));
//            } else if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
//                String urlWithFields = moduleInfo.getTopModuleUrl() + "&fields=" + fields.stream().collect(Collectors.joining(","));
//                return wotApiURIUtils.getApiResponseMap(urlWithFields).getData().get(String.valueOf(moduleInfo.getTankId()));
//            } else {
//                WotMap<String, Object> params = new HashMap<>();
//                params.put(FIELDS_PARAM, fields);
//                params.put(TANK_ID_PARAM, moduleInfo.getTankId());
//                VehicleModuleComponent topModuleComponent = moduleInfo.getTopModules();
//                if(Objects.nonNull(topModuleComponent.getEngineId())) {
//                    params.put(ENGINE_ID_PARAM, topModuleComponent.getEngineId());
//                }
//                if(Objects.nonNull(topModuleComponent.getGunId())) {
//                    params.put(GUN_ID_PARAM, topModuleComponent.getGunId());
//                }
//                if(Objects.nonNull(topModuleComponent.getSuspensionId())) {
//                    params.put(SUSPENSION_ID_PARAM, topModuleComponent.getSuspensionId());
//                }
//                if(Objects.nonNull(topModuleComponent.getRadioId())) {
//                    params.put(RADIO_ID_PARAM, topModuleComponent.getRadioId());
//                }
//                if(Objects.nonNull(topModuleComponent.getTurretId())) {
//                    params.put(TURRET_ID_PARAM, topModuleComponent.getTurretId());
//                }
//                return wotApiURIUtils.getApiResponseMap(params).getData().get(String.valueOf(moduleInfo.getTankId()));
//            }
//        }
    }


//    /**
//     * Convert Tankopedia object from API Response
//     * @param queryParams params for request
//     * @return APIReponse with data that contains object TankopediaInformation
//     */
//    public APIResponse<TankopediaInformation> getTankopediaAPIResponse(WotMap<String, Object> queryParams) {
//        String tankopediaAPIUrl = "https://api.worldoftanks.ru/wot/encyclopedia/info/";
//        String url = convertURL(queryParams, tankopediaAPIUrl);
//        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(APIResponse.class, APIResponse.class, TankopediaInformation.class);
//        try {
//            return objectMapper.readValue(restTemplate.getForObject(convertURL(null, url), String.class), type);
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

//    /**
//     * Build VehicleUtils API URI with provided query params. Tank id is required query param for this uri builder.
//     * @param queryParams map of query params, that matches with List of possible url parameters
//     * @return Build url with provided parameters, application id and tank id
//     */
//    public String vehicleUri(WotMap<String, Object> queryParams) {
//        if (Objects.isNull(queryParams) || !queryParams.containsKey(TANK_ID_PARAM)) {
//            LOGGER.error("Tank id is required");
//            throw new RuntimeException("Tank id is required");
//        }
//        return convertURL(queryParams.entrySet().stream()
//                .filter(params ->
//                        VehicleCharacteristicConstants.BASIC_API_CONSTANTS.contains(params.getKey()) ||
//                                VehicleCharacteristicConstants.BASIC_API_CONSTANTS.contains(params.getKey()))
//                .collect(Collectors.toMap(WotMap.Entry::getKey, WotMap.Entry::getValue)), VehicleCharacteristicConstants.BASIC_URL);
//    }

    @Override
    protected Class<VehicleCharacteristic> getType() {
        return VehicleCharacteristic.class;
    }

    @Override
    public String getAPIBaseUrl() {
        return VehicleCharacteristicConstants.BASIC_URL;
    }

    @Override
    public List<String> getAPIConstants() {
        return VehicleCharacteristicConstants.BASIC_API_CONSTANTS;
    }

    @Override
    public List<String> getRequiredAPIParams() {
        return VehicleCharacteristicConstants.REQUIRED_PARAMS;
    }
}
