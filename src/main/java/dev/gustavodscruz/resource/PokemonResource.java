package dev.gustavodscruz.resource;

import dev.gustavodscruz.bo.PokemonBO;
import dev.gustavodscruz.to.PokemonTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pokemon")
public class PokemonResource {
    private PokemonBO pokemonBO = new PokemonBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        PokemonBO pokemonBO = new PokemonBO();
        ArrayList<PokemonTO> resultado = pokemonBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{codigo}")
    public Response findByCodigo(@PathParam("codigo") Long codigo){
        PokemonTO resultado = pokemonBO.findByCodigo(codigo);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
