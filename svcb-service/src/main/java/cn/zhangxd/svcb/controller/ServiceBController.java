package cn.zhangxd.svcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ServiceBController {

    @Autowired
    private Registration registration; // 服务注册

    @Value("${msg:unknown}")
    private String msg;

    @GetMapping(value = "/")
    public String printServiceB() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" + registration.getPort() + ")" + "===>Say " + msg;
    }
}