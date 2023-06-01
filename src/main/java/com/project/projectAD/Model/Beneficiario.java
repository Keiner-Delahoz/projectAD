package com.project.projectAD.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DiscriminatorValue("beneficiario")
public class Beneficiario extends Persona{

    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolicitudBeneficio> solicitudesBeneficio = new ArrayList<>();

}
