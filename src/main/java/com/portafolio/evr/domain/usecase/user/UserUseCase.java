package com.portafolio.evr.domain.usecase.user;

import com.portafolio.evr.domain.models.gateways.IUserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserUseCase {
    private final IUserRepository iUserRepository;
}
