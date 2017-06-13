/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lukasz
 */
public interface CategoryRepository extends JpaRepository<ImageCategory, Long>{
    
}
