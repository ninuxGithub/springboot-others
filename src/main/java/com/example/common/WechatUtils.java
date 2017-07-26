package com.example.common;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by daile on 2017/6/28.
 */
@Slf4j
public class WechatUtils {


    public static String controlDevice(String controlDto) {
        String url = WechatConstant.CONTROL_URL;
        String result = HttpUtils.sendHttpPostRequest(url, controlDto);
        return result;
    }

}
