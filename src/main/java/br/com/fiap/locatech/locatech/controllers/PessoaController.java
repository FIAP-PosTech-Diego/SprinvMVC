package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.services.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
@Slf4j
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAllPessoas(@RequestParam("page") int page,
                                                         @RequestParam("size") int size){
        log.info("Retornando Pessoas");
        List<Pessoa> allPessoa = pessoaService.findAllPessoa(page, size);

        return ResponseEntity.ok(allPessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoa(@PathVariable("id") Long id){
        log.info("Retornando Pessoa");
        Optional<Pessoa> Pessoa = pessoaService.findPessoaById(id);

        return ResponseEntity.ok(Pessoa);
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa Pessoa){
        log.info("salvando Pessoa");
        pessoaService.savePessoa(Pessoa);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoa Pessoa){
        log.info("atualizando Pessoa");
        pessoaService.updatePessoa(Pessoa, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@PathVariable("id") Long id){
        log.info("deletando Pessoa");
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

}
