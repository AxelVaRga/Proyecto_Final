package com.proyecto.controller;

import com.proyecto.domain.Tienda;
import com.proyecto.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tienda")
public class TiendaController {
    @Autowired
   private TiendaService tiendaService;
       
      @GetMapping("/listado")
    public String inicio(Model model) {
        var tiendas=tiendaService.getTiendas(false);
        model.addAttribute("tiendas",tiendas);
        model.addAttribute("totalTiendas", tiendas.size());
        return "/tienda/listado";
    }
    @GetMapping("/eliminar/{idTienda}")
    public String eliminaTienda(Tienda tienda){
        tiendaService.deletetienda(tienda);
        return "redirect:/tienda/listado";
    }
    @GetMapping("/nuevo") 
    public String nuevotienda(Tienda tienda){
        return "/tienda/modifica";
    }
    @PostMapping("/guardar")
    public String guardarTienda(Tienda tienda){
        tiendaService.savetienda(tienda);
        return "redirect:/tienda/listado";
    }
    @GetMapping("/modificar/{idTienda}") 
    public String modificaTienda(Tienda tienda, Model model){     
        tienda=tiendaService.gettienda(tienda);
        model.addAttribute("tienda", tienda);
        return "/tienda/modifica";
    }
}