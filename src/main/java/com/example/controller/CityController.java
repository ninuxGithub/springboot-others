package com.example.controller;

import com.example.Service.CityService;
import com.example.domain.City;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daile on 2017/7/8.
 */
@RestController
@RequestMapping("/city")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "获取城市信息",notes = "根据城市ID获取城市信息")
    @ApiImplicitParam(name = "id",value = "城市ID",paramType = "path",required = true,dataType = "Long")
    @GetMapping(value = "/{id}")
    public City getCity(@PathVariable("id") Long id){
        return cityService.getCityById(id);
    }
}
