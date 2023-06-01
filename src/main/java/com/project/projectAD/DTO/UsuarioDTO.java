package com.project.projectAD.DTO;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UsuarioDTO {
    private String tipo;
    private String nombre;
    private String apellido;
    private Long identificacion;
    private String email;
    private String password;
    private LocalDate fechaNacimiento;
    private String genero;
}
