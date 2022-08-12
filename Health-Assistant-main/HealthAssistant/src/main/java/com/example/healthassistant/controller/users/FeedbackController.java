package com.example.healthassistant.controller.users;

import com.example.healthassistant.model.Feedback;
import com.example.healthassistant.model.PersonalHealthVitals;
import com.example.healthassistant.model.Users;
import com.example.healthassistant.service.FeedBackServiceImp;
import com.example.healthassistant.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class FeedbackController {
    @Autowired
    UsersServiceImpl usersService;

    @Autowired
    FeedBackServiceImp feedBackServiceImp;

    @GetMapping("/feedback/{id}")
    public String showFeedback(@PathVariable Long id,
                                     Model model){
        Optional<Users> users = usersService.findById(id);
        Optional<Feedback> feedback = feedBackServiceImp.findByUserId(id);
        if (feedback.isPresent()) {
            model.addAttribute("users", users.get());
            model.addAttribute("feedback", feedback.get());
            return "/web/user/personal";
        } else {
            return "not-found";
        }
    }

    @GetMapping("/health-personal")
    public String showNewFeedbackForm(Model model){
        Feedback feedback = new Feedback();
        model.addAttribute("feedback", feedback);
        return "/web/user/feedback-create";
    }

    @PostMapping("/saveFeedback")
    public String saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedBackServiceImp.saveFeedback(feedback);
        return "redirect:/personal";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,
                                     Model model) {
        Optional<Feedback> feedback = feedBackServiceImp.findByUserId(id);
        model.addAttribute("feedback", feedback.get());
        return "/web/user/feedback-edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateFeedback(@PathVariable("id") Long id,
                               @Valid Feedback feedback,
                               BindingResult result) {
        feedback.setUserId(id);
        feedBackServiceImp.saveFeedback(feedback);
        return "redirect:/personal-health/" + id;
    }

    @GetMapping("/deletePersonalHealth/{id}")
    public String deleteFeedback(@PathVariable (value = "id") long id) {
        this.feedBackServiceImp.deleteFeedback(id);
        return "redirect:/personal-health";
    }

    @GetMapping(path = {"/index", "/", "/home"})
    public String index(Model model) {
        return "/web/user/index";
    }

    @GetMapping(path = {"/user"})
    public String showUserIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Users u = usersService.findByUsername(username);
        model.addAttribute("user", u);
        //Object o = authentication.getPrincipal();
        return "/web/user/index-user";
    }

    @GetMapping(path = "/health-assistant")
    public String assistant(Model model) {
        return "/web/user/assistant";
    }
}
