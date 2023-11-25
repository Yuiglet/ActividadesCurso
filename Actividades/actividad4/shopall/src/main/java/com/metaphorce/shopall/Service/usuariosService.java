package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.utils.constantes;
import com.metaphorce.shopall.exceptions.EntityNotFoundException;
import com.metaphorce.shopall.repository.usuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class usuariosService {
    private final usuariosRepository UsuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public usuariosService(usuariosRepository UsuariosRepository){
        this.UsuariosRepository = UsuariosRepository;
    }

    public List<usuariosDTO> getUsuarios(){
        List<usuariosDTO> listaUsuarios = new ArrayList<>();

        for(usuarios user: UsuariosRepository.findAll()){
            usuariosDTO usuarioDto = new usuariosDTO();
            usuarioDto.setIdUsuario(user.getIdUsuario());
            usuarioDto.setNomUsuario(user.getNomUsuario());
            usuarioDto.setContrasena(user.getContrasena());
            usuarioDto.setCorreo(user.getCorreo());
            usuarioDto.setNombre(user.getNombre());
            usuarioDto.setApellidoPa(user.getApellidoPa());
            usuarioDto.setApellidoMa(user.getApellidoMa());
            usuarioDto.setDireccion(user.getDireccion());
            listaUsuarios.add(usuarioDto);
        }
        return listaUsuarios;
    }
    public respuestaGenerica guardarUsuario(@Valid usuariosDTO dto){
        respuestaGenerica RespuestaGenerica = new respuestaGenerica();
        usuarios Usuarios = new usuarios();

        if (UsuariosRepository.existsByNomUsuario(dto.getNomUsuario())) {
            throw new EntityDuplicateException("El nombre de usuario ya existe en la base de datos");
        }else {
            Usuarios.setNomUsuario(dto.getNomUsuario());
        }

        if (UsuariosRepository.existsByCorreo(dto.getCorreo())) {
            throw new EntityDuplicateException("El correo ya existe en la base de datos");
        }else{
            Usuarios.setCorreo(dto.getCorreo());
        }

        Usuarios.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        Usuarios.setNombre(dto.getNombre());
        Usuarios.setApellidoPa(dto.getApellidoPa());
        Usuarios.setApellidoMa(dto.getApellidoMa());
        Usuarios.setDireccion(dto.getDireccion());
        Usuarios = UsuariosRepository.save(Usuarios);
        dto.setIdUsuario(Usuarios.getIdUsuario());
        RespuestaGenerica.setMensaje(constantes.MENSAJE_USUARIO_EXITO);
        RespuestaGenerica.setExito(true);
        return RespuestaGenerica;
    }
}
