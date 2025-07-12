package com.escola.senai.Controller;

import com.escola.senai.Model.Escola;
import com.escola.senai.Service.EscolaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {
    private final EscolaService service;

    public EscolaController(EscolaService service) {
        this.service = service;
    }


    @GetMapping
    public List<Escola> buscarEscolas() {
        return service.listaTodasEscolas();
    }

    @PostMapping
    public Escola salvarNovaEscola(@RequestBody Escola escola) {
        return service.salvarEscola(escola);
    }

    @GetMapping("/{id}")
    public Escola buscarEscolaPorId(@PathVariable Long id) {
        return service.buscarEscolaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEscola(@PathVariable Long id) {
        service.excluirEscola(id);
    }

    @PutMapping("/{id}")
    public Escola atualizarEscola(@PathVariable Long id, @RequestBody Escola escolaAtualizada) {
        Escola escolaExistente = service.buscarEscolaPorId(id);

        if (escolaExistente == null) return null;

        escolaExistente.setNome(escolaAtualizada.getNome());
        escolaExistente.setEndereco(escolaAtualizada.getEndereco());
        escolaExistente.setTelefone(escolaAtualizada.getTelefone());

        return service.salvarEscola(escolaExistente);
    }
}
