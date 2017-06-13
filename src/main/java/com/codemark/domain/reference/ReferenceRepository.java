/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemark.domain.reference;

import com.codemark.domain.reference.model.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Lukasz
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long> {
    
}
