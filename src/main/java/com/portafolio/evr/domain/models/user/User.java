package com.portafolio.evr.domain.models.user;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class User {

    private Long id;
    private String name;
    private String password;
    private String secret;
    private String email;
}
