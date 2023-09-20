package com.example.prueba01.controller;

import com.example.prueba01.dto.ClientDto;
import com.example.prueba01.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("/crearCliente")
    public String createClient(@RequestBody ClientDto clientDto) {
        try {
            clientService.createClient(clientDto);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }
}
