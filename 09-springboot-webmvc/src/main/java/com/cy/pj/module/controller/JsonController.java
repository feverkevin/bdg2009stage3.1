package com.cy.pj.module.controller;

import com.cy.pj.module.pojo.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
//@ResponseBody
@RestController //==@Controller+@ResponseBody
public class JsonController {

    //了解：底层如何将对象转换为字符串的
    @RequestMapping("/doReponseJsonString")
    //@ResponseBody
    public void doReponseJsonString(HttpServletResponse response) throws IOException {
        ResponseResult result=new ResponseResult();
        result.setCode(300);
        result.setMessage("服务端处理成功了");
        //构建jacson中的ObjectMappper对象，基于此对象将pojo对象转换为json字符串
        ObjectMapper objectMapper=new ObjectMapper();
        String jsonStr=objectMapper.writeValueAsString(result);
        //获取输出流对象
        //设置响应数据的编码
        response.setCharacterEncoding("utf-8");
        //告诉客户端,要向它响应的数据类型为text/html,编码为utf-8.请以这种编码进行数据呈现
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //基于流对象将json串写到客户端
        out.println(jsonStr);
    }
   //了解：自己拼接json串
    @RequestMapping("/doPrintJsonString")
    //@ResponseBody
    public String doPrintJsonString(){
        String jsonStr="{code:200,message:\"ok\"}";
        return jsonStr;
    }

    @RequestMapping("/doConvertListToJson")
    //@ResponseBody
    public List<Map<String,Object>> doConvertListToJson(){
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","tony");
        map.put("state", true);
        list.add(map);
        map=new HashMap<>();
        map.put("name","Jason");
        map.put("state", true);
        list.add(map);
        return list;
    }

    @RequestMapping("/doConvertMapToJson")
    //@ResponseBody
    public Map<String,Object> doConvertMapToJson(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","tony");
        map.put("state", true);
        return map;
    }
    /**
     *  @ResponseBody表示不再将响应结果理解为view，
     *  并将响应结果转换为json格式(前提是必须满足转换json格式数据条件)，
     *  写到响应体，响应到客户端
     *  @return
     */
     @RequestMapping("/doConvertResponseToJson")
     //@ResponseBody
     public ResponseResult doConvertResponseToJson(){
         ResponseResult result=new ResponseResult();
         result.setCode(200);
         result.setMessage("ok");
         return result;//==>{code:200,message:"ok"}
         //当此对象在返回时候，spring web模块会调用jackson api，将返回值转换为json格式字符串
         //底层转换原理分析？
         //基于pojo对象的get方法进行字符串的拼接
         //pojo中的get方法中，get单词后面的名字作为key(首字母小写),value为get方法的返回值
     }
}

