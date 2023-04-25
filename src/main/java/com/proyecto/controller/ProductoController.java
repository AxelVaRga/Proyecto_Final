package com.proyecto.controller;

import com.proyecto.domain.Producto;
import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/productos")
public class ProductoController {
   @Autowired
   private ProductoService productoService;
       
      @GetMapping("/Inventario")
    public String inicio(Model model) {
        var productos=productoService.getProductos(false);
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos", productos.size());
        return "/productos/Inventario";
    }
    @GetMapping("/eliminar/{idProducto}")
    public String eliminaProducto(Producto producto){
        productoService.deleteProducto(producto);
        return "redirect:/productos/Inventario";
    }
    @GetMapping("/nuevo") 
    public String nuevoproducto(Producto producto){
        return "/productos/modifica";
    }
    @PostMapping("/guardar")
    public String guardarProducto(Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/productos/Inventario";
    }
    @GetMapping("/modificar/{idProducto}") 
    public String modificaProducto(Producto producto, Model model){     
        producto=productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/productos/modifica";
    }
}


