package com.project.projectAD.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fundaciones")
public class Fundacion {

    @Id
    private Long NIT;

    private String nombre;

    private String direccion;

    private Long celular;

    @OneToOne(mappedBy = "fundacion", cascade = CascadeType.ALL)
    private Usuario usuario;
}
