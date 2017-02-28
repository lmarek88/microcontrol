/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukasz
 */

@Service
public class ReferenceService {
    private String folderPath = "references/";
    public void getAll(){
    }
    
    public void download(Long id, HttpServletResponse response) throws IOException{
         String fileName = "test.pdf";
        ClassLoader classLoader = getClass().getClassLoader();
        response.setContentType("application/pdf");      
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName ); 
        InputStream inputStream = classLoader.getResourceAsStream(folderPath + fileName);        
        IOUtils.copy(inputStream, response.getOutputStream());

    }
    
    public void preview(Long id, HttpServletResponse response) throws IOException{
        String fileName = "test.pdf";
        ClassLoader classLoader = getClass().getClassLoader();
        response.setContentType("application/pdf");      
        response.setHeader("Content-Disposition", "inline; filename=" + fileName ); 
        InputStream inputStream = classLoader.getResourceAsStream(folderPath + fileName);        
        IOUtils.copy(inputStream, response.getOutputStream());
    }
}
