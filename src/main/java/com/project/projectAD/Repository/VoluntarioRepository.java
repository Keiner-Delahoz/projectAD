package com.project.projectAD.Repository;

import com.project.projectAD.Model.Beneficiario;
import com.project.projectAD.Model.Persona;
import com.project.projectAD.Model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}
