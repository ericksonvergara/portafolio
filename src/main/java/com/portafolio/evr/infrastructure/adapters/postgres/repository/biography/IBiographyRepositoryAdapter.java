package com.portafolio.evr.infrastructure.adapters.postgres.repository.biography;

import com.portafolio.evr.infrastructure.adapters.postgres.entity.BiographyDBO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBiographyRepositoryAdapter extends JpaRepository<BiographyDBO, Long> {
       Optional<BiographyDBO> findById(Long id);
}
