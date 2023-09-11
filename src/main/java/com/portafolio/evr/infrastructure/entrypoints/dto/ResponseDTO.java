package com.portafolio.ndrm.portafolio.infrastructure.entrypoints.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder(toBuilder = true)
public class ResponseDTO<T>{

    private boolean status;

    private int code;

    private String msg;

    private T response;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T errors;

    public static <T> ResponseDTO success(boolean status,int code, String msg, T response ){
        return ResponseDTO.builder()
                .status(status)
                .code(code)
                .msg(msg)
                .response(response)
                .build();
    }

    public static <T> ResponseDTO buildError(boolean  status, int code, T errors, String msg ) {
        return ResponseDTO.builder()
                .status(status)
                .code(code)
                .msg(msg)
                .errors(errors)
                .build();
    }
}
