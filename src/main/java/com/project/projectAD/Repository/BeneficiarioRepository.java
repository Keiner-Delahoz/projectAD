package com.project.projectAD.Repository;

import com.project.projectAD.Model.Beneficiario;
import com.project.projectAD.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    Beneficiario findByNombre(String nombre);
}
