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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lukasz
 */
@RestController
public class GalleryController {
    
    @Autowired
    GalleryService galleryService;
    
    @RequestMapping(value="/gallery/getData" ,method = RequestMethod.GET)
    public ResponseEntity<?> getGalleryData(){
        return new ResponseEntity<>(galleryService.getData(), HttpStatus.OK);
    }
}
