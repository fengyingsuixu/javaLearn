package com.lyh.context;

import com.lyh.samples.CBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lvyanghui
 * 2019/2/20 21:22
 */
@Configuration
public class AnnoConfiguration {

    @Bean
    public CBean CBean(){
        return new CBean();
    }
}
