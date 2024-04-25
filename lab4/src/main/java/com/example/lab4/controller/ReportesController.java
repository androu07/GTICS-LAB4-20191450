package com.example.lab4.controller;

import com.example.lab4.entity.Trabajo;
import com.example.lab4.repository.TrabajoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
    public String mostrarReportes(){
        return "reportes";
    }

    @GetMapping("/hr/reportes/salario")
    public String mostrarSalarios(Model model){
        List<Trabajo> listatrabajos = trabajoRepository.findAll();
        model.addAttribute("listaTrabajos",listatrabajos);
        return "salario";
    }

    @GetMapping("/editar")
    public String nuevoTrabajo(Model model,
                               @RequestParam("id") int id){
        Optional<Trabajo> optionalTrabajo = trabajoRepository.findById(id);

        if (optionalTrabajo.isPresent()){
            Trabajo trabajo = optionalTrabajo.get();
            model.addAttribute("trabajo", trabajo);
            return "editartrabajo";
        }

        return "nuevotrabajo";
    }

    @GetMapping("/hr/trabajo/nuevo")
    public String nuevoTrabajo(){
        return "nuevotrabajo";
    }

    @PostMapping("/guardartrabajo")
    public String guardartrabajo(Trabajo trabajo){
        trabajoRepository.save(trabajo);
        return "redirect:/hr/reportes";
    }

}
