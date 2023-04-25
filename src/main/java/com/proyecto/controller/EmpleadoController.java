package com.proyecto.controller;

import com.proyecto.domain.Empleado;
import com.proyecto.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleado")

public class EmpleadoController {
    @Autowired
   private EmpleadoService empleadoService;
       
      @GetMapping("/InventarioB")
    public String inicio(Model model) {
        var empleados=empleadoService.getEmpleados(false);
        model.addAttribute("empleados",empleados);
        model.addAttribute("totalEmpleados", empleados.size());
        return "/empleado/InventarioB";
    }
    @GetMapping("/eliminar/{idEmpleado}")
    public String eliminaEmpleado(Empleado empleado){
        empleadoService.deleteEmpleado(empleado);
        return "redirect:/empleado/InventarioB";
    }
    @GetMapping("/nuevo") 
    public String nuevoempleado(Empleado empleado){
        return "/empleado/modificaB";
    }
    @PostMapping("/guardar")
    public String guardarEmpleado(Empleado empleado){
        empleadoService.saveEmpleado(empleado);
        return "redirect:/empleado/InventarioB";
    }
    @GetMapping("/modificarB/{idEmpleado}") 
    public String modificaEmpleado(Empleado empleado, Model model){     
        empleado=empleadoService.getEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "/empleado/modificaB";
    }
}
