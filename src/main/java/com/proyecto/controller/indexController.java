package com.proyecto.controller;

import com.proyecto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("/finnk/Productos")
    public String categoriaRopa(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/catalogos/Productos";
    }

    @GetMapping("/finnk/New arrivals")
    public String categoriaNewArrivals(Model model) {
        return "/informativo/New arrivals";
    }

    @GetMapping("/finnk/blogs")
    public String categoriaBlogs(Model model) {
        return "/informativo/blogs";
    }

    @GetMapping("/finnk/informacion")
    public String categoriaInformacion(Model model) {
        return "/informativo/informacion";
    }
}