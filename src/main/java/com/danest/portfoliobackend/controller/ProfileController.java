package com.danest.portfoliobackend.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.danest.portfoliobackend.domain.Profile;
import com.danest.portfoliobackend.dto.ProjectDto;
import com.danest.portfoliobackend.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin

public class ProfileController {

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private final ProfileService profileService;

    ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    Profile getProfile() {
        return profileService.getProfile();
    }

    @PatchMapping
    Profile patchProfile(@RequestBody Map<String, String> partialProfile) {
        profileService.patchProfile(partialProfile);
        return profileService.getProfile();
    }

    @PostMapping("/picture")
    String saveProfilePicture(@RequestParam MultipartFile profilePicture) throws Exception {
        profileService.changeProfilePicture(profilePicture);
        return profileService.getProfile().getPicture().get().getUrl();
    }

    @PostMapping("/banner")
    String saveBannerImage(@RequestParam MultipartFile banner) throws Exception {
        profileService.changeBannerImage(banner);
        return profileService.getProfile().getBanner().get().getUrl();
    }

    @PostMapping("/test")
    void test(@RequestBody ProjectDto something) {
        logger.info("se recibio correctamente " + something.getImage().getOriginalFilename());
    }

}
