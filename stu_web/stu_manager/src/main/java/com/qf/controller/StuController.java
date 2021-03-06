package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author zqq
 * @version 1.0
 * @Date 2019/11/30
 */
@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IStuService stuService;

    @RequestMapping("/selectAll")
    public String selectAll(ModelMap map){
        List<Student> students = stuService.searchAll();
        map.put("student", students);
        System.out.println("students"+students);
        return "student";
    }

    @RequestMapping("deleteById")
    public String deleleById(int id){
        stuService.deleteById(id);
        return "redirect:/stu/selectAll";
    }
    @RequestMapping("getStuById")
    public String getStuById(int id, Model model){
         Student student=stuService.getStuById(id);
         model.addAttribute("stu",student);
        return "update_student";
    }

    @RequestMapping("updateById")
    public String updateById(Student student){
        stuService.updateById(student);
        return "redirect:/stu/selectAll";
    }

    @RequestMapping("backIndex")
    public String backIndex(){
        return  "index";
    }


}
