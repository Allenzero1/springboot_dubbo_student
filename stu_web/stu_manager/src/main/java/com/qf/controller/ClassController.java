package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Class;
import com.qf.service.IClassService;
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
@RequestMapping("/cls")
public class ClassController {

    @Reference
    private IClassService classService;

    @RequestMapping("/selectAll")
    public String selectAll(ModelMap map){
        List<Class> classes = classService.searchAll();
        map.put("classes", classes);
        System.out.println("classes"+classes);
        return "classes";
    }

    @RequestMapping("deleteById")
    public String deleleById(int id){
        classService.deleteById(id);
        return "redirect:/cls/selectAll";
    }
    @RequestMapping("getClsById")
    public String getClsById(int id, Model model){
        Class classes=classService.getClsById(id);
        model.addAttribute("cls",classes);
        return "update_classes";
    }

    @RequestMapping("updateById")
    public String updateById(Class classes){
        classService.updateById(classes);
        return "redirect:/stu/selectAll";
    }

    @RequestMapping("backIndex")
    public String backIndex(){
        return  "index";
    }

}
