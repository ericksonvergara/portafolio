package com.portafolio.evr.aplication.config;

import com.portafolio.evr.domain.models.gateways.IBiographyRepository;
import com.portafolio.evr.domain.models.gateways.IUserRepository;
import com.portafolio.evr.domain.usecase.biography.BiographyUseCase;
import com.portafolio.evr.domain.usecase.user.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UseCaseBeanConfig {

    @Bean
    public UserUseCase userUseCase(IUserRepository iUserRepository){
        return new UserUseCase(iUserRepository);
    }

    @Bean
    public BiographyUseCase biographyUseCase(IBiographyRepository iBiographyRepository){
        return new BiographyUseCase(iBiographyRepository);
    }
}
