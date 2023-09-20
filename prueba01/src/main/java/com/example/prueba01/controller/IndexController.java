package com.example.prueba01.controller;

import com.example.prueba01.dto.ClientDto;
import com.example.prueba01.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/")
    public String mostrarUsuarios(Model model) {
        List<ClientDto> usuarios = clientService.getAllClients();
        model.addAttribute("clientes", usuarios);
        return "clientes"; // El nombre de la vista HTML
    }
}
