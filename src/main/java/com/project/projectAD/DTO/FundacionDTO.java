package com.project.projectAD.DTO;

import lombok.Data;

@Data
public class FundacionDTO {
    private Long NIT;
    private String nombre;
    private String direccion;
    private Long celular;
    private String email;
    private String password;
    private String tipo;
}
