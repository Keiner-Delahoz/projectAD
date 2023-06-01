package com.project.projectAD.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud_beneficios")
public class SolicitudBeneficio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

}
