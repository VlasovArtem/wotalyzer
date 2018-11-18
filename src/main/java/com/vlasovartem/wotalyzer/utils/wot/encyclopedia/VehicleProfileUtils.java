package com.vlasovartem.wotalyzer.utils.wot.encyclopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleProfileConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.wot.MainUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;
import static com.vlasovartem.wotalyzer.utils.response.APIResponseUtils.convertMapToObject;

/**
 * Util that help create API URL
 */
@Component
public class VehicleProfileUtils extends MainUtils<VehicleProfile> {

    public Optional<VehicleProfile> getVehicleProfile(long tankId) {
        return convertMapToObject(getApiResponseMap(VehicleParamBuilder.newBuilder().withTankId(tankId).build()));
    }

    public VehicleProfile getTopModuleVehicleProfile(VehicleModuleInfo moduleInfo) {
        if (Objects.nonNull(moduleInfo)) {
            if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
                APIResponse<Map<String, VehicleProfile>> apiResponse = getApiResponseMap(moduleInfo.getTopModuleUrl());
                Optional<Map<String, VehicleProfile>> content = apiResponse.getContent();
                if (content.isPresent()) {
                    return content.get().get(String.valueOf(moduleInfo.getTankId()));
                }
            } else {
                APIResponse<Map<String, VehicleProfile>> apiResponse = getApiResponseMap(VehicleParamBuilder.newBuilder()
                        .withTankId(moduleInfo.getTankId())
                        .customParam(ENGINE_ID_PARAM, moduleInfo.getTopModules().getEngineId())
                        .customParam(GUN_ID_PARAM, moduleInfo.getTopModules().getGunId())
                        .customParam(SUSPENSION_ID_PARAM, moduleInfo.getTopModules().getSuspensionId())
                        .customParam(RADIO_ID_PARAM, moduleInfo.getTopModules().getRadioId())
                        .customParam(TURRET_ID_PARAM, moduleInfo.getTopModules().getTurretId())
                        .build());
                Optional<Map<String, VehicleProfile>> content = apiResponse.getContent();
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
//     * @return APIReponse with data that contains object Info
//     */
//    public APIResponse<Info> getTankopediaAPIResponse(WotMap<String, Object> queryParams) {
//        String tankopediaAPIUrl = "https://api.worldoftanks.ru/wot/encyclopedia/info/";
//        String url = convertURL(queryParams, tankopediaAPIUrl);
//        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(APIResponse.class, APIResponse.class, Info.class);
//        try {
//            return objectMapper.readValue(restTemplate.getForObject(convertURL(null, url), String.class), type);
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

//    /**
//     * Build VehicleUtils API URI with provided query params. Tank id is required query param for this uri newBuilder.
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
//                        VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()) ||
//                                VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()))
//                .collect(Collectors.toMap(WotMap.Entry::getKey, WotMap.Entry::getValue)), VehicleProfileConstants.BASIC_URL);
//    }

    @Override
    protected Class<VehicleProfile> getType() {
        return VehicleProfile.class;
    }

    @Override
    protected BasicAPIConstants getAPIConstants() {
        return VehicleProfileConstants.getInstance();
    }
}
