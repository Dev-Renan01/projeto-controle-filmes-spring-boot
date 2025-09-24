package br.com.dev_renan.controllers;

import br.com.dev_renan.model.Saudacoes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // O spring idantificar a classe como um controlador REST
public class SaudacoesController {


    @RequestMapping(value = "/saudacoes/{id}/{nome}")
    @ResponseBody
    public ResponseEntity<Saudacoes> saudacoes(@PathVariable Long id, @PathVariable String nome){

        Saudacoes usuario = new Saudacoes(id, nome);

        return new ResponseEntity<Saudacoes>(usuario,HttpStatus.OK);
    }

}
