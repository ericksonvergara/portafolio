package com.portafolio.evr.infrastructure.adapters.postgres.repository.biography;

import com.portafolio.evr.domain.models.biography.Biography;
import com.portafolio.evr.domain.models.biography.BiographyRequest;
import com.portafolio.evr.domain.models.gateways.IBiographyRepository;
import com.portafolio.evr.infrastructure.adapters.postgres.entity.BiographyDBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Repository
public class BiographyRepositoryAdapter implements IBiographyRepository {

    private final IBiographyRepositoryAdapter iBiographyRepositoryAdapter;

    @Override
    public Biography findById(Long id) {
        Optional<BiographyDBO> biographyDBO = iBiographyRepositoryAdapter.findById(Long.valueOf(id));
        return biographyDBO.map(dbo -> Biography.builder()
                .id(dbo.getId())
                .title(dbo.getTitle())
                .description(dbo.getDescription())
                .build()).orElse(null);
    }

    @Override
    public Biography save(BiographyRequest biographyRequest) {

        BiographyDBO biographyDBORe = BiographyDBO.builder()
                .title(biographyRequest.getTitle())
                .description(biographyRequest.getDescription())
                .build();

        BiographyDBO biographyDBO = iBiographyRepositoryAdapter.save(biographyDBORe);

        return Biography.builder()
                .id(biographyDBO.getId())
                .title(biographyDBO.getTitle())
                .description(biographyDBO.getDescription())
                .build();
    }

    @Override
    public Biography update(BiographyRequest biographyRequest) {
        return null;
    }
}
