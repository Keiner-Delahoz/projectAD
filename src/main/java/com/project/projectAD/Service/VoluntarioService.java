package com.project.projectAD.Service;

import com.project.projectAD.DTO.UsuarioDTO;

import com.project.projectAD.Model.Usuario;
import com.project.projectAD.Model.Voluntario;
import com.project.projectAD.Repository.UsuarioRepository;
import com.project.projectAD.Repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoluntarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public void create(UsuarioDTO usuarioDTO) throws Exception {
        if (voluntarioRepository.existsById(usuarioDTO.getIdentificacion()) || usuarioRepository.existsByEmail(usuarioDTO.getEmail())){
            throw new Exception("El usuario ya existe");
        } else {
            Voluntario voluntario = setVoluntarios(usuarioDTO);
            Usuario usuario = setUsuarios(usuarioDTO);
            usuario.setPersona(voluntario);
            voluntario.setUsuario(usuario);
            voluntarioRepository.save(voluntario);
        }
    }

    private Voluntario setVoluntarios(UsuarioDTO usuarioDTO){
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(usuarioDTO.getNombre());
        voluntario.setApellido(usuarioDTO.getApellido());
        voluntario.setIdentificacion(usuarioDTO.getIdentificacion());
        voluntario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        voluntario.setGenero(usuarioDTO.getGenero());
        return voluntario;
    }

    private Usuario setUsuarios(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setTipo(usuarioDTO.getTipo());
        return  usuario;
    }

}
