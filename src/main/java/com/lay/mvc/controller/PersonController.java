package com.lay.mvc.controller;

import com.lay.mvc.entity.Person;
import com.lay.mvc.enumeration.SexEnum;
import com.lay.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description:
 * @Author: lay
 * @Date: Created in 0:25 2018/11/11
 * @Modified By:IntelliJ IDEA
 */
@RequestMapping(value = "/person")
@Controller
public class PersonController {

    //注入用户服务类
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/getPerson")
    @ResponseBody
    public Person getPerson(@RequestParam("id") Long id) {
        return personService.getPerson(id);
    }

    //展示用户详情
    @RequestMapping("/details")
    public ModelAndView details(Long id) {
        Person perosn = personService.getPerson(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("person/details");
        mv.addObject("person", perosn);
        return mv;
    }

    @RequestMapping("/table")
    public ModelAndView table() {
        List<Person> personList = personService.getAllPersons();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("person/table");
        mv.addObject("personList", personList);
        return mv;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Person> list(
            @RequestParam(value = "personName", required = false) String personName,
            @RequestParam(value = "note", required = false) String note) {
        List<Person> personList=personService.findPersons(personName,note);
        return personList;
    }
    @RequestMapping("/add")
    public String add(){
        return "/person/add";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Person insert(@RequestBody Person person){
        personService.insertPerson(person);
        return person;
    }
    @RequestMapping("/sex")
    @ResponseBody
    public String sex(@RequestParam("sex") SexEnum sexEnum){
        String sexName=sexEnum.getName();
        return sexName;
    }
}
