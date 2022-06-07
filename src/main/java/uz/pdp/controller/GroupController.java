package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.entity.Group;
import uz.pdp.entity.Group;
import uz.pdp.entity.Group;
import uz.pdp.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/all")
    public ModelAndView getAll(ModelAndView mv) {

        List<Group> studentList = groupRepository.read();
        System.out.println(studentList);
        mv.addObject("listGroup", studentList);
        mv.setViewName("readg");
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(ModelAndView mv) {
        mv.setViewName("createg");
        return mv;
    }

    @PostMapping("/add")
    public ModelAndView saveStudent(@ModelAttribute("group") Group group, ModelAndView mv) {
        int num = groupRepository.create(group);

        if (num == 0) {
            mv.addObject("ketmon", "Group qo'shishda xatolik");
        } else {
            mv.addObject("ketmon", "Group added!");
        }

        mv.setViewName("createg"); //create.jsp ni   web papkadam qidiradi
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable Integer id, ModelAndView mv) {
        Group studentById = groupRepository.findStudentById(id);
        List<Group> studentList = new ArrayList<>(List.of(studentById));
        mv.addObject("ketmon", studentList);
        mv.setViewName("updateg");
        return mv;
    }

    //    @PutMapping("/update/{id}") aslida http request bo'lsa
    @PostMapping("/update")
    public ModelAndView updateStudent(@ModelAttribute Group group, ModelAndView mv) {

        int counter = groupRepository.update(group);

        if (counter > 0) {
            mv.addObject("msg", "Group records updated against group id: " + group.getId());
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("updateg");

        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable Integer id, ModelAndView mv) {

        int counter = groupRepository.delete(id);

        if (counter > 0) {
            mv.addObject("msg", "Group records deleted against group id: " + id);
        } else {
            mv.addObject("msg", "Error- check the console log.");
        }

        mv.setViewName("deleteg");

        return mv;
    }
}
