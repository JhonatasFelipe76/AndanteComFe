package com.github.jhonatafelipe76.andantecomfe.service;

import com.github.jhonatafelipe76.andantecomfe.dto.CadastroUsuárioDTO;
import com.github.jhonatafelipe76.andantecomfe.model.User;
import com.github.jhonatafelipe76.andantecomfe.model.roleUsuario;
import com.github.jhonatafelipe76.andantecomfe.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }



    public User cadastrar(CadastroUsuárioDTO dto){
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        User user = new User();

        user.setUsuario(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenhaHash(dto.getSenha());
        user.setRole(roleUsuario.USER);
        user.setAtivo(false);

        return userRepository.save(user);
    }

}
