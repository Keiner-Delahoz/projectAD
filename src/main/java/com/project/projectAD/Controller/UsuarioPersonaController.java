package com.project.projectAD.Controller;

import com.project.projectAD.DTO.UsuarioDTO;
import com.project.projectAD.Model.Persona;
import com.project.projectAD.Service.BeneficiarioService;
import com.project.projectAD.Service.UsuarioService;
import com.project.projectAD.Service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioPersonaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private VoluntarioService voluntarioService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll(){
        List<Persona> listUsuario = usuarioService.getUsuarios();
        if (listUsuario == null || listUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
        return ResponseEntity.ok(listUsuario);
        }
    }


//    @GetMapping("/{identificacion}")
//    public ResponseEntity<Usuario> getUsuario(@PathVariable Long identificacion){
//        try {
//            Usuario usuario = usuarioService.getUsuarioById(identificacion);
//            return ResponseEntity.ok(usuario);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<Persona> getUsuario(@PathVariable Long identificacion){
        try {
            Persona persona = usuarioService.getUsuarioById(identificacion);
            return ResponseEntity.ok(persona);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/formulario/personas")
    public ResponseEntity<String> save(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            if (usuarioDTO.getTipo().equalsIgnoreCase("voluntario")) {
                voluntarioService.create(usuarioDTO);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            if (usuarioDTO.getTipo().equalsIgnoreCase("beneficiario")) {
                beneficiarioService.create(usuarioDTO);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PatchMapping("/{identificacion}")
    public ResponseEntity update(@PathVariable Long identificacion, @RequestBody UsuarioDTO usuarioDTO){
        try {
            usuarioService.update(identificacion,usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity delete(@PathVariable("identificacion") Long identificacion){
        try {
            usuarioService.delete(identificacion);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    //Para recibir los datos en forma de FORM-DATA y guardarlos en la base de datos.

//    @PostMapping()
//    public ResponseEntity<String> save(@ModelAttribute Persona persona, @ModelAttribute Usuario usuario) {
//        try {
//        usuarioService.create(persona, usuario);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }



//    @PostMapping()
//    public ResponseEntity<String> save(@RequestBody Map<String, Object> data) {
//        try {
//        System.out.println(data);
//        usuarioService.create(data);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        return ResponseEntity.ok("Usuario y persona creados exitosamente");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }

}


