package com.project.projectAD.Controller;

import com.project.projectAD.DTO.SolicitudBeneficioDTO;
import com.project.projectAD.Service.SolicitudBeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud/beneficios")
public class SolicitudBeneficioController {

    @Autowired
    private SolicitudBeneficioService solicitudBeneficioService;

    @PostMapping("/{identificacion}")
    public ResponseEntity crearSolicitudBeneficio(@PathVariable Long identificacion, @RequestBody SolicitudBeneficioDTO solicitudBeneficioDTO) {
//        try {
            solicitudBeneficioService.create(identificacion, solicitudBeneficioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
    }

}
