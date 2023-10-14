package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class usuariosService {
    private final usuariosRepository UsuariosRepository;
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
    public usuariosDTO guardarUsuario(usuariosDTO dto){
        usuarios Usuarios = new usuarios();
        Usuarios.setNomUsuario(dto.getNomUsuario());
        Usuarios.setContrasena(dto.getContrasena());
        Usuarios.setCorreo(dto.getCorreo());
        Usuarios.setNombre(dto.getNombre());
        Usuarios.setApellidoPa(dto.getApellidoPa());
        Usuarios.setApellidoMa(dto.getApellidoMa());
        Usuarios.setCorreo(dto.getCorreo());
        Usuarios.setDireccion(dto.getDireccion());
        Usuarios = UsuariosRepository.save(Usuarios);
        dto.setIdUsuario(Usuarios.getIdUsuario());
        return dto;
    }
}
