package com.portafolio.evr.domain.models.biography;

import lombok.Builder;
import lombok.Data;
@Data@Builder(toBuilder = true)
public class BiographyRequest {
    private Long id;
    private String title;
    private String description;
}
