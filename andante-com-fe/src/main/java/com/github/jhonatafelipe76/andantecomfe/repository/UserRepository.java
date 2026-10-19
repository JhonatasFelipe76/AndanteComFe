package com.github.jhonatafelipe76.andantecomfe.repository;

import com.github.jhonatafelipe76.andantecomfe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
