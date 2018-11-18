package com.vlasovartem.wotalyzer.utils.wot;

import com.vlasovartem.wotalyzer.config.AppConfig;
import com.vlasovartem.wotalyzer.utils.api.contstans.BasicAPIConstants;
import com.vlasovartem.wotalyzer.utils.wot.account.PlayerAchievementsUtilsTest;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.APPLICATION_ID_PARAM;
import static com.vlasovartem.wotalyzer.utils.api.contstans.WOTAPIConstants.FIELDS_PARAM;

/**
 * Created by artemvlasov on 24/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@PrepareForTest({MainUtils.class})
public abstract class BasicWotTest {

    @Value("${applicationId:#{null}}")
    private String applicationId;

    @Mock
    protected RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    protected String buildUri(Map<String, Object> queryParams, BasicAPIConstants constants) {
        Map<String, Object> collect = queryParams.entrySet().stream()
                .filter(params ->
                        constants.getBasicApiConstants().contains(params.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        String convertedBasicUrl = constants.getBasicUrl().endsWith("/") ? constants.getBasicUrl() : constants.getBasicUrl() + "/";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(convertedBasicUrl);
        builder.queryParam(APPLICATION_ID_PARAM, applicationId);
        collect.entrySet()
                .forEach(entry -> {
                    if (FIELDS_PARAM.equals(entry.getKey())) {
                        if (entry.getValue() instanceof List) {
                            builder.queryParam(entry.getKey(), ((List) entry.getValue()).stream().collect(Collectors.joining(",")).toString());
                        } else {
                            builder.queryParam(entry.getKey(), entry.getValue());
                        }
                    } else {
                        builder.queryParam(entry.getKey(), entry.getValue());
                    }
                });
        return builder.build().encode().toString();
    }

    protected ResponseEntity<String> getResponseEntity(String filePath) {
        return ResponseEntity.ok(getDataFromSource(filePath));
    }

    ResponseEntity<String> getErrorResponseEntity() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(getDataFromSource("wot-api-response-example/errorExample.json"));
    }

    private String getDataFromSource(String source) {
        InputStream resourceAsStream = PlayerAchievementsUtilsTest.class.getClassLoader().getResourceAsStream(source);
        if (Objects.nonNull(resourceAsStream)) {
            try {
                return  IOUtils.toString(resourceAsStream, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

}
