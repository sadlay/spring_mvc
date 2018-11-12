package com.lay.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("my")
@Controller
public class ParamController {
    /**
     * 在无注解下获取参数，要求参数名称和HTTP请求参数名称一致
     * @param intVal
     * @param longVal
     * @param str
     * @return 响应JSON参数
     */
    @GetMapping("/no/annotation")
    @ResponseBody
    public Map<String,Object> noAnnotation (Integer intVal,Long longVal,String str) {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("intVal",intVal);
        paramMap.put("longVal",longVal);
        paramMap.put("str",str);
        return paramMap;
    }
}
