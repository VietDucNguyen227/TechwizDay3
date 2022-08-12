package com.example.healthassistant.controller.users;

import com.example.healthassistant.model.Feedback;
import com.example.healthassistant.model.Medicine;
import com.example.healthassistant.model.Users;
import com.example.healthassistant.service.MedicineServiceImp;
import com.example.healthassistant.service.UsersService;
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
public class MedicineController {
    @Autowired
    MedicineServiceImp medicineServiceImp;

    @Autowired
    UsersServiceImpl usersService;

    @GetMapping("/medicine/{id}")
    public String showFeedback(@PathVariable Long id,
                               Model model){
        Optional<Users> users = usersService.findById(id);
        Optional<Medicine> medicine = medicineServiceImp.findByUserId(id);
        if (medicine.isPresent()) {
            model.addAttribute("users", users.get());
            model.addAttribute("medicine", medicine.get());
            return "/web/user/personal";
        } else {
            return "not-found";
        }
    }

    @GetMapping("/health-personal")
    public String showNewFeedbackForm(Model model){
        Medicine medicine = new Medicine();
        model.addAttribute("medicine", medicine);
        return "/web/user/medicine-create";
    }

    @PostMapping("/saveMedicine")
    public String saveFeedback(@ModelAttribute("feedback") Medicine medicine) {
        medicineServiceImp.saveMedicine(medicine);
        return "redirect:/personal";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,
                                    Model model) {
        Optional<Medicine> medicine = medicineServiceImp.findByUserId(id);
        model.addAttribute("medicine", medicine.get());
        return "/web/user/medicine-edit";
    }
    //cai nay co can xoa ko vi ko co user id
//    @PostMapping(value = "/edit/{id}")
//    public String updateFeedback(@PathVariable("id") Long id,
//                                 @Valid Medicine medicine,
//                                 BindingResult result) {
//        medicine.setUserId(id);
//        medicineServiceImp.saveMedicine(medicine);
//        return "redirect:/personal-health/" + id;
//    }

    @GetMapping("/deletePersonalHealth/{id}")
    public String deleteFeedback(@PathVariable (value = "id") long id) {
        this.medicineServiceImp.deleteMedicine(id);
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
