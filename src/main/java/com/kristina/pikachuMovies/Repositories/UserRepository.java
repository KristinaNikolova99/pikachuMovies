/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kristina.pikachuMovies.Repositories;
import com.kristina.pikachuMovies.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author KRISI
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
}