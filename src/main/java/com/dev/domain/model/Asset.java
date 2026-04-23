package com.dev.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Asset extends PanacheEntity {

    @NotBlank(message="El nombre no puede estar vacío")
    public String name;

    public String description;

    @NotNull
    public String category;

    @NotNull
    @Positive(message="El valor debe ser mayor a cero")
    public BigDecimal value;


}