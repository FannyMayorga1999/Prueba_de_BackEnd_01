package com.example.prueba01.dto;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "adm_client")
@Data
public class ClientDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identification")
    private String identification;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "benefit")
    private String benefit;

    @Column(name = "deleted")
    private boolean deleted;
}
