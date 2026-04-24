package com.dev.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AssetDTO {
    public Long id;

    @NotBlank(message = "El nombre es obligatorio")
    public String name;

    @NotBlank(message = "La categoría es obligatoria")
    public String category;

    public String description;

    @Positive(message = "El valor debe ser mayor a cero")
    public java.math.BigDecimal value;;
}