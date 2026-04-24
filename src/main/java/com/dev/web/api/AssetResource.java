package com.dev.web.api;

import com.dev.domain.service.AssetService;
import com.dev.web.dto.AssetDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/assets")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Assets", description = "Operaciones relacionadas con la gestión de activos")
public class AssetResource {

    @Inject
    AssetService assetService;

    @GET
    @Operation(summary = "Lista todos los activos", description = "Retorna un listado completo de los activos registrados")
    @APIResponse(responseCode = "200", description = "Lista obtenida con éxito")
    public List<AssetDTO> getAll() {
        return assetService.listAll();
    }

    @POST
    @Operation(summary = "Crea un nuevo activo", description = "Guarda un activo en la base de datos tras validar los campos")
    @APIResponse(responseCode = "201", description = "Activo creado correctamente")
    public Response create(@Valid AssetDTO assetDto) {
        AssetDTO savedDto = assetService.create(assetDto);
        return Response.status(Response.Status.CREATED).entity(savedDto).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Elimina un activo", description = "Borra un activo usando su ID")
    @APIResponse(responseCode = "204", description = "Activo eliminado con éxito")
    public Response delete(@PathParam("id") Long id) {
        assetService.delete(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Actualiza un activo", description = "Modifica los datos de un activo existente")
    @APIResponse(responseCode = "200", description = "Activo actualizado correctamente")
    @APIResponse(responseCode = "404", description = "No se encontró el activo para actualizar")
    public Response update(@PathParam("id") Long id, @Valid AssetDTO assetDto) {
        AssetDTO updatedDto = assetService.update(id, assetDto);
        return Response.ok(updatedDto).build();
    }
}