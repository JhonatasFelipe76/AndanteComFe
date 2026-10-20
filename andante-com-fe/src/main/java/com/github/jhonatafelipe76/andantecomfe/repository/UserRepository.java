package com.github.jhonatafelipe76.andantecomfe.repository;

import com.github.jhonatafelipe76.andantecomfe.dto.CadastroUsuárioDTO;
import com.github.jhonatafelipe76.andantecomfe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

}
