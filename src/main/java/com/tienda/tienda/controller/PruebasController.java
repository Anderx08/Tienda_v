/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.controller;



import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.service.CategoriaService;
import com.tienda.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

     @Autowired
    ProductoService productoService;
     
     @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listado")
    public String inicio(Model model) {

        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalproductos", productos.size());
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);

        return "/pruebas/listado";
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {

        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        

        return "/pruebas/listado2";
    }
    
    @PostMapping("/query1")
    public String consulta1(@RequestParam(value="precioInf")double precioinf,
            @RequestParam(value="precioSub")double precioSup,Model model) {

        var productos = productoService.consultaQuery(precioinf, precioSup);
        model.addAttribute("productos", productos);
        

        return "/pruebas/listado2";
    }
    

}