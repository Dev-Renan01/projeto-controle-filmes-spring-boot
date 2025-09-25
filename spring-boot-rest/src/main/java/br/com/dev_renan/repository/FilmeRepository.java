package br.com.dev_renan.repository;

import br.com.dev_renan.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query(value = "select u from Filme u where u.titulo like %?1%")
    List<Filme> findByTituloContaining(String trecho); //  buscar filmes cujo título contém um trecho.

    @Query(value = "select u from Filme u where u.genero like %?1%")
    List<Filme> findByGenero(String genero);// buscar filmes de um determinado gênero.


    List<Filme> findByAnoLancamento(Integer ano); // listar filmes lançados por determinado ano.

}
