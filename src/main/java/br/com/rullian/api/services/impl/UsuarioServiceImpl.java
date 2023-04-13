package br.com.rullian.api.services.impl;

import br.com.rullian.api.domain.Usuario;
import br.com.rullian.api.domain.dto.UsuarioDTO;
import br.com.rullian.api.repositories.UsuarioRepository;
import br.com.rullian.api.services.UsuarioService;
import br.com.rullian.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Usuario findByID(Integer id) {
        Optional<Usuario> obj = userRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Usuario> findAll(){
        return userRepo.findAll();
    }

    @Override
    public Usuario create(UsuarioDTO obj) {
        return userRepo.save(mapper.map(obj, Usuario.class));
    }


}
