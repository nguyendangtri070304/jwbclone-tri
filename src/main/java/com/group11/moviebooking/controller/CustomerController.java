package com.group11.moviebooking.controller;

import com.group11.moviebooking.Mapper.MappingDTOtoJSON;
import com.group11.moviebooking.entity.AdminEntity;
import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.entity.MovieEntity;
import com.group11.moviebooking.model.CustomerDTO;
import com.group11.moviebooking.model.MovieDTO;
import com.group11.moviebooking.model.RoomDTO;
import com.group11.moviebooking.service.*;
import com.group11.moviebooking.entity.AdminEntity;
import com.group11.moviebooking.entity.CustomerEntity;
import com.group11.moviebooking.service.CustomerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
@RequestMapping("/")
public class CustomerController {
    private RevenueService revenueService;
    private MappingDTOtoJSON map;
    private final AdminService adminService;
    private final CustomerService customerService;
    private final MovieService movieService;
    private final RoomService roomService;
    public CustomerController(AdminService adminService, CustomerService customerService, MovieService movieService, RoomService roomService) {
        this.adminService = adminService;
        this.customerService = customerService;
        this.movieService = movieService;
        this.roomService = roomService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        ArrayList<MovieDTO> movies = this.movieService.getallMoviesLimit(4);
        model.addAttribute("moviesBannerSlide", movies);
        System.out.println(movies);
        return "/home";
    }
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public String getSign(Model model1) {
        model1.addAttribute("SignUp", new CustomerDTO());
        model1.addAttribute("SignIn", new CustomerDTO());
        return "sign_in";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String getAbout(Model model) {
        List<MovieDTO> AllMovies = this.movieService.getallMovies();
        ArrayList<MovieDTO> movies = this.movieService.getallMoviesLimit(4);
        List<RoomDTO> allRooms = this.roomService.getAllRoom();

        model.addAttribute("moviesSize", AllMovies.size());
        model.addAttribute("roomsSize", allRooms.size());
        model.addAttribute("customers_size", this.customerService.getAllCustomers().size());

        model.addAttribute("moviesBannerSlide", movies);
        return "about";
    }

//    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
//    public String getDashBoard() {
//        return "dashboard";
//    }

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
    public CustomerDTO signUpCustomer() {
        return new CustomerDTO();
    }

    @ModelAttribute("SignIn")
    public CustomerDTO signInCustomer() {
        return new CustomerDTO();
    }

    @PostMapping(value = "/register")
    public String register(Model model, @ModelAttribute("SignUp") CustomerDTO user_SignUp) {
//      Xử lý logic đăng ký
        if (!this.customerService.CheckCustomerToRegister(user_SignUp)) {
            model.addAttribute("error", "Confirm invalid password");
            return "sign_in";
        }
        if (this.customerService.getCustomerByEmail(user_SignUp.getCustomer_email()) != null) {
            model.addAttribute("error", "Email already exists");
            return "sign_in";
        }
        CustomerEntity user_SignUpEntity = this.customerService.ConvertCustomerDTOtoCustomer(user_SignUp);
        System.out.println("sign up " + user_SignUpEntity);
        this.customerService.registerCustomer(user_SignUpEntity);
        return "redirect:/home";
    }

    @PostMapping(value = "/login")
    public String LoginCustomer(Model model, @ModelAttribute("SignIn") CustomerDTO user_SignInDTO) {
        CustomerEntity user_SignIn = this.customerService.ConvertCustomerDTOtoCustomer(user_SignInDTO);

        String email = user_SignIn.getCustomer_email();
        String password = user_SignIn.getCustomer_password();

        AdminEntity adminSignIn = this.adminService.getAdminByEmailAndPassword(email, password);
        if (adminSignIn != null) {
            return "redirect:/dashboard";
        }

        if (this.customerService.checkUserToLogin(email, password)) {
            CustomerEntity loggedInCustomer = this.customerService.getCustomerByEmailAndPassword(email, password);
            System.out.println("Sign in successful: " + loggedInCustomer);
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
