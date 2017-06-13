/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.services;

import com.codemark.domain.ImageCategoryENum;
import com.codemark.domain.category.CategoryRepository;
import com.codemark.domain.category.ImageCategory;
import com.codemark.domain.image.ImageRepository;
import com.codemark.domain.image.model.Image;
import com.codemark.domain.image.model.ImageData;
import com.codemark.domain.image.model.ImageDataThumbnail;
import com.codemark.webui.dto.GalleryCategory;
import com.codemark.webui.dto.GalleryData;
import com.codemark.webui.dto.ImageDto;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lukasz
 */
@Service
public class GalleryService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void add(byte[] image, String name, String description, Long categoryId) throws IOException {
        if (image == null || image.length == 0) {
            return;
        }
        Image entity = new Image();
        entity.setActive(true);
        entity.setCategory(categoryRepository.findOne(categoryId));
        entity.setDescription(description);
        entity.setName(name);
        entity.setImageData(new ImageData(image));
        entity.setThumbnail(new ImageDataThumbnail(convertToThumbnail(image)));
        entity = imageRepository.save(entity);
        entity.getId();
    }

    public GalleryData getGallery() {
        GalleryData result = new GalleryData();
        List<GalleryCategory> categories = new ArrayList<>();
        result.setCategories(categories);

        List<Image> entities = imageRepository.findAll();
        List<ImageCategory> categoriesEntity = categoryRepository.findAll();
        for (ImageCategory c : categoriesEntity) {
            GalleryCategory gCategory = new GalleryCategory();
            gCategory.setCode(c.getCode());
            gCategory.setName(c.getName());
            List<Image> gImages = entities.stream().filter(x -> x.getCategory().getId().equals(c.getId())).collect(Collectors.toList());
            gCategory.setImages(gImages.stream().map(this::map).collect(Collectors.toList()));
            categories.add(gCategory);
        }

        return result;
    }

    private ImageDto map(Image image) {
        ImageDto result = new ImageDto(image.getName(), image.getId(), image.getDescription());
        return result;
    }

    private byte[] convertToThumbnail(byte[] image) throws IOException {
        BufferedImage buffer = ImageIO.read(new ByteArrayInputStream(image));
        BufferedImage convertedImage = Scalr.resize(buffer, 280, 200, (BufferedImageOp) null);
        return ((DataBufferByte) convertedImage.getRaster().getDataBuffer()).getData();
    }

}
