package com.central1.treasury.bumblebee.controller;
import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/")
public class FileUploadController {
    @GetMapping
    public String main() {
        return "index";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
        try {
            file.transferTo( new File(file.getOriginalFilename()));
        } catch (Exception e) {
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return "redirect:/";
        } 
        return "redirect:/";
    }
}
