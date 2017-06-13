/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.domain.image.model;

import com.codemark.domain.category.ImageCategory;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Lukasz
 */
@Entity
@Table(name = "MC_IMAGE")
public class Image implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "ACTIVE")
    private boolean active;
    
    @Column(name = "SEQ")
    private int order;
    
    @ManyToOne
    @JoinColumn(name = "IMAGE_CATEGORY_ID", columnDefinition = "ID")
    private ImageCategory category;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_DATA_ID", columnDefinition = "ID")
    private ImageData imageData;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_DATA_M_ID", columnDefinition = "ID")
    private ImageDataThumbnail thumbnail;

    public Image() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ImageCategory getCategory() {
        return category;
    }

    public void setCategory(ImageCategory category) {
        this.category = category;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public void setImageData(ImageData imageData) {
        this.imageData = imageData;
    }

    public ImageDataThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageDataThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    
}
