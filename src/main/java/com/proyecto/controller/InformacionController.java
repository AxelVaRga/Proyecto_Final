package com.proyecto.controller;

import com.proyecto.domain.Informacion;
import com.proyecto.service.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class InformacionController {
    
@Autowired

   private InformacionService informacionservice;
       
      @GetMapping("/informacion/listado")
    public String inicio(Model model) {
        var informaciones=informacionservice.getInformacion();
        model.addAttribute("informaciones",informaciones);
        model.addAttribute("totalClientes", informaciones.size());
        return "/informacion/listado";
    }
    @GetMapping("/informacion/eliminar/{idPersona}")
    public String eliminaInformacion(Informacion informacion){
        informacionservice.deleteInformacion(informacion);
        return "redirect:/informacion/listado";
    }
    
    @PostMapping("/informacion/guardar")
    public String guardarInformacion(Informacion informacion){
        informacionservice.saveInformacion(informacion);
        return "/informativo/informacion";
    }
}