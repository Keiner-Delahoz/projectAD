package com.project.projectAD.Repository;

import com.project.projectAD.Model.Fundacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundacionRepository extends JpaRepository<Fundacion, Long> {
}
