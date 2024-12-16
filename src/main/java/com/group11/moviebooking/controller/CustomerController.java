package com.group11.moviebooking.controller;


import com.group11.moviebooking.convert.MappingDTOtoJSON;
import com.group11.moviebooking.service.AdminService;
import com.group11.moviebooking.service.MovieService;
import com.group11.moviebooking.service.RevenueService;
import com.group11.moviebooking.entity.AdminEntity;
import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.service.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/")
public class CustomerController {
    private MovieService movieService;
    private RevenueService revenueService;
    private MappingDTOtoJSON map;
    private final AdminService adminService;
    private final CustomerService customerService;

    public CustomerController(AdminService adminService, CustomerService customerService) {
        this.adminService = adminService;
        this.customerService = customerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }



    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public String getSign(Model model1) {
        model1.addAttribute("SignUp", new CustomerEntity());
        model1.addAttribute("SignIn", new CustomerEntity());
        return "sign_in";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String getAbout() {
        return "about";
    }



    @RequestMapping(value = "/Customer", method = RequestMethod.GET)
    public List<CustomerEntity> getObject(Model model) {
        List<CustomerEntity> customers = this.customerService.getAllCustomers();
        model.addAttribute("customersList", customers);
//        return new ModelAndView("/tables-customer").addObject("customersList", customers);
//        return "tables-customer";
        return customers;
    }

    @RequestMapping(value = "/Customers", method = RequestMethod.GET)
    public String getCustomers(Model model) {
        List<CustomerEntity> customers = this.customerService.getAllCustomers();
        model.addAttribute("customersList", customers);
//        return new ModelAndView("/tables-customer").addObject("customersList", customers);
        return "tables-customer";
//        return customers;
    }

    @RequestMapping(value = "/e-ticket", method = RequestMethod.GET)
    public String getE_Ticket() {
        return "e-ticket";
    }

    @RequestMapping(value = "/Contact_Us", method = RequestMethod.GET)
    public String getContact_Us() {
        return "Contact_Us";
    }

    @RequestMapping(value = "/seat_sel", method = RequestMethod.GET)
    public String getSeat_Sel() {
        return "seat_sel";
    }

    @RequestMapping("/search_movie")
    public String getSearch_Movie() {
        return "search-movie";
    }

    @RequestMapping("/profile")
    public String getProfile() {
        return "users-profile";
    }

    @ModelAttribute("SignUp")
    public CustomerEntity signUpCustomer() {
        return new CustomerEntity();
    }

    @ModelAttribute("SignIn")
    public CustomerEntity signInCustomer() {
        return new CustomerEntity();
    }

    @PostMapping(value = "/register")
    public String register(Model model, @ModelAttribute("SignUp") CustomerEntity user_SignUp) {
        List<CustomerEntity> users = this.customerService.getAllCustomers();
        System.out.println(users);
        System.out.println("sign up " + user_SignUp);
//      Xử lý logic đăng ký
        if (this.customerService.getCustomerByEmail(user_SignUp.getCustomer_email()) == null) {
            System.out.println("sign up " + user_SignUp);
            this.customerService.add(user_SignUp);
            return "redirect:/home";
        }
        model.addAttribute("error", "Email already exists");
        return "sign_in";
    }

    @PostMapping(value = "/login")
    public String LoginCustomer(Model model, @ModelAttribute("SignIn") CustomerEntity user_SignIn) {
        List<CustomerEntity> users = this.customerService.getAllCustomers();
        System.out.println(users);
        // Xử lý logic đăng nhập
        System.out.println("sign in " + user_SignIn);
        if(this.adminService.getAdminByEmailAndPassword(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password()) != null){
            AdminEntity admin_SignIn = this.adminService.getAdminByEmailAndPassword(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password());
            System.out.println("sign in " + admin_SignIn);
            return "redirect:/dashboard";
        }
        if (this.customerService.checkUserToLogin(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password())) {
            user_SignIn = this.customerService.getCustomerByEmailAndPassword(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password());
            System.out.println("sign in " + user_SignIn);
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid email or password!\nor your account is disabled");
        return "sign_in";
    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String signInCustomer(String email, String password) {
//        List<CustomerEntity> users = this.customerService.getAllCustomers();
//        CustomerEntity user_SignIn = new CustomerEntity();
//        user_SignIn.setCustomer_email(email);
//        user_SignIn.setCustomer_password(password);
//        System.out.println(users);
////            System.out.println("sign in " + user_SignIn);
//        if (this.customerService.checkUserToLogin(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password())) {
//            user_SignIn = this.customerService.getCustomerByEmailAndPassword(user_SignIn.getCustomer_email(), user_SignIn.getCustomer_password());
//            System.out.println("sign in " + user_SignIn);
////            return "redirect:/dashboard";
//            return user_SignIn.toString();
//        }
////        model.addAttribute("error", "Invalid email or password!\nor your account is disabled");
//        return user_SignIn.toString();
//    }
//    @PostMapping("/login")
//    public CustomerDTO login(@RequestBody CustomerDTO user) {
//        return user;
//    }
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String signUnCustomer(@ModelAttribute("SignUp") CustomerEntity user_SignUp) {
//        System.out.println("sign up " + user_SignUp);
//        List<CustomerEntity> users = this.customerService.getAllCustomers();
//////        List<Customer> users = customerService.getAllCustomers();
////        System.out.println(users);
////        if (users.isEmpty()) {
////            return "sign_in";
////        }
////        System.out.println("sign in " + user_SignUp);
////        this.userRepository.save(user_SignIn);
//        System.out.println("fuckquery");
//        return "index";
//    }

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String signUpCustomer(@ModelAttribute("SignUp") CustomerDTO user_SignUp) {
//        System.out.println("sign up " + user_SignUp);
//        List<CustomerDTO> users = customerService.getAllCustomersByEmail(user_SignUp.getCustomerEmail());
////        List<Customer> users = customerService.getAllCustomers();
//        System.out.println(users);
//        if (users.isEmpty()) {
//            return "sign_in";
//        }
////        System.out.println("sign in " + user_SignUp);
////        this.userRepository.save(user_SignIn);
//        System.out.println("fuckquery");
//        return "index";
//    }
}
// @RestController
// public class CustomerController {
// private final CustomerService customerService;

// public CustomerController(CustomerService customerService) {
// this.customerService = customerService;
// }

// @GetMapping("/home")
// public String getHomePage() {
// return this.customerService.handleHello();
// }
// }
