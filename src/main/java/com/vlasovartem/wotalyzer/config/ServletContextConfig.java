package com.vlasovartem.wotalyzer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by artemvlasov on 05/12/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.vlasovartem.wotalyzer.controller", "com.vlasovartem.wotalyzer.exception"})
public class ServletContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("/");
    }

}
