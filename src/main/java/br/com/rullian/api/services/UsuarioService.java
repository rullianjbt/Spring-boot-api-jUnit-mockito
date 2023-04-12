package br.com.rullian.api.services;

import br.com.rullian.api.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findByID(Integer id);
    List<Usuario> findAll();
}
