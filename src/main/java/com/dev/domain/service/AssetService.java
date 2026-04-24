package com.dev.domain.service;

import com.dev.domain.model.Asset;
import com.dev.domain.repository.AssetRepository;
import com.dev.web.dto.AssetDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AssetService {

    @Inject
    AssetRepository assetRepository;

    public List<AssetDTO> listAll() {
        return assetRepository.listAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AssetDTO create(AssetDTO dto) {
        Asset entity = mapToEntity(dto);
        assetRepository.persist(entity);
        return mapToDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        Asset entity = assetRepository.findById(id);

        if (entity == null) {
            throw new NotFoundException("No se puede eliminar: No se encontró el activo con ID " + id);
        }
        assetRepository.delete(entity);
    }

    @Transactional
    public AssetDTO update(Long id, AssetDTO dto) {
        Asset entity = assetRepository.findById(id);
        if (entity == null) {
            throw new NotFoundException("No se encontró el activo con el ID proporcionado");
        }

        entity.name = dto.name;
        entity.category = dto.category;
        entity.value = dto.value;
        entity.description = dto.description;

        return mapToDTO(entity);
    }


    private AssetDTO mapToDTO(Asset entity) {
        AssetDTO dto = new AssetDTO();
        dto.id = entity.id;
        dto.name = entity.name;
        dto.category = entity.category;
        dto.value = entity.value;
        dto.description = entity.description;
        return dto;
    }

    private Asset mapToEntity(AssetDTO dto) {
        Asset entity = new Asset();
        entity.name = dto.name;
        entity.category = dto.category;
        entity.value = dto.value;
        entity.description = dto.description;
        return entity;
    }
}