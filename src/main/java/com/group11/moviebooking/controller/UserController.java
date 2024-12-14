package com.group11.moviebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group11.moviebooking.service.UserService;

@Controller
public class UserController {

}
// @RestController
// public class UserController {
// private final UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/home")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }