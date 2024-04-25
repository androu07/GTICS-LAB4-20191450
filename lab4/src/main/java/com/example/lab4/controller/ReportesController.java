package com.example.lab4.controller;

import com.example.lab4.entity.Trabajo;
import com.example.lab4.repository.TrabajoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportesController {

    final
    TrabajoRepository trabajoRepository;

    public ReportesController(TrabajoRepository trabajoRepository) {
        this.trabajoRepository = trabajoRepository;
    }

    @GetMapping("/hr")
    public String vistaInicio(){
        return "inicio";
    }

    @GetMapping("/hr/reportes")
    public String listarPreordenes(){

        return "reportes";
    }

    @PostMapping("/guardartrabajo")
    public String guardartrabajo(Trabajo trabajo){
        trabajoRepository.save(trabajo);
        return "redirect:/hr/reportes";
    }

}
