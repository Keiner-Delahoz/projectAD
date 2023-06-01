package com.project.projectAD.Service;

import com.project.projectAD.DTO.SolicitudBeneficioDTO;
import com.project.projectAD.DTO.UsuarioDTO;
import com.project.projectAD.Model.*;
import com.project.projectAD.Repository.BeneficiarioRepository;
import com.project.projectAD.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SolicitudBeneficioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public void create(Long identificacion, SolicitudBeneficioDTO solicitudBeneficioDTO) {
//        if (personaRepository.existsById(usuarioDTO.getIdentificacion()) || usuarioRepository.existsByEmail(usuarioDTO.getEmail())){
//            throw new Exception("El usuario ya existe");
//        } else {
            Beneficiario beneficiario = (Beneficiario) personaRepository.findById(identificacion).orElse(null);
            SolicitudBeneficio solicitudBeneficio = solicitudBeneficio(solicitudBeneficioDTO);
            solicitudBeneficio.setBeneficiario(beneficiario);
            beneficiario.getSolicitudesBeneficio().add(solicitudBeneficio);

            System.out.println(beneficiario.getNombre());

//            Persona persona = setPersonas(usuarioDTO);
//            Usuario usuario = setUsuarios(usuarioDTO);
//            usuario.setPersona(persona);
//            persona.setUsuario(usuario);
//            personaRepository.save(persona);
//        }
    }

    private SolicitudBeneficio solicitudBeneficio(SolicitudBeneficioDTO solicitudBeneficioDTO){
        SolicitudBeneficio solicitudBeneficio = new SolicitudBeneficio(solicitudBeneficioDTO.getTipo(),solicitudBeneficioDTO.getDescripcion());
        return solicitudBeneficio;
    }

}
