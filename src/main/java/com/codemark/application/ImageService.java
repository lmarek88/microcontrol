/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.application;

import com.codemark.domain.image.ImageRepository;
import com.codemark.domain.image.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukasz
 */
@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    
    public byte[] getImage(Long id){
        Image entity = imageRepository.findOne(id);
        if(entity != null){
            return entity.getImageData().getImage();
        }
        return null;
    }
    
    public byte[] getThumbnail(Long id){
        Image entity = imageRepository.findOne(id);
        if(entity != null){
            return entity.getThumbnail().getImage();
        }
        return null;
    }   
}
