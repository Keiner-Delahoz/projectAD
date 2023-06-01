package com.project.projectAD.Service;

import com.project.projectAD.DTO.UsuarioDTO;
import com.project.projectAD.Model.Persona;
import com.project.projectAD.Model.Usuario;
import com.project.projectAD.Repository.PersonaRepository;
import com.project.projectAD.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getUsuarios(){
        return personaRepository.findAll();
    }

//    public Usuario getUsuarioById(Long identificacion) throws Exception {
//        Usuario usuario = usuarioRepository.findByPersonaIdentificacion(identificacion).orElse(null);
//        if (usuario != null) {
//            return usuario;
//        } else {
//            throw new Exception("El usuario no existe");
//        }
//    }

    public Persona getUsuarioById(Long identificacion) throws Exception {
        Persona persona = personaRepository.findById(identificacion).orElse(null);
        if (persona != null) {
            return persona;
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public void create(UsuarioDTO usuarioDTO) throws Exception {
        if (personaRepository.existsById(usuarioDTO.getIdentificacion()) || usuarioRepository.existsByEmail(usuarioDTO.getEmail())){
            throw new Exception("El usuario ya existe");
        } else {
            Persona persona = setPersonas(usuarioDTO);
            Usuario usuario = setUsuarios(usuarioDTO);
            usuario.setPersona(persona);
            persona.setUsuario(usuario);
            personaRepository.save(persona);
        }
    }

    public void update(Long identificacion, UsuarioDTO usuarioDTO) throws Exception {
        if (personaRepository.existsById(identificacion)){
            Persona persona = modificar_ValidarUsuario(identificacion,usuarioDTO);
            personaRepository.save(persona);
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public void delete(Long identificacion) throws Exception {
        if (personaRepository.existsById(identificacion)){
            personaRepository.deleteById(identificacion);
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    private Persona modificar_ValidarUsuario(Long identificacion, UsuarioDTO usuarioDTO){
        Persona persona = personaRepository.findById(identificacion).orElse(null);
        if (usuarioDTO.getNombre() != null) { persona.setNombre(usuarioDTO.getNombre()); }
        if (usuarioDTO.getApellido() != null) { persona.setApellido(usuarioDTO.getApellido()); }
        if (usuarioDTO.getEmail() != null) { persona.getUsuario().setEmail(usuarioDTO.getEmail()); }
        if (usuarioDTO.getFechaNacimiento() != null) { persona.setFechaNacimiento(usuarioDTO.getFechaNacimiento()); }
        if (usuarioDTO.getGenero() != null) { persona.setGenero(usuarioDTO.getGenero()); }
        return persona;
    }

    private Persona setPersonas(UsuarioDTO usuarioDTO){
        Persona persona = new Persona();
        persona.setNombre(usuarioDTO.getNombre());
        persona.setApellido(usuarioDTO.getApellido());
        persona.setIdentificacion(usuarioDTO.getIdentificacion());
        persona.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        persona.setGenero(usuarioDTO.getGenero());
        return persona;
    }

    private Usuario setUsuarios(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());;
        return usuario;
    }


    //Recibe los datos en forma de FORM-DATA y los guarda en la base de datos.

//    public void create(Persona persona, Usuario usuario) {
//        usuario.setPersona(persona);
//        if (!usuarioRepository.existsByEmail(usuario.getEmail())){
//        personaRepository.save(persona);
//        usuarioRepository.save(usuario);
//        } else {
//            throw new Exception("El usuario ya existe");
//        }
//    }


    //    public void create(Map<String, Object> data) {

//        ObjectMapper objectMapper = new ObjectMapper();
//        Persona persona = new Persona();
//        persona.setNombre((String) data.get("persona.nombre"));
//        persona.setApellido((String) data.get("persona.apellido"));
//        persona.setIdentificacion((Long) data.get("persona.identificacion"));

//        Usuario usuario = new Usuario();
//        usuario.setPersona(persona);
//        if (!usuarioRepository.existsByEmail(usuario.getEmail())){
//        personaRepository.save(persona);
//        usuarioRepository.save(usuario);
//        } else {
//            throw new Exception("El usuario ya existe");
//        }
//    }
}
