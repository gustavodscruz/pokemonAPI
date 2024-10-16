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
    private PokemonBO pokemonBO = new PokemonBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PokemonTO pokemonTO){
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

    @DELETE
    @Path("/{codigo}")
    public Response delete (@PathParam("codigo") Long codigo){
        if (pokemonBO.delete(codigo)){
            return Response.status(204).build();
        }
        return Response.status(404).build();
    }

//    @DELETE
//    @Path("/{codigo}")
//    public Response delete (@PathParam("codigo") Long codigo){
//        Response.ResponseBuilder response = null;
//        if (pokemonBO.delete(codigo)){
//            response = Response.status(204);
//        } else{
//            response = Response.status(404);
//        }
//        return response.build();
//    }
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("codigo") Long codigo, @Valid PokemonTO pokemon){
        PokemonTO resultado = pokemonBO.edit(codigo, pokemon);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        } else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
