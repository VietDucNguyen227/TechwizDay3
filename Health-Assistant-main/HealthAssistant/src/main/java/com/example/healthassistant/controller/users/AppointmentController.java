package com.example.healthassistant.controller.users;

import com.example.healthassistant.model.AppointmentStatus;
import com.example.healthassistant.model.Feedback;
import com.example.healthassistant.model.PersonalHealthVitals;
import com.example.healthassistant.model.Users;
import com.example.healthassistant.service.AppointmentStatusService;
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
import java.util.List;
import java.util.Optional;

@Controller
public class AppointmentController {
    @Autowired
    AppointmentStatusService appointmentStatusService;

    @Autowired
    UsersServiceImpl usersService;

    @GetMapping("/appointment/{id}")
    public String showAppointment(@PathVariable Long id,
                                     Model model){
        Optional<Users> users = usersService.findById(id);
        Optional<AppointmentStatus> appointment = appointmentStatusService.findbyUserId(id);
        if (appointment.isPresent()) {
            model.addAttribute("users", users.get());
            model.addAttribute("appointment", appointment.get());
            return "/web/user/personal";
        } else {
            return "not-found";
        }
    }

    @GetMapping("/health-personal")
    public String showNewAppointmentForm(Model model){
        AppointmentStatus appointment = new AppointmentStatus();
        model.addAttribute("appointment", appointment);
        return "/web/user/feedback-create";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("feedback") AppointmentStatus appointment) {
        appointmentStatusService.saveAppointment(appointment);
        return "redirect:/personal";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,
                                     Model model) {
        Optional<AppointmentStatus> appointment = appointmentStatusService.findbyUserId(id);
        model.addAttribute("appointment", appointment.get());
        return "/web/user/appointment-edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String updateAppointment(@PathVariable("id") Long id,
                               @Valid AppointmentStatus appointment,
                               BindingResult result) {
        appointment.setUserId(id);
        appointmentStatusService.saveAppointment(appointment);
        return "redirect:/personal-health/" + id;
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable (value = "id") long id) {
        this.appointmentStatusService.deleteAppointment(id);
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
