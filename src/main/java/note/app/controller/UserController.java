package note.app.controller;

import note.app.exception.UserExists;
import note.app.form.LoginForm;
import note.app.form.UserRegisterForm;
import note.app.model.Note;
import note.app.model.User;
import note.app.repository.UserRepo;
import note.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Controller
public class UserController {


    private UserService userService;
    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/index")
    public String viewLoginPage(){
        return "index";
    }
    @GetMapping("/registration")
    public String viewRegistrationForm(Model model) {
        model.addAttribute("registration", new UserRegisterForm());

        return "registration";
    }
    @GetMapping("/login")
    public String viewLogin(Model model) {
        model.addAttribute("login", new LoginForm());

        return "login";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "registration_success";
    }

}