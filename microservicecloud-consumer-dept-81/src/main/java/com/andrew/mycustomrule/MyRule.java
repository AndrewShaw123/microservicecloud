package com.andrew.mycustomrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyRule Class
 *
 * @author andrew
 * @date 2020/5/17
 */
@Configuration
public class MyRule {

    @Bean
    public IRule oneServerFiveTimeRoundRobbinRule(){
        return new RoundRobbinRule_self();
    }

}
