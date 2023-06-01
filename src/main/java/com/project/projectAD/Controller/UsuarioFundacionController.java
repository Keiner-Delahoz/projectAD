package com.project.projectAD.Controller;

import com.project.projectAD.DTO.FundacionDTO;
import com.project.projectAD.Model.Fundacion;
import com.project.projectAD.Service.FundacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioFundacionController {

    @Autowired
    private FundacionService fundacionService;

    @PostMapping("/formulario/fundaciones")
    public ResponseEntity save(@RequestBody FundacionDTO fundacionDTO){
        try {
            fundacionService.create(fundacionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
