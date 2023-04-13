package br.com.rullian.api.services;

import br.com.rullian.api.domain.Usuario;
import br.com.rullian.api.domain.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario findByID(Integer id);
    List<Usuario> findAll();
    Usuario create(UsuarioDTO obj);
    Usuario update(UsuarioDTO obj);
    void delete(Integer id);
}
