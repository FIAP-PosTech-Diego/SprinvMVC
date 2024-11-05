package br.com.fiap.locatech.locatech.controllers;

import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.services.VeiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@Slf4j
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAllVeiculos(@RequestParam("page") int page,
                                                         @RequestParam("size") int size){
        log.info("Retornando veiculos");
        List<Veiculo> allVeiculo = veiculoService.findAllVeiculo(page, size);

        return ResponseEntity.ok(allVeiculo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculo(@PathVariable("id") Long id){
        log.info("Retornando veiculo");
        Optional<Veiculo> veiculo = veiculoService.findVeiculoById(id);

        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(@RequestBody  Veiculo veiculo){
        log.info("salvando veiculo");
        veiculoService.saveVeiculo(veiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo){
        log.info("atualizando veiculo");
        veiculoService.updateVeiculo(veiculo, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@PathVariable("id") Long id){
        log.info("deletando veiculo");
        veiculoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

}
