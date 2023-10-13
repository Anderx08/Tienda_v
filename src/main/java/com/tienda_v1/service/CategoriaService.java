/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_v1.service;

import com.tienda_v1.domain.Categoria;
import java.util.List;

/**
 *
 * @author user
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activo);
    
}
