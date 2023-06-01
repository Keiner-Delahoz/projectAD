package com.project.projectAD.Service;

import com.project.projectAD.DTO.SolicitudBeneficioDTO;
import com.project.projectAD.DTO.UsuarioDTO;
import com.project.projectAD.Model.Beneficiario;
import com.project.projectAD.Model.Persona;
import com.project.projectAD.Model.Usuario;
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
            Beneficiario beneficiario = beneficiarioRepository.getReferenceById(identificacion);
            System.out.println(beneficiario);
//            Persona persona = setPersonas(usuarioDTO);
//            Usuario usuario = setUsuarios(usuarioDTO);
//            usuario.setPersona(persona);
//            persona.setUsuario(usuario);
//            personaRepository.save(persona);
//        }
    }

}
