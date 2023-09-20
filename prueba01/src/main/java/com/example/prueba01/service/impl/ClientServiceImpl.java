package com.example.prueba01.service.impl;

import com.example.prueba01.dto.ClientDto;
import com.example.prueba01.service.IClientService;
import com.example.prueba01.vo.ClientVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl
{
    @Autowired
    private IClientService iClientService;

    @GetMapping
    public List<ClientDto> getAllClients() {
        return iClientService.findByDeletedFalse();
    }

    @PutMapping
    public void deleteById(Long id) {
        iClientService.deleteClient(id);
    }

    @GetMapping
    public Optional<ClientDto> getClientById(Long id) {
        return iClientService.findById(id);
    }

    @PutMapping
    public void deleteClient(ClientDto client) {
        iClientService.save(client);
    }

    @DeleteMapping
    public void updateClient(ClientDto client) {
        iClientService.save(client);
    }

    @PostMapping
    public void createClient(ClientDto client) {
        iClientService.save(client);
    }
}
