package ua.edu.ucu.apps.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import ua.edu.ucu.apps.lab8.model.AppUser;
import ua.edu.ucu.apps.lab8.service.AppUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {

    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    public List<AppUser> getAppUsers() {
        return appUserService.getAppUsers();
    }

    @PostMapping("/user")
    public AppUser creatAppUser(@RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @GetMapping("/user/email")
    public ResponseEntity<AppUser> getUserByEmail(@RequestParam String email) {
        AppUser userByEmail = appUserService.getUserByEmail(email);
        if (userByEmail != null) {
            return ResponseEntity.ok(userByEmail);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
