package br.com.pharmalink.api.service;


import br.com.pharmalink.api.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncriptaSenhaUsuario {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    public String encriptar(String senha){

        return BCrypt.hashpw(senha, BCrypt.gensalt());

    }

    public boolean validarSenhas(String login, String senha){

        String senhaUsuario = usuarioRepositorio.getSenhaByEmailAtivo(login);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senha, senhaUsuario);

    }

}
