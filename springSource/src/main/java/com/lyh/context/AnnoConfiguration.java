package com.lyh.context;

import com.lyh.condition.LinuxConditon;
import com.lyh.condition.WindowCondition;
import com.lyh.samples.CBean;
import com.lyh.samples.DBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lvyanghui
 * 2019/2/20 21:22
 */
@Configuration
//@Conditional({WindowCondition.class})
public class AnnoConfiguration {

    @Bean("cBean")
    @Conditional(WindowCondition.class)
    public CBean CBean(){
        return new CBean();
    }

    @Bean("dBean")
    @Conditional(LinuxConditon.class)
    public DBean DBean(){
        return new DBean();
    }
}
