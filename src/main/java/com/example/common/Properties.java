package com.example.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by daile on 2017/6/29.
 */
@Component
@Data
public class Properties {
    @Value("${name}")
    private String name;
    @Value("${desc}")
    private String desc;
}
