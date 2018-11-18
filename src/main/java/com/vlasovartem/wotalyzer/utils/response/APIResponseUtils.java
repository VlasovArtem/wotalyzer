package com.vlasovartem.wotalyzer.utils.response;

import com.vlasovartem.wotalyzer.entity.wot.api.response.APIResponse;

import java.util.*;

/**
 * Created by artemvlasov on 21/11/2016.
 */
public class APIResponseUtils {

    public static <F> List<F> convertMapToList(APIResponse<Map<String, F>> apiResponse) {
        if (Objects.nonNull(apiResponse)) {
            Optional<Map<String, F>> content = apiResponse.getContent();
            if (content.isPresent()) {
                return new ArrayList<>(content.get().values());
            }
        }
        return Collections.emptyList();
    }

    public static <F> Optional<F> convertMapToObject(APIResponse<Map<String, F>> apiResponse) {
        return convertMapToList(apiResponse).stream().findFirst();
    }

    public static <F> Optional<F> covertMapListToObject(APIResponse<Map<String, List<F>>> apiResponse) {
        if (Objects.nonNull(apiResponse)) {
            return apiResponse.getContent()
                    .orElse(Collections.emptyMap())
                    .values()
                    .stream()
                    .findFirst()
                    .orElse(Collections.emptyList())
                    .stream()
                    .findFirst();
        }
        return Optional.empty();
    }

}
