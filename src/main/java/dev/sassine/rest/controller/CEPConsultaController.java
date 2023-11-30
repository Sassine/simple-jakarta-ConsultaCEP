package dev.sassine.rest.controller;

import dev.sassine.rest.service.CEPConsultaService;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;

/**
 * REST Controller for handling CEP (Postal Code) lookup requests.
 */
@Path("/cep")
public class CEPConsultaController {

    // Service for CEP consultation
    @Inject
    private CEPConsultaService service;

    /**
     * Endpoint for consulting a CEP (Postal Code).
     * @param cep The CEP to be consulted.
     * @return A Response object containing the consultation result or an error message.
     */
    @GET
    @Path("{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar(@PathParam("cep") String cep) {
        // Validate the CEP format before proceeding with the consultation
        if (!isValidCep(cep)) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid CEP format").build();
        }
        // Return the result of the CEP consultation
        return Response.ok(service.consultaCep(cep)).build();
    }

    /**
     * Validates the format of the provided CEP (Postal Code).
     * @param cep The CEP to validate.
     * @return true if the CEP format is valid, false otherwise.
     */
    private boolean isValidCep(String cep) {
        // CEP format: 5 digits followed by an optional dash and 3 digits
        return cep != null && cep.matches("\d{5}-?\d{3}");
    }
}