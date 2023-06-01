package com.project.projectAD.Service;

import com.project.projectAD.Model.Persona;
import com.project.projectAD.Model.Usuario;
import com.project.projectAD.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getPersonas(){
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) throws Exception {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            return persona;
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public void create(Persona persona) throws Exception {
        if (!personaRepository.existsById(persona.getIdentificacion())){
            personaRepository.save(persona);
        } else {
            throw new Exception("El usuario ya existe");
        }
    }

    public void update(Persona persona) throws Exception {
        if (personaRepository.existsById(persona.getIdentificacion())){
            personaRepository.save(persona);
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public void delete(Long id) throws Exception {
        if (personaRepository.existsById(id)){
            personaRepository.deleteById(id);
        } else {
            throw new Exception("El usuario no existe");
        }
    }
}
