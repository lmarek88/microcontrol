/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.services;

import com.codemark.domain.ImageCategory;
import com.codemark.webui.dto.GalleryCategory;
import com.codemark.webui.dto.GalleryData;
import com.codemark.webui.dto.Image;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukasz
 */
@Service
public class GalleryService {
    
    public GalleryData getGallery(){
        GalleryData result = new GalleryData();
        List<GalleryCategory> categories = new ArrayList<>();
        result.setCategories(categories);
        
        
        categories.add(createCategory("Elektronika", ImageCategory.ELECTRONICS.toString()));
        categories.add(createCategory("Automatyka i budowa maszyn", ImageCategory.AUTOMATION.toString()));
        categories.add(createCategory("Elektryka, sieci strukturalne i CCTV", ImageCategory.ELECTRICS.toString()));
        categories.add(createCategory("SAP i DSO", ImageCategory.SAPDSO.toString()));
                
        return result;
    }
    
    private GalleryCategory createCategory(String name, String code){
        GalleryCategory category = new GalleryCategory();
        List<Image> images = new ArrayList<>();
        
        images.add(new Image("Image1", "http://placehold.it/300x250", "To jest extraśny wypaśny obrazek"));
        images.add(new Image("Image2", "http://placehold.it/300x250", "To jest extraśny wypaś›ny obrazek1"));
        images.add(new Image("Image3", "http://placehold.it/300x250", "To jest extraśny wypaś›ny obrazek2"));
        images.add(new Image("Image4", "http://placehold.it/300x250", "To jest extraśny wypaś›ny obraze3"));
        
        category.setImages(images);
        category.setName(name);
        category.setCode(code);
        return category;
    }
}
