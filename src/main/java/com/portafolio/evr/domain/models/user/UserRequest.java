package com.portafolio.evr.domain.models.user;

import lombok.Builder;
import lombok.Data;

@Data@Builder(toBuilder = true)
public class UserRequest {
    private String name;
    private  String password;
    private  String secret;
    private String email;
}
