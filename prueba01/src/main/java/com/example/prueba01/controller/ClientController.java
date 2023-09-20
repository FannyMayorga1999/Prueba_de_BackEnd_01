package com.example.prueba01.controller;

import com.example.prueba01.dto.ClientDto;
import com.example.prueba01.service.impl.ClientServiceImpl;
import com.example.prueba01.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController  {

    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/list")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        Optional<ClientDto> productoOptional = clientService.getClientById(id);

        if (productoOptional.isPresent()) {
            ClientDto clientDto = productoOptional.get();
            return new ResponseEntity<>(clientDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable Long id, @RequestBody ClientVo clientVo) {
        try {
            Optional<ClientDto> productoOptional = clientService.getClientById(id);
            if (productoOptional.isPresent()) {
                ClientDto clientDto = productoOptional.get();
                clientDto.setName(clientVo.getName());
                clientDto.setIdentification(clientVo.getIdentification());
                clientDto.setEmail(clientVo.getEmail());
                clientDto.setPhone(clientVo.getPhone());
                clientDto.setBenefit(clientVo.getBenefit());
                clientService.updateClient(clientDto);
                return new ResponseEntity<>("Cliente actualizado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {
        try {
            Optional<ClientDto> productoOptional = clientService.getClientById(id);
            if (productoOptional.isPresent()) {
                ClientDto clientDto = productoOptional.get();
                clientDto.setDeleted(true);
                clientService.deleteClient(clientDto);
                return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminado el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody ClientDto clientDto) {
        try {
            clientService.createClient(clientDto);
            return new ResponseEntity<>("Cliente creado correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al cliente el producto: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
