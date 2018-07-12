package com.tomorrow.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jin.zhang@fuwo.com on 2018/3/5.
 */
@RefreshScope
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @RequestMapping("/from")
    public String from() {
        return this.name;
    }

}
