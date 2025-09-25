package br.com.dev_renan.repository;

import br.com.dev_renan.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    @Query(value = "select u from Avaliacao u where u.usuario like %?1%")
    List<Avaliacao> findByUsuario(String usuario); //buscar todas as avaliações feitas por um usuário.

}