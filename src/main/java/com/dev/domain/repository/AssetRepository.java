package com.dev.domain.repository;

import com.dev.domain.model.Asset;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssetRepository implements PanacheRepository<Asset> {
}