package com.cy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LogTests {
    private static final Logger log= LoggerFactory.getLogger(LogTests.class);

    @Test
    void testLogLevel(){//日志级别 trace<debug<info<error
        log.trace("test log trace");
        log.debug("test log debug");
        log.info("test log info");
        log.error("test log error");
    }//通过日志级别控制日志的输出，比方说我们配置的是info级别，那此级别或高于这个级别的日志都会输出
}
