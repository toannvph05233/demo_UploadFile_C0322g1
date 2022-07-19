package com.codegym.controller;

import com.codegym.model.UpLoadImg;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin("*")
public class RestProductController {
    @PostMapping("/up")
    public String create(@RequestPart("file") MultipartFile file){
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/C0322g1_QLSP/src/main/webapp/WEB-INF/img/" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "abc";
    }
}
