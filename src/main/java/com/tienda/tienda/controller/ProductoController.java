/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.controller;



import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.CategoriaService;
import com.tienda.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductoController {

     @Autowired
    ProductoService productoService;
     
     @Autowired
    CategoriaService categoriaService;
     
    
     

    @GetMapping("/producto/listado")
    public String inicio(Model model) {

        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalproductos", productos.size());
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/producto/listado";
    }

    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto) {
        return "/producto/modificar";
    }

    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model) {
        producto=productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";

    }
    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto){
        productoService.delete(producto);
            return "redirect:/producto/listado";
    }
 
}
