package com.example.prueba01.vo;

import com.example.prueba01.dto.ClientDto;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import java.util.List;

@Data
public class ClientVo {

    private String id;
    private String identification;
    private String name;
    private String email;
    private String phone;
    private String benefit;
    private boolean deleted;

    public void addAttribute(String clientes, List<ClientDto> clientes1) {
    }
}
