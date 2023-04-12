package br.com.rullian.api.services;

import br.com.rullian.api.domain.Usuario;

public interface UsuarioService {

    Usuario findByID(Integer id);
}
