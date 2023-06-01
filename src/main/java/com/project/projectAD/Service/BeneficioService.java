package com.project.projectAD.Service;

import com.project.projectAD.DTO.BeneficioDTO;
import com.project.projectAD.Model.Beneficio;
import com.project.projectAD.Model.Voluntario;
import com.project.projectAD.Repository.BeneficioRepository;
import com.project.projectAD.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private BeneficioRepository beneficioRepository;

    public BeneficioService() {
    }


    public void create(BeneficioDTO beneficioDTO) {
        if (voluntarioRepository.existsById(beneficioDTO.getIdentificacion())){
            Voluntario voluntario = voluntarioRepository.findById(beneficioDTO.getIdentificacion()).orElse(null);
            Beneficio donacion = setDonaciones(beneficioDTO, voluntario);
            beneficioRepository.save(donacion);
        }
    }

    private Beneficio setDonaciones(BeneficioDTO beneficioDTO, Voluntario voluntario) {
        Beneficio donacion = new Beneficio();
        donacion.setAsunto(beneficioDTO.getAsunto());
        donacion.setDescripcion(beneficioDTO.getDescripcion());
        donacion.setVoluntario(voluntario);
        return donacion;
    }
}
