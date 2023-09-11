package com.portafolio.evr.infrastructure.adapters.postgres.repository.user;

import com.portafolio.evr.infrastructure.adapters.postgres.entity.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepositoryAdpater  extends JpaRepository <UserDBO, Long> {
    Optional<UserDBO> findByEmail(String email);
}
