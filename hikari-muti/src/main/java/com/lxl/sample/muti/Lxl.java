package com.lxl.sample.muti;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lxl on 16/10/8.
 */
@Data
@ConfigurationProperties(prefix="lxl")
@Component
public class Lxl {
    private static final Logger LOGGER = LoggerFactory.getLogger(Lxl.class);

//    @Value("${lxl.vv}")
    private String vv;

    public void test(){
        LOGGER.error(vv);
    }
}
