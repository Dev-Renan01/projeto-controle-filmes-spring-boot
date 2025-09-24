package br.com.dev_renan.controllers;

import br.com.dev_renan.model.Filme;
import br.com.dev_renan.repository.AvaliacaoRepository;
import br.com.dev_renan.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}