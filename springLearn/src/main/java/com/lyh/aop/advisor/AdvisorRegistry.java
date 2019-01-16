package com.lyh.aop.advisor;

import java.util.List;

/**
 * Created by lvyanghui
 * 2019/1/16 21:32
 */
public interface AdvisorRegistry {
    void registryAdvisor(Advisor advisor);

    List<Advisor> getAdvisors();
}
