package dev.gustavodscruz.bo;

import dev.gustavodscruz.dao.PokemonDAO;
import dev.gustavodscruz.to.PokemonTO;

import java.util.ArrayList;

public class PokemonBO {
    PokemonDAO pokemonDAO;
    public ArrayList<PokemonTO> findAll(){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.findAll();
    }

    public PokemonTO findByCodigo(Long codigo){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.findByCodigo(codigo);
    }

    public PokemonTO save(PokemonTO pokemon){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.save(pokemon);
    }

    public boolean delete(Long codigo){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.delete(codigo);
    }
    public PokemonTO edit(Long codigo, PokemonTO pokemon){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.edit(codigo, pokemon);
    }
}
