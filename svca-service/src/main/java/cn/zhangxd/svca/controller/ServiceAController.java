package cn.zhangxd.svca.controller;

import cn.zhangxd.svca.client.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RefreshScope
@RestController
public class ServiceAController {

    @Value("${name:unknown}")
    private String name;

    @Autowired
    private Registration registration; // 服务注册
    @Autowired
    private ServiceBClient serviceBClient;

    @GetMapping(value = "/")
    public String printServiceA() {
        return registration.getServiceId() + " (" + registration.getHost() + ":" + registration.getPort() + ")" + "===>name:" + name + "<br/>" + serviceBClient.printServiceB();
    }

    @GetMapping(path = "/current")
    public Principal getCurrentAccount(Principal principal) {
        return principal;
    }
}