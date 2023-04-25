package com.proyecto.controller;

import com.proyecto.domain.Reclamo;
import com.proyecto.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

 @Controller
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoservice;

    @GetMapping("/Reclamos/listado")
    public String inicio(Model model) {
        var reclamos = reclamoservice.getReclamo();
        model.addAttribute("reclamos", reclamos);
        model.addAttribute("totalClientes", reclamos.size());
        return "/Reclamos/listado";
    }

    @GetMapping("/Reclamos/eliminar/{idCliente}")
    public String eliminaReclamo(Reclamo reclamo) {
        reclamoservice.deleteReclamo(reclamo);
        return "redirect:/Reclamos/listado";
    }

    @PostMapping("/Reclamos/guardar")
    public String guardarReclamo(Reclamo reclamo) {
        reclamoservice.saveReclamo(reclamo);
        return "/informativo/informacion";
    }
}