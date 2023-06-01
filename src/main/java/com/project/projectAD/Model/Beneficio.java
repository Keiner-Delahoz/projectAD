package com.project.projectAD.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "beneficios")
public class Beneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBeneficio;

    private String asunto;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "voluntario_id")
    private Voluntario voluntario;
}
