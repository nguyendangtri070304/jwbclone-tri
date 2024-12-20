package com.group11.moviebooking.controller;

import com.group11.moviebooking.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getadmin() {
        return "redirect:/dashboard";
    }

//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public String getDashBoard() {
//        return "/dashboard";
//    }
}
