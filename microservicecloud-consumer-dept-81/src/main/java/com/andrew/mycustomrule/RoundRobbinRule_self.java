package com.andrew.mycustomrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * RoundRobbinRule_self Class
 *
 * @author andrew
 * @date 2020/5/17
 */
public class RoundRobbinRule_self extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    public Server choose(ILoadBalancer lb, Object key) {

        if(lb==null){
            return null;
        }

        Server server = null;

        while(server==null){
            if(Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if(serverCount == 0){
                return null;
            }

            /*
            int index = rand.nextInt(serverCount);
            server = upList.get(index);
            */

            if(total < 5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex = (currentIndex + 1)%upList.size();
            }

            if(server == null){
                Thread.yield();
                continue;
            }

            if(server.isAlive()){
                return server;
            }
            server = null;
            Thread.yield();
        }

        return server;
    }
}
