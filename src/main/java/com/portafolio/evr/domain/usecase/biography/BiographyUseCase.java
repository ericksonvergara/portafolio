package com.portafolio.evr.domain.usecase.biography;

import com.portafolio.evr.domain.models.biography.Biography;
import com.portafolio.evr.domain.models.biography.BiographyRequest;
import com.portafolio.evr.domain.models.gateways.IBiographyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BiographyUseCase {

    private final IBiographyRepository iBiographyRepository;

    public Biography save(BiographyRequest biographyRequest){
        Biography biography = findById(biographyRequest.getId());
        if (biography != null){
            return null;
        }
        return  iBiographyRepository.save(biographyRequest);
    }

    public Biography findById(Long id){
        return iBiographyRepository.findById(id);
    }
}
