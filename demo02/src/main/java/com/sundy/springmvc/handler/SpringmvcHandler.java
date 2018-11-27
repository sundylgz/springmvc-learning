package com.sundy.springmvc.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringmvcHandler {

    /**
     * 重定向
     */
    @RequestMapping("/testRedirectView")
    public String testRedirectView() {
        return "redirect:/ok.jsp";
    }

    /**
     * 视图 View
     */
    @RequestMapping("/testView")
    public String testView() {
        return "success";
    }

    /**
     * Model
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        //模型数据 : loginMsg=用户名或者密码错误
        System.out.println("##################" + model.getClass().getName());
        model.addAttribute("loginMsg", "用户名或者密码错误");
        return "success";
    }

    /**
     * Map
     * 结论: SpringMVC会把Map中的模型数据存放到request域对象中.
     * SpringMVC再调用完请求处理方法后，不管方法的返回值是什么类型，都会处理成一个ModelAndView对象（参考DispatcherServlet的945行）
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        //模型数据: password=123456
        System.out.println(map.getClass().getName()); //BindingAwareModelMap
        map.put("password", "123456");

        return "success";
    }

    /**
     * ModelAndView
     * 结论: Springmvc会把ModelAndView中的模型数据存放到request域对象中.
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //模型数据: username=Admin
        ModelAndView mav = new ModelAndView();
        //添加模型数据
        mav.addObject("username", "Admin");

        //设置视图信息
        mav.setViewName("success");

        return mav;
    }
}

