package com.proyecto.controller;

import com.proyecto.domain.Proveedor;
import com.proyecto.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
   private ProveedorService proveedorService;
       
      @GetMapping("/Inventario")
    public String inicio(Model model) {
        var proveedors=proveedorService.getProveedors(false);
        model.addAttribute("proveedors",proveedors);
        model.addAttribute("totalProveedors", proveedors.size());
        return "/proveedor/Inventario";
    }
    @GetMapping("/eliminar/{idProveedor}")
    public String eliminaProveedor(Proveedor proveedor){
        proveedorService.deleteProveedor(proveedor);
        return "redirect:/proveedor/Inventario";
    }
    @GetMapping("/nuevo") 
    public String nuevoproveedor(Proveedor proveedor){
        return "/proveedor/modifica";
    }
    @PostMapping("/guardar")
    public String guardarProveedor(Proveedor proveedor){
        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedor/Inventario";
    }
    @GetMapping("/modifica/{idProveedor}") 
    public String modificaProveedor(Proveedor proveedor, Model model){     
        proveedor=proveedorService.getProveedor(proveedor);
        model.addAttribute("proveedor", proveedor);
        return "/proveedor/modifica";
    }
}
