/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.services;

import com.codemark.application.dto.GalleryCategory;
import com.codemark.application.dto.GalleryData;
import com.codemark.application.dto.Image;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukasz
 */
@Service
public class GalleryService {
    
    public GalleryData getData(){
        GalleryData result = new GalleryData();
        List<GalleryCategory> categories = new ArrayList<>();
        result.setCategories(categories);
        categories.add(new GalleryCategory());
        GalleryCategory category = new GalleryCategory();
        List<Image> images = new ArrayList<>();
        category.setName("Automatyka");
        category.setImages(images);
        images.add(new Image("Image1", "url", "To jest extraśny wypaśny obrazek"));
        images.add(new Image("Image2", "url", "To jest extraĹ›ny wypaĹ›ny obrazek1"));
        images.add(new Image("Image3", "url", "To jest extraĹ›ny wypaĹ›ny obrazek2"));
        images.add(new Image("Image4", "url", "To jest extraĹ›ny wypaĹ›ny obraze3"));
        
        categories.add(category);
        
        return result;
    }
}
