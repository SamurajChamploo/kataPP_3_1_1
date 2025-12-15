package com.example.kataPP_3_1_1.controller;

import com.example.kataPP_3_1_1.model.User;
import com.example.kataPP_3_1_1.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("email") String email,
                          @RequestParam("age") Integer age,
                          @RequestParam("city") String city) {
        userService.saveUser(new User(firstName, lastName, email, age, city));
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", userService.getUserById(id));
        return "index";
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("age") Integer age,
                             @RequestParam("city") String city) {
        userService.updateUser(id, firstName, lastName, email, age, city);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
