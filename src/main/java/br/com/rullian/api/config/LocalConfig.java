package br.com.rullian.api.config;

import br.com.rullian.api.domain.Usuario;
import br.com.rullian.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRepository userRepo;
    @Bean
    public void startDb(){
        Usuario user1 = new Usuario(null, "Valdir", "valdir@mail.com", "123");
        Usuario user2 = new Usuario(null, "Luiz","luiz@mail.com", "123");

        userRepo.saveAll(List.of(user1, user2));
    };
}
