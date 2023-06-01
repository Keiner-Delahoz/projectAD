package com.project.projectAD.Service;

import com.project.projectAD.DTO.FundacionDTO;
import com.project.projectAD.Model.Fundacion;
import com.project.projectAD.Model.Usuario;
import com.project.projectAD.Repository.FundacionRepository;
import com.project.projectAD.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FundacionRepository fundacionRepository;

    public void create(FundacionDTO fundacionDTO) throws Exception {
        if (fundacionRepository.existsById(fundacionDTO.getNIT()) || usuarioRepository.existsByEmail(fundacionDTO.getEmail())){
            throw new Exception("El usuario ya existe");
        } else {
            Fundacion fundacion = setFundaciones(fundacionDTO);
            Usuario usuario = setUsuarios(fundacionDTO);
            usuario.setFundacion(fundacion);
            fundacion.setUsuario(usuario);
            fundacionRepository.save(fundacion);
        }
    }

    private Fundacion setFundaciones(FundacionDTO fundacionDTO){
        Fundacion fundacion = new Fundacion();
        fundacion.setNIT(fundacionDTO.getNIT());
        fundacion.setNombre(fundacionDTO.getNombre());
        fundacion.setDireccion(fundacionDTO.getDireccion());
        fundacion.setCelular(fundacionDTO.getCelular());
        return fundacion;
    }

    private Usuario setUsuarios(FundacionDTO fundacionDTO){
        Usuario usuario = new Usuario();
        usuario.setEmail(fundacionDTO.getEmail());
        usuario.setPassword(fundacionDTO.getPassword());
        usuario.setTipo(fundacionDTO.getTipo());
        return  usuario;
    }
}
