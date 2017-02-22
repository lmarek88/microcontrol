/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.application.dto;

import java.util.List;

/**
 *
 * @author Lukasz
 */
public class GalleryData {
    List<GalleryCategory> categories;

    public List<GalleryCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<GalleryCategory> categories) {
        this.categories = categories;
    }
    
    
}
