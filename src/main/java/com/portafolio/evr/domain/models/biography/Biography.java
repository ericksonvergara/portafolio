package com.portafolio.evr.domain.models.biography;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Biography {
    private Long id;
    private String title;
    private String description;
}
