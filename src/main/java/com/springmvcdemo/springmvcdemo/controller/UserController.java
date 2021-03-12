package com.springmvcdemo.springmvcdemo.controller;

import com.springmvcdemo.springmvcdemo.model.User;
import com.springmvcdemo.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.springmvcdemo.springmvcdemo.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Component
@RequestMapping("/")
public class UserController {
    @Qualifier("userService")
    @Autowired
    public UserService service;


    @GetMapping("signup")
    public String ShowSignup(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        service.saveUser(user);
        return "redirect:/index";
    }

    @PostMapping("/updateuser/{id}")
    public String updateUser(@PathVariable("id") long id, User user, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        service.saveUser(user);

        return "redirect:/index";

    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model)
    {
        User user = service.findById(id);
        service.deleteById(id);

        return "redirect:/index" ;
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", service.showUsers());

        return "index";
    }
}
