package com.andrew.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConfigBean Class
 *
 * @author andrew
 * @date 2020/5/15
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //客户端负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
     * 定义负载均衡算法
     * 1 RoundRobbinRule 轮询
     *
     * 2 RandomRule 随机
     *
     * 3 AvailabilityFilteringRule 过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数大于阈值的服务
     *                           对剩余的服务器列表进行轮询
     *
     * 4 WeightedResponseTimeRule 根据平均响应时间计算所有的服务的权重，响应时间越快的服务权重越大被选中的几率越高
     *                          刚启动信息不足时使用轮询，信息足够后再切换为此算法
     *
     * 5 RetryRule 先按照轮询策略，如果获取服务失败则在指定时间内会进行重试，获取可用服务
     *
     * 6 BestAvailableRule 过滤掉由于多次访问故障而处于断路器跳闸状态的服务
     *                   然后选择一个并发量小的服务
     *
     * 7 ZoneAvoidanceRule 默认规则，复合判断server所在区域的性能和server的可用性，选择服务器
     *
     */
    @Bean
    public IRule myCustomRule(){
        return new RandomRule();
    }

}
