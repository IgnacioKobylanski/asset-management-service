package com.dev.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AssetDTO {
    @Schema(readOnly = true)
    public Long id;

    @NotBlank(message = "El nombre es obligatorio")
    public String name;

    @NotBlank(message = "La categoría es obligatoria")
    public String category;

    public String description;

    @Positive(message = "El valor debe ser mayor a cero")
    public BigDecimal value;

    @Schema(readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime createdAt;
    @Schema(readOnly = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime updatedAt;
}