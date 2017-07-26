package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by daile on 2017/7/13.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Neeson extends ResourceSupport {

    private String name;
    private int age;
}
