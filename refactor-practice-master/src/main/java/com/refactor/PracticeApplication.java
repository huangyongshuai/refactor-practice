package com.refactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 公文流系统-启动项
 *
 * @author rockw
 */

@SpringBootApplication
public class PracticeApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(PracticeApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PracticeApplication.class);
        LOGGER.info("springboot 启动成功......");
    }
}
