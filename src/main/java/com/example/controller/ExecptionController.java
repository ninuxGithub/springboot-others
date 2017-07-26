package com.example.controller;

import com.example.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by daile on 2017/7/3.
 */
@Controller
public class ExecptionController {

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String hello() throws Exception {
        throw new Exception("error1");
    }

    @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public String json() throws MyException {
        throw new MyException("error2");
    }

    //局部异常处理
    /*@ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException me){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(me.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(request.getRequestURL().toString());
        return r;
    }*/
}
