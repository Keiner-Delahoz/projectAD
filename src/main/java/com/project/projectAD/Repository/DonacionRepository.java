package com.project.projectAD.Repository;

import com.project.projectAD.Model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonacionRepository extends JpaRepository<Beneficio, Long> {
}
