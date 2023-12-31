/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.tienda.dao;
import com.tienda.tienda.domain.Rol;
import com.tienda.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Usuario, Long> {    

    public void save(Rol rol);
    
}
