package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class UpLoadImg {
    private MultipartFile img;

    public UpLoadImg() {
    }

    public UpLoadImg(MultipartFile img) {
        this.img = img;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
