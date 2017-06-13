/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.webui;

import com.codemark.application.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lukasz
 */
@RestController
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getImage(@PathVariable Long id) {
        byte[] image = imageService.getImage(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @GetMapping(value = "/thumbnail/{id}")
    public ResponseEntity<?> getThumbnail(@PathVariable Long id) {
        byte[] image = imageService.getThumbnail(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }
}
