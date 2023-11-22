package dev.sassine.rest.service;


import jakarta.enterprise.context.ApplicationScoped;

import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.client.ClientBuilder;

import java.io.StringReader;


import static jakarta.json.Json.createReader;
import static jakarta.ws.rs.core.Response.Status.OK;

@ApplicationScoped
public class CEPConsultaService {

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
                        "{ \"error\":\"Falha na requisição com status: %s\" }".formatted(response.getStatus())
                        , response.getStatus()
                );
            }
        }
    }
}
