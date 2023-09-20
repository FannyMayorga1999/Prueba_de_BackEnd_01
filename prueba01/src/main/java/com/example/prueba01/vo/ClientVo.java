package com.example.prueba01.vo;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

@Data
public class ClientVo {

    private String id;
    private String identification;
    private String name;
    private String email;
    private String phone;
    private String benefit;
    private boolean deleted;

}
