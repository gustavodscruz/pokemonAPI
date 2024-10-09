package dev.gustavodscruz.bo;

import dev.gustavodscruz.dao.PokemonDAO;
import dev.gustavodscruz.to.PokemonTO;

import java.util.ArrayList;

public class PokemonBO {
    public ArrayList<PokemonTO> findAll(){
        PokemonDAO pokemonDAO = new PokemonDAO();
        return pokemonDAO.findAll();
    }

    public PokemonTO findByCodigo(Long codigo){
        PokemonDAO pokemonDAO = new PokemonDAO();
        return pokemonDAO.findByCodigo(codigo);
    }
}
