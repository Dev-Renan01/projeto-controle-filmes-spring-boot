package br.com.dev_renan.controllers;

import br.com.dev_renan.model.Avaliacao;
import br.com.dev_renan.model.Filme;
import br.com.dev_renan.repository.AvaliacaoRepository;
import br.com.dev_renan.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

@RestController // O spring idantificar a classe como um controlador REST
public class FilmeController {
    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;


    @GetMapping(value = "/listarfilmes")
    @ResponseBody
    public ResponseEntity<List<Filme>> listarFilmes() {

        List<Filme> filmes = filmeRepository.findAll();

        return new ResponseEntity<List<Filme>>(filmes, HttpStatus.OK);
    }

    @PostMapping(value = "/salvarfilme")
    @ResponseBody
    public ResponseEntity<Filme> salvarFilme(@RequestBody Filme filme) {

        Filme sFilme = filmeRepository.save(filme);

        return new ResponseEntity<Filme>(sFilme, HttpStatus.CREATED);
    }

    @PutMapping(value = "/atualizarfilme")
    @ResponseBody
    public ResponseEntity<?> atualizarFilme(@RequestBody Filme filme) {

        if (filme.getId() == null) {
            return new ResponseEntity<String>("Por favor, informe o Id!", HttpStatus.OK);
        }

        Filme aFilme = filmeRepository.saveAndFlush(filme);

        return new ResponseEntity<Filme>(aFilme, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletarfilme")
    @ResponseBody
    public ResponseEntity<String> deletarFilme(@RequestParam Long id) {

        filmeRepository.deleteById(id);

        return new ResponseEntity<String>("Filme deletado com sucesso!", HttpStatus.OK);
    }

    //======================================================================

    @GetMapping(value = "/listaravaliacoes")
    @ResponseBody
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes() {

        List<Avaliacao> avaliacao = avaliacaoRepository.findAll();

        return new ResponseEntity<List<Avaliacao>>(avaliacao, HttpStatus.OK);
    }

    @PostMapping(value = "/salvaravaliacao")
    @ResponseBody
    public ResponseEntity<Avaliacao> salvarAvaliacao(@RequestBody Avaliacao avaliacao) {

        Avaliacao sAvaliacao = avaliacaoRepository.save(avaliacao);

        return new ResponseEntity<Avaliacao>(sAvaliacao, HttpStatus.CREATED);
    }

    @PutMapping(value = "/atualizaravaliacao")
    @ResponseBody
    public ResponseEntity<?> atualizaravaliacao(@RequestBody Avaliacao avaliacao) {

        if (avaliacao.getId() == null) {
            return new ResponseEntity<String>("Por favor, informe o Id!", HttpStatus.OK);
        }

        Avaliacao aAvaliacao = avaliacaoRepository.saveAndFlush(avaliacao);

        return new ResponseEntity<Avaliacao>(aAvaliacao, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletaravaliacao")
    @ResponseBody
    public ResponseEntity<String> deletarAvaliacao(@RequestParam Long id) {

        avaliacaoRepository.deleteById(id);

        return new ResponseEntity<String>("Avaliação deletada com sucesso!", HttpStatus.OK);
    }

    //================ CONSULTAS PERSONALIZADAS ===================

    @GetMapping(value = "/buscarPorTrechoTitulo")
    @ResponseBody
    public ResponseEntity<?> buscarPorTrechoTitulo(@RequestParam String trecho) {

        List<Filme> filmes = filmeRepository.findByTituloContaining(trecho);

        if (filmes.isEmpty()) {
            return new ResponseEntity<String>("Nenhum filme encontrado com esse trecho.", HttpStatus.OK);
        }

        return new ResponseEntity<List<Filme>>(filmes, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/buscarFilmePorGenero")
    @ResponseBody
    public ResponseEntity<?> buscarFilmePorGenero(@RequestParam String genero) {

        List<Filme> filmes = filmeRepository.findByGenero(genero);

        if (filmes.isEmpty()) {
            return new ResponseEntity<String>("Nenhum filme encontrado com esse gênero", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Filme>>(filmes, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarFilmePorAno")
    @ResponseBody
    public ResponseEntity<?> buscarFilmePorAno(@RequestParam Integer ano) {

        List<Filme> filmes = filmeRepository.findByAnoLancamento(ano);

        if (filmes.isEmpty()) {
            return new ResponseEntity<String>("Nenhum filme encontrado no ano informado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Filme>>(filmes, HttpStatus.OK);
    }


    @GetMapping(value = "/buscarAvaliacaoPorUsuario")
    @ResponseBody
    public ResponseEntity<?> buscarAvaliacaoPorUsuario(@RequestParam String usuario) {

        List<Avaliacao> avaliacao = avaliacaoRepository.findByUsuario(usuario);

        if (avaliacao.isEmpty()) {
            return new ResponseEntity<String>("Não existe avaliações feita por esse usuário", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Avaliacao>>(avaliacao, HttpStatus.OK);

    }
}