package com.cy.pj.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AjaxController {
    //假设这是数据库中表
    private List<Map<String,Object>> list=new ArrayList<>();
    public AjaxController(){//构建对象时，在构造方法中初始化一部分数据
        Map<String,Object> map=new HashMap<>();
        map.put("id","100");
        map.put("name", "华为");
        map.put("remark", "Very Good");
        list.add(map);
    }

    @PutMapping("/doAjaxPut")
    @ResponseBody
    public String doAjaxPut(@RequestParam Map<String,Object> map){
        String id=(String)map.get("id");
        Iterator<Map<String,Object>> it=list.iterator();
        Map<String,Object> obj=null;
        while(it.hasNext()){
            obj=it.next();
            if(obj.get("id").equals(id))break;
        }
        obj.put("name", map.get("name"));
        obj.put("remark", map.get("remark"));
        return "update ok";
    }

    @ResponseBody
    @DeleteMapping("/doAjaxDelete/{id}")
    public String doAjaxDelete(@PathVariable  Integer id){
        Iterator<Map<String,Object>> it=list.iterator();
        while(it.hasNext()){
            Map<String,Object> map=it.next();
            if(map.get("id").equals(String.valueOf(id))){
                it.remove();//用迭代器去删除
                //list.remove(map);//不可以这样删除，有并发异常
            }
        }
        return "delete ok";
    }

    @ResponseBody
    //@PostMapping 注解描述的方法表示只能处理Post请求方式的映射
    @PostMapping("/doAjaxPost")
    //@RequestMapping(value="/doAjaxPost",method = RequestMethod.POST)
    public String doAjaxPost(@RequestParam Map<String,Object> map){
        list.add(map);
        return "save ok";
    }

    @CrossOrigin //此注解描述的方法允许跨域访问
    //@GetMapping 注解描述的方法表示只能处理Get请求方式的映射
    @GetMapping("/doAjaxGet")
    //@RequestMapping(value="/doAjaxGet",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> doAjaxGet(){
        return list;
    }


    //============Ajax方式的请求===================
    @RequestMapping("/doAjaxStart")
    @ResponseBody
    public String doAjaxStart() throws InterruptedException {
        Thread.sleep(5000);
        return "Response Result Of Ajax Get Request 01 ";
    }
    //===========传统方式的页面请求=================
    @RequestMapping("/doNotAjaxUI")
    public String doNotAjaxUI(){
        return "not-ajax-01";
    }
    @RequestMapping("/doNotAjaxStart")
    public String doNotAjaxStart(Model model){
         model.addAttribute("result", "do not ajax request result");
         return "not-ajax-01";//请问这是局部刷新，还是全局
    }

}
