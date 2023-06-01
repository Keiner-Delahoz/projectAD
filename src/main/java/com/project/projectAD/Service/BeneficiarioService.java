package com.project.projectAD.Service;

import com.project.projectAD.DTO.UsuarioDTO;
import com.project.projectAD.Model.Beneficiario;
import com.project.projectAD.Model.Usuario;
import com.project.projectAD.Repository.BeneficiarioRepository;
import com.project.projectAD.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public void create(UsuarioDTO usuarioDTO) throws Exception {
        if (beneficiarioRepository.existsById(usuarioDTO.getIdentificacion()) || usuarioRepository.existsByEmail(usuarioDTO.getEmail())){
            throw new Exception("El usuario ya existe");
        } else {
            Beneficiario beneficiario = setBeneficiarios(usuarioDTO);
            Usuario usuario = setUsuarios(usuarioDTO);
            usuario.setPersona(beneficiario);
            beneficiario.setUsuario(usuario);
            beneficiarioRepository.save(beneficiario);
        }
    }

    private Beneficiario setBeneficiarios(UsuarioDTO usuarioDTO){
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNombre(usuarioDTO.getNombre());
        beneficiario.setApellido(usuarioDTO.getApellido());
        beneficiario.setIdentificacion(usuarioDTO.getIdentificacion());
        beneficiario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        beneficiario.setGenero(usuarioDTO.getGenero());
        return beneficiario;
    }

    private Usuario setUsuarios(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());;
        usuario.setTipo(usuarioDTO.getTipo());
        return usuario;
    }
}
