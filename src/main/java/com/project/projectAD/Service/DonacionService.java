package com.project.projectAD.Service;

import com.project.projectAD.DTO.BeneficioDTO;
import com.project.projectAD.Model.Beneficio;
import com.project.projectAD.Model.Voluntario;
import com.project.projectAD.Repository.DonacionRepository;
import com.project.projectAD.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonacionService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private DonacionRepository donacionRepository;

    public DonacionService() {
    }


    public void create(BeneficioDTO beneficioDTO) {
        if (voluntarioRepository.existsById(beneficioDTO.getIdentificacion())){
            Voluntario voluntario = voluntarioRepository.findById(beneficioDTO.getIdentificacion()).orElse(null);
            Beneficio donacion = setDonaciones(beneficioDTO, voluntario);
            donacionRepository.save(donacion);
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
