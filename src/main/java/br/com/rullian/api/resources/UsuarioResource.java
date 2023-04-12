package br.com.rullian.api.resources;

import br.com.rullian.api.domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UsuarioResource {

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(new Usuario(1, "Valdir", "val@mail.com", "123"));

    }


}
