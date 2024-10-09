package dev.gustavodscruz.dao;

import dev.gustavodscruz.to.PokemonTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonDAO extends Repository{
    public ArrayList<PokemonTO> findAll(){
        ArrayList<PokemonTO> pokemons = new ArrayList<>();
        String sql = "select * from pokemon";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while(rs.next()){
                    PokemonTO pokemon = new PokemonTO();
                    pokemon.setNome(rs.getString("nome"));
                    pokemon.setCodigo(rs.getLong("codigo"));
                    pokemon.setAltura(rs.getDouble("altura"));
                    pokemon.setCategoria(rs.getString("categoria"));
                    pokemon.setDataDaCaptura(rs.getDate("data_da_captura").toLocalDate());
                    pokemon.setPeso(rs.getDouble("peso"));
                    pokemons.add(pokemon);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return pokemons;
    }
}
