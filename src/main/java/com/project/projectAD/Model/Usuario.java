package com.project.projectAD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String tipo;

    @OneToOne()
    @JoinColumn(name = "persona_id")
    @JsonIgnore
    private Persona persona;

    @OneToOne()
    @JoinColumn(name = "fundacion_id")
    @JsonIgnore
    private Fundacion fundacion;

}
