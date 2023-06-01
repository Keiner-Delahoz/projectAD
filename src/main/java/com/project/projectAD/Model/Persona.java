package com.project.projectAD.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "personas")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
//@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

    private String nombre;

    private String apellido;

    @Id
    private Long identificacion;

    private LocalDate fechaNacimiento;

    private String genero;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;

}
