package com.example.prueba01.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final String apiUrl = "http://localhost:8080/client/list";


    @GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    public String getIndexXml() {
        // Aquí puedes generar contenido XML para la página de inicio
        return "<data>" +
                "<row><column1>Valor1</column1><column2>Valor2</column2></row>" +
                "<row><column1>Valor3</column1><column2>Valor4</column2></row>" +
                "</data>";
    }
}
