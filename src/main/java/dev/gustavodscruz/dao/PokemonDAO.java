package dev.gustavodscruz.dao;

import dev.gustavodscruz.to.PokemonTO;
import jakarta.validation.Valid;

import java.sql.Date;
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
    public PokemonTO findByCodigo(Long codigo){
        PokemonTO pokemon = new PokemonTO();
        String sql = "select * from pokemon where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pokemon.setCodigo(rs.getLong("codigo"));
                pokemon.setNome(rs.getString("nome"));
                pokemon.setPeso(rs.getDouble("peso"));
                pokemon.setAltura(rs.getDouble("altura"));
                pokemon.setCategoria(rs.getString("categoria"));
                pokemon.setDataDaCaptura(rs.getDate("data_da_captura").toLocalDate());
            }else{
                pokemon = null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        }finally {
            closeConnection();
        }
        return pokemon;
    }
    public PokemonTO save(PokemonTO pokemon){
        String sql = "insert into pokemon (nome, peso, altura, categoria, data_da_captura) values(?, ?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, pokemon.getNome());
            ps.setDouble(2, pokemon.getPeso());
            ps.setDouble(3, pokemon.getAltura());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDaCaptura()));
            if (ps.executeUpdate() > 0){
                return pokemon;
            }
        }catch (SQLException e){
            System.out.println("Erro ao salvar " + e.getMessage());
        }finally {
            closeConnection();
        }
        return null;

    }
    public boolean delete (Long codigo){
        String sql = "delete from pokemon where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }
}
