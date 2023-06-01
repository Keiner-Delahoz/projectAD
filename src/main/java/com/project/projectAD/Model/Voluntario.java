package com.project.projectAD.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("voluntario")
public class Voluntario extends Persona {

    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Beneficio> donaciones;

}
