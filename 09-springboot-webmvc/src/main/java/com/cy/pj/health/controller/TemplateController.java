package com.cy.pj.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**@Controller描述的对象为spring框架管理的bean,
 * 这个通常会作为spring web模块的一个请求处理器对象*/
@Controller //这个注解用于告诉spring web模块这个对象是一个控制层请求响应处理器
public class TemplateController {//在spring mvc中称之为Handler

    /**借助@RequestMapping定义请求url到方法的映射
     * 访问:http://localhost/doTemplateUI
     */
    @RequestMapping("/doTemplateUI")
    public String doTemplateUI(Model model){//请问此方法谁来调用?DispatcherServlet
        model.addAttribute("viewName", "Default");
        return "default";//这个名字为view的名字
        //这里的返回值传给谁？DispatcherServlet
        //这个view的名字谁来解析？ViewResolver (ThymeleafViewResolver)
        //解析view时会做什么呢？
        //1)添加前缀和后缀(例如/templates/default.html)
        //2)对html页面中的元素进行解析(对特定属性进行处理)
    }
}
