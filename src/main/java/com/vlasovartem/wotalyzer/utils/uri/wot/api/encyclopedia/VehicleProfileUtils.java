package com.vlasovartem.wotalyzer.utils.uri.wot.api.encyclopedia;

import com.vlasovartem.wotalyzer.entity.statistic.VehicleModuleInfo;
import com.vlasovartem.wotalyzer.entity.wot.api.encyclopedia.VehicleProfile;
import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponseMap;
import com.vlasovartem.wotalyzer.utils.api.contstans.encyclopedia.VehicleProfileConstants;
import com.vlasovartem.wotalyzer.utils.query.builder.VehicleParamBuilder;
import com.vlasovartem.wotalyzer.utils.uri.wot.api.MainUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.*;

/**
 * Util that help create API URL
 */
@Component
public class VehicleProfileUtils extends MainUtils<VehicleProfile> {
    private static final Logger LOGGER = LogManager.getLogger(VehicleProfileUtils.class);

    @Override
    protected Class getType() {
        return VehicleProfile.class;
    }

    public Optional<VehicleProfile> getVehicleProfile(long tankId) {
        APIResponseMap<VehicleProfile> apiResponseMap = getApiResponseMap(VehicleParamBuilder.newBuilder().withTankId(tankId).build());
        Optional<Map<String, VehicleProfile>> content = apiResponseMap.getContent();
        if (content.isPresent()) {
            return Optional.of(content.get().get(String.valueOf(tankId)));
        }
        return Optional.empty();
    }

    public List<VehicleProfile> getVehicleProfiles(List<Integer> tankIds) {
        APIResponseMap<VehicleProfile> apiResponseMap = getApiResponseMap(VehicleParamBuilder.newBuilder().withTankIds(tankIds).build());
        Optional<Map<String, VehicleProfile>> content = apiResponseMap.getContent();
        if (content.isPresent()) {
            return new ArrayList<>(content.get().values());
        }
        return Collections.emptyList();
    }

    public List<VehicleProfile> getVehicleProfiles(List<Integer> tankIds, List<String> fields) {
        APIResponseMap<VehicleProfile> apiResponseMap = getApiResponseMap(VehicleParamBuilder.newBuilder()
                .withTankIds(tankIds)
                .withFields(fields)
                .build());
        Optional<Map<String, VehicleProfile>> content = apiResponseMap.getContent();
        if (content.isPresent()) {
            return new ArrayList<>(content.get().values());
        }
        return Collections.emptyList();
    }

    public VehicleProfile getTopModuleVehicleProfile(VehicleModuleInfo moduleInfo) {
        if (Objects.nonNull(moduleInfo)) {
            if (Objects.nonNull(moduleInfo.getTopModuleUrl())) {
                APIResponseMap<VehicleProfile> profileAPIResponseMap = getApiResponseMap(moduleInfo.getTopModuleUrl());
                Optional<Map<String, VehicleProfile>> content = profileAPIResponseMap.getContent();
                if (content.isPresent()) {
                    return content.get().get(String.valueOf(moduleInfo.getTankId()));
                }
            } else {
                APIResponseMap<VehicleProfile> profileAPIResponseMap = getApiResponseMap(VehicleParamBuilder.newBuilder()
                        .withTankId(moduleInfo.getTankId())
                        .customParam(ENGINE_ID_PARAM, moduleInfo.getTopModules().getEngineId())
                        .customParam(GUN_ID_PARAM, moduleInfo.getTopModules().getGunId())
                        .customParam(SUSPENSION_ID_PARAM, moduleInfo.getTopModules().getSuspensionId())
                        .customParam(RADIO_ID_PARAM, moduleInfo.getTopModules().getRadioId())
                        .customParam(TURRET_ID_PARAM, moduleInfo.getTopModules().getTurretId())
                        .build());
                Optional<Map<String, VehicleProfile>> content = profileAPIResponseMap.getContent();
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
//                Map<String, Object> params = new HashMap<>();
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
//    public AbstractAPIResponse<Info> getTankopediaAPIResponse(Map<String, Object> queryParams) {
//        String tankopediaAPIUrl = "https://api.worldoftanks.ru/wot/encyclopedia/info/";
//        String url = convertURL(queryParams, tankopediaAPIUrl);
//        JavaType type = objectMapper.getTypeFactory().constructParametrizedType(AbstractAPIResponse.class, AbstractAPIResponse.class, Info.class);
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
//    public String vehicleUri(Map<String, Object> queryParams) {
//        if (Objects.isNull(queryParams) || !queryParams.containsKey(TANK_ID_PARAM)) {
//            LOGGER.error("Tank id is required");
//            throw new RuntimeException("Tank id is required");
//        }
//        return convertURL(queryParams.entrySet().stream()
//                .filter(params ->
//                        VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()) ||
//                                VehicleProfileConstants.BASIC_API_CONSTANTS.contains(params.getKey()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)), VehicleProfileConstants.BASIC_URL);
//    }

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
