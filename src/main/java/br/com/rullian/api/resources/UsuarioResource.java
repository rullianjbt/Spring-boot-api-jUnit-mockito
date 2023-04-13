package br.com.rullian.api.resources;

import br.com.rullian.api.domain.Usuario;
import br.com.rullian.api.domain.dto.UsuarioDTO;
import br.com.rullian.api.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UsuarioResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findByID(id), UsuarioDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> list = service.findAll();
        List<UsuarioDTO> listDto = list.stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO obj){
        Usuario newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
