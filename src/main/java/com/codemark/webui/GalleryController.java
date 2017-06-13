/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.webui;

import com.codemark.services.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lukasz
 */
@RestController
@RequestMapping(value = "/api/gallery")
public class GalleryController {

    @Autowired
    GalleryService galleryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getGallery() {
        return new ResponseEntity<>(galleryService.getGallery(), HttpStatus.OK);
    }

    @PostMapping
    public void add(@RequestParam MultipartFile file, @RequestParam String name, @RequestParam String description, @RequestParam Long categoryId) throws Exception {
        try {
            String s = "";
            byte[] image = file.getBytes();
            galleryService.add(image, name, description, categoryId);
        } catch (Exception e) {
            
        }  
    }
}
