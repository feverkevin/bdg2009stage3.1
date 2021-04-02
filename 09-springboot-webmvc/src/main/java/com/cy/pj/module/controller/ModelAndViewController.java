package com.cy.pj.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ModelAndViewController {

      @RequestMapping("/doModelAndView01")
      public String doModelAndView(Model model){
          model.addAttribute("name","jason");
          model.addAttribute("state", "ok");
          return "view";
      }

      @RequestMapping("/doModelAndView02")
      public ModelAndView doModelAndView02(ModelAndView mv){
          mv.addObject("name", "jason");
          mv.addObject("state", true);
          mv.setViewName("view");
          return mv;
      }//这里的modelandview是model对象和view的对象的一个合体

      @RequestMapping("/doModelAndView03")
      public ModelAndView doModelAndView03(ModelAndView mv){
          List<String> list=new ArrayList<String>();
          list.add("北京");
          list.add("上海");
          list.add("深圳");
          mv.addObject("citys", list);
          mv.setViewName("view");
          return mv;
      }
}
