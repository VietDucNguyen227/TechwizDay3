package com.example.healthassistant.controller.users;

import com.example.healthassistant.common.Constants;
import com.example.healthassistant.model.PersonalHealthVitals;
import com.example.healthassistant.model.Roles;
import com.example.healthassistant.model.Users;
import com.example.healthassistant.payload.RegisterUser;
import com.example.healthassistant.service.PersonalHealthServiceImpl;
import com.example.healthassistant.service.RoleService;
import com.example.healthassistant.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    UsersService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    PersonalHealthServiceImpl personalHealthService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        return "/web/user/register";
    }

    @RequestMapping(value = "/registersubmit", method = RequestMethod.POST)
    public String registersubmit(@ModelAttribute RegisterUser registerUser) {
        if(userService.existsByUsername(registerUser.getUsername())) {
            //Co ton tai roi
        } else {
            //Chua ton tai username
            Users u = new Users();
            u.setUsername(registerUser.getUsername());
            u.setName(registerUser.getName());
            u.setEmail(registerUser.getEmail());
            u.setAvatar(registerUser.getAvatar());
            String password = encoder.encode(registerUser.getPassword());
            u.setPassword(password);

            Set<Roles> roles = new HashSet<Roles>();
            Roles r = roleService.findByName(Constants.ROLE_USER).get();
            roles.add(r);

            u.setRoles(roles);

            userService.saveUsers(u);
            PersonalHealthVitals personalHealthVitals = new PersonalHealthVitals(u.getId());
            personalHealthService.savePersonalHealth(personalHealthVitals);
        }
        return "redirect:/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        return "/web/user/login";
    }
}
