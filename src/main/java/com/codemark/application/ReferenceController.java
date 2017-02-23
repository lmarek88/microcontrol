/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.application;

import com.codemark.services.ReferenceService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lukasz
 */
@RestController
@RequestMapping(value = "/reference")
public class ReferenceController {

    @Autowired
    ReferenceService referenceService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        referenceService.getAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> download(@RequestParam long id, HttpServletResponse response) {
        referenceService.download(id, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> preview(@RequestParam Long id, HttpServletResponse response) {
        referenceService.preview(id ,response);        
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
