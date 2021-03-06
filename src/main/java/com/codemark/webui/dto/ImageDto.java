/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.webui.dto;

/**
 *
 * @author Lukasz
 */
public class ImageDto {
    private String name;
    private Long imageId;
    private String url;
    private String description;

    public ImageDto() {
    }

    public ImageDto(String name, String url, String description) {
        this.name = name;
        this.url = url;
        this.description = description;
    }

    public ImageDto(String name, Long imageId, String description) {
        this.name = name;
        this.imageId = imageId;
        this.url = url;
        this.description = description;
    }
    

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    
}
