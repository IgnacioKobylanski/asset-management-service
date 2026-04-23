package com.dev.web.api;

import com.dev.domain.model.Asset;
import com.dev.domain.service.AssetService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
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
    public List<Asset> getAll() {
        return assetService.listAll();
    }

    @POST
    @Operation(summary = "Crea un nuevo activo", description = "Guarda un activo en la base de datos tras validar los campos")
    @APIResponse(responseCode = "201", description = "Activo creado correctamente")
    public Response create(@jakarta.validation.Valid Asset asset) {
        assetService.create(asset);
        return Response.status(Response.Status.CREATED).entity(asset).build();
    }
}