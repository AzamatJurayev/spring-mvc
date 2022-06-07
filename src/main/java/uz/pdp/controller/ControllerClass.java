package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.ClassCom;
import uz.pdp.entity.ClassCom;
import uz.pdp.repository.ClassRepositoryC;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("class")
public class ControllerClass {

    @Autowired
    ClassRepositoryC classRepositoryC;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv){
        List<ClassCom> classList = classRepositoryC.read();
        mv.addObject("listClass",classList);
        mv.setViewName("read");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv){
        mv.setViewName("create");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveClass(@ModelAttribute("classcom") ClassCom classcom,ModelAndView mv){
        int num = classRepositoryC.create(classcom);

        if (num == 0) {
            mv.addObject("ketmon", "Class qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Class added!");
        }

        mv.setViewName("create"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        ClassCom studentById = classRepositoryC.findStudentById(id);
        List<ClassCom> classComList = new ArrayList<>(List.of(studentById));
        mv.addObject("ketmon", classComList);
        mv.setViewName("update");
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView updateStudent(@ModelAttribute ClassCom classCom, ModelAndView mv) {

        int counter = classRepositoryC.update(classCom);

        if (counter > 0) {
            mv.addObject("msg", "Class records updated against class id: " + classCom.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("update");

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable Integer id, ModelAndView mv) {

        int counter = classRepositoryC.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Class records deleted against class id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("delete");

        return mv;
    }


}
