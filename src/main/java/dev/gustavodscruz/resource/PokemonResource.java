package dev.gustavodscruz.resource;

import dev.gustavodscruz.bo.PokemonBO;
import dev.gustavodscruz.to.PokemonTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pokemon")
public class PokemonResource {
    private PokemonBO pokemonBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        pokemonBO = new PokemonBO();
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
        pokemonBO = new PokemonBO();
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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PokemonTO pokemonTO){
        pokemonBO = new PokemonBO();
        PokemonTO resultado = pokemonBO.save(pokemonTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
