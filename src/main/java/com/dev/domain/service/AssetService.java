package com.dev.domain.service;

import com.dev.domain.model.Asset;
import com.dev.domain.repository.AssetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AssetService {

    @Inject
    AssetRepository assetRepository;

    public List<Asset> listAll() {
        return assetRepository.listAll();
    }

    @Transactional
    public void create(Asset asset) {
        assetRepository.persist(asset);
    }
}