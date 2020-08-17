package com.cdzci.zic_yt_test.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class WebController {
    @GetMapping(value = "/")
    public ModelAndView ss(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("index");
        modelAndView.addObject("path",request.getContextPath());
        return modelAndView;
    }
}
