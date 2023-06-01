package com.project.projectAD.Controller;

import com.project.projectAD.DTO.BeneficioDTO;
import com.project.projectAD.Service.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donaciones")
@CrossOrigin
public class BeneficioController {

    @Autowired
    private BeneficioService beneficioService;

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody BeneficioDTO beneficioDTO) {
//        try {
            beneficioService.create(beneficioDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.ok("Usuario y persona creados exitosamente");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
    }

}
