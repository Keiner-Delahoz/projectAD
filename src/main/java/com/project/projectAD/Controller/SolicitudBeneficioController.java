package com.project.projectAD.Controller;

import com.project.projectAD.DTO.SolicitudBeneficioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud/beneficio")
public class SolicitudBeneficioController {

//    @PostMapping("/{beneficiarioId}")
//    public ResponseEntity crearSolicitudBeneficio(@PathVariable Long identificacion, @RequestBody SolicitudBeneficioDTO solicitudBeneficioDTO) {
//        try {
//            solicitudBeneficioDTO.create(identificacion, solicitudBeneficioDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }

}
