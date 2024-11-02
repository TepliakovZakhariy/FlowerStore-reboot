package ua.edu.ucu.apps.lab8.service;

import org.springframework.stereotype.Service;
import java.util.List;
import ua.edu.ucu.apps.lab8.model.AppUser;
import ua.edu.ucu.apps.lab8.repository.AppUserRepository;

@Service
public class AppUserService {
    
    private AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public AppUser createAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser getUserByEmail(String email) {
        return appUserRepository.findUserByEmail(email);
    }
}
