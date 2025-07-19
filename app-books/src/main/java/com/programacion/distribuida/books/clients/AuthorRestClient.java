package com.programacion.distribuida.books.clients;

import com.programacion.distribuida.books.dtos.AuthorDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri = "http://localhost:8080")
//@RegisterRestClient(configKey = "authors.api")
@RegisterRestClient(baseUri = "stork://authors-api")
public interface AuthorRestClient {
    @GET
    @Path("/find/{isbn}")

    @Retry(maxRetries = 2, delay = 0)
    @Fallback(fallbackMethod = "findByBookFallback")
    List<AuthorDto> findByBook(@PathParam("isbn") String isbn);

    default List<AuthorDto> findByBookFallback(String isbn) {
       var aut = new AuthorDto();
         aut.setId(0);
         aut.setName("--no disponible---");

        return List.of(aut);
    }
}
