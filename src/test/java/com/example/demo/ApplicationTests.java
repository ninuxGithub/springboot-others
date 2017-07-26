package com.example.demo;

import com.example.common.Properties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

    @Autowired
    private Properties properties;

    @Test
    public void propertiesTest() {
        Assert.assertEquals("neeson", properties.getName());
        if (log.isDebugEnabled()) {
            log.debug(properties.getDesc());
        }
    }

}
