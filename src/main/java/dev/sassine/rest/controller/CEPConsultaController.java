package dev.sassine.rest.controller;

import dev.sassine.rest.service.CEPConsultaService;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cep")
public class CEPConsultaController {

    @Inject
    private CEPConsultaService service;

    @GET
    @Path("{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject consultar(@PathParam("cep") String cep) {
        return service.consultaCep(cep);
    }

}