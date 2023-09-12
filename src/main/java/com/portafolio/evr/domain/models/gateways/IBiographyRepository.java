package com.portafolio.evr.domain.models.gateways;

import com.portafolio.evr.domain.models.biography.Biography;
import com.portafolio.evr.domain.models.biography.BiographyRequest;

public interface IBiographyRepository {
    Biography findById(Long id);
    Biography save(BiographyRequest biographyRequest);
}
