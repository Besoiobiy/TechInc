package com.TechInc.blog.controllers;
import com.TechInc.blog.services.PlaceService;
import com.TechInc.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.security.Principal;
@Controller
@RequiredArgsConstructor
public class MainController {
    private final PlaceService placeService;
    private final UserService userService;
    @GetMapping("/")
    public String index(Principal principal,Model model) {
        var user = placeService.getUserByPrincipal(principal);
        model.addAttribute("places", placeService.listPlace(user));
        model.addAttribute("user", user);

        return "index";
    }
    @GetMapping("/add")
    public String add(Principal principal,Model model) {
        model.addAttribute("user", placeService.getUserByPrincipal(principal));
        return "add";
    }
    @PostMapping("/place/add")
    public String addPlace(Principal principal, @RequestParam HashMap<String, String> formData) {
        formData.remove("_csrf");
        placeService.savePlace(principal, formData);
        return "redirect:/";
    }
    @GetMapping("/about")
    public String about(Principal principal,Model model) {
        model.addAttribute("user", placeService.getUserByPrincipal(principal));
        return "about";
    }
    @GetMapping("/place/checking/{id}")
    public String checking(Principal principal,@PathVariable Long id, Model model) {
        var user = placeService.getUserByPrincipal(principal);
        model.addAttribute("place", placeService.getPlaceById(id));
        model.addAttribute("user", user);
        return "checking";
    }
    @PostMapping("/place/delete/{id}")
    public String checkingDelete(@PathVariable("id") Long id) {
        placeService.deletePlace(id);
        return "redirect:/";
    }
    @PostMapping("/place/invert/{id}")
    public String checkingInvert(@PathVariable("id") Long id) {
        placeService.invertPlace(id);
        return "redirect:/";
    }
    @PostMapping("/place/accept/{id}")
    public String checkingAccept(@PathVariable("id") Long id, @RequestParam HashMap<String, String> formData) {
        formData.remove("_csrf");
        placeService.invertAccept(id, formData);
        return "redirect:/";
    }
    @GetMapping("/admin")
    public String admin(Principal principal, Model model) {
        model.addAttribute("users", userService.list());
        model.addAttribute("adminuser", placeService.getUserByPrincipal(principal));
        return "admin";
    }
    @PostMapping("/admin/user/ban/{email}")
    public String userBan(@PathVariable("email") String email) {
        userService.banUser(email);
        return "redirect:/admin";
    }
    @PostMapping("/admin/user/edit/{email}")
    public String userEdit(@PathVariable("email") String email) {
        userService.editUser(email);
        return "redirect:/admin";
    }
    @PostMapping("/admin/user/delete/{email}")
    public String userDelete(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return "redirect:/admin";
    }
//    @PostMapping("/admin/user/employ/{email}")
//    public String userEmploy(Principal principal,@PathVariable("email") String email) {
//        userService.employUser(email, placeService.getUserByPrincipal(principal));
//        return "redirect:/admin";
//    }
}