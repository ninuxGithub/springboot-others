package com.example.Service.impl;

import com.example.Service.CityService;
import com.example.dao.CityDao;
import com.example.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daile on 2017/7/8.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City getCityById(Long id) {
        return cityDao.getCityById(id);
    }
}
