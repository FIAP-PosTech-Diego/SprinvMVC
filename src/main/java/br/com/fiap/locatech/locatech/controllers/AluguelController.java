package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.services.AluguelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alugueis")
@Slf4j
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> findAllAlugueis(@RequestParam("page") int page,
                                                         @RequestParam("size") int size){
        log.info("Retornando Alugueis");
        List<Aluguel> allAluguel = aluguelService.findAllAluguel(page, size);

        return ResponseEntity.ok(allAluguel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findAluguel(@PathVariable("id") Long id){
        log.info("Retornando Aluguel");
        Optional<Aluguel> Aluguel = aluguelService.findAluguelById(id);

        return ResponseEntity.ok(Aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> saveAluguel(@RequestBody Aluguel Aluguel){
        log.info("salvando Aluguel");
        aluguelService.saveAluguel(Aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(@PathVariable("id") Long id, @RequestBody Aluguel Aluguel){
        log.info("atualizando Aluguel");
        aluguelService.updateAluguel(Aluguel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateAluguel(@PathVariable("id") Long id){
        log.info("deletando Aluguel");
        aluguelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

}
