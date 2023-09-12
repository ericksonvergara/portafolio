package com.portafolio.evr.infrastructure.entrypoints.biography;

import com.portafolio.evr.domain.models.biography.Biography;
import com.portafolio.evr.domain.models.biography.BiographyRequest;
import com.portafolio.evr.domain.usecase.biography.BiographyUseCase;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Log4j2
public class BiographyEntryPoint {

    private final BiographyUseCase biographyUseCase;

    @PostMapping("save")
    public ResponseEntity<?> saveBiography(@RequestBody BiographyRequest biographyRequest, HttpServletResponse response) {
        try {
            biographyUseCase.save(biographyRequest);
            return ResponseEntity.ok("Biography saved successfully");
        } catch (Exception e) {
            log.error("Error saving biography: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving biography");
        }
    }

    @GetMapping("/find")
    public ResponseEntity<?> findBiography(@RequestParam Long id) {
        try {
            Biography biography = biographyUseCase.findById(id);
            return ResponseEntity.ok(biography);
        } catch (Exception e) {
            log.error("Error saving biography: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error find biography");
        }


    }
}
