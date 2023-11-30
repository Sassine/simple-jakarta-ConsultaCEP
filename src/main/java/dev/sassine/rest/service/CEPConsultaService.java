package dev.sassine.rest.service;


import jakarta.enterprise.context.ApplicationScoped;

import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.ClientBuilder;

import java.io.StringReader;


import static jakarta.json.Json.createReader;
import static jakarta.ws.rs.core.Response.Status.OK;

import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.JsonReader;
import static javax.json.Json.createReader;
import static javax.ws.rs.core.Response.Status.OK;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.WebApplicationException;
import java.io.StringReader;

/**
 * Service class for consulting Brazilian postal codes (CEPs) via BrasilAPI.
 */
@ApplicationScoped
public class CEPConsultaService {

    /**
     * Consults a given CEP (postal code) and returns its details as a JsonObject.
     *
     * @param cep The Brazilian postal code to be consulted.
     * @return A JsonObject containing the details of the given postal code.
     * @throws WebApplicationException If the request to the BrasilAPI fails.
     */
    public JsonObject consultaCep(String cep) {
        try (var response = ClientBuilder
                .newClient()
                .target("https://brasilapi.com.br/api/cep/v1/")
                .path(cep)
                .request()
                .get()) {
            if (response.getStatus() == OK.getStatusCode()) {
                var jsonString = response.readEntity(String.class);
                try (JsonReader jsonReader = createReader(new StringReader(jsonString))) {
                    return jsonReader.readObject();
                }
            } else {
                throw new WebApplicationException(
                        "{ \"error\":\"Falha na requisição com status: %s\" }".formatted(response.getStatus()),
                        response.getStatus()
                );
            }
        }
    }
}
