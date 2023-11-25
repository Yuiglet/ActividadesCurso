package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.credencialesDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.utils.constantes;
import com.metaphorce.shopall.exceptions.EntityNotFoundException;
import com.metaphorce.shopall.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class authService {
    @Autowired
    usuariosRepository UsuariosRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwtService JwtSservice;

    public respuestaGenerica getTokenUsuario(credencialesDTO credencialesDto){
        respuestaGenerica respuesta = new respuestaGenerica();
        //validamos que el usuario exita en la BD si no detonamos una exepcion
        usuarios usuarioCompra = UsuariosRepository.findByNomUsuario(credencialesDto.getNomUsuario()).
                orElseThrow(() -> new EntityNotFoundException(constantes.USUARIO_CORREO_INCORRECTO));
        // validamos que las contraseñas sean las correctas
        boolean contraseñasIguales = passwordEncoder.matches(credencialesDto.getContrasena(), usuarioCompra.getContrasena());
        if(contraseñasIguales){
            String token = JwtSservice.generateToken(credencialesDto.getNomUsuario());
            respuesta.setMensaje(constantes.MENSAJE_TOKEN_EXITO);
            respuesta.getDatos().add(token);
            respuesta.setExito(true);
        }else{
            respuesta.setExito(false);
            respuesta.getDatos().add(credencialesDto.getNomUsuario());
            respuesta.getDatos().add(credencialesDto.getContrasena());
            respuesta.setMensaje(constantes.USUARIO_CONTRASENA_INCORRECTA);
        }

        return respuesta;
    }
}
