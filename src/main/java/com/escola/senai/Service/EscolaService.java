package com.escola.senai.Service;


import com.escola.senai.Interface.EscolaRepository;
import com.escola.senai.Model.Escola;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    private final EscolaRepository repository;

    public EscolaService(EscolaRepository repository) {
        this.repository = repository;
    }

    public List<Escola> listaTodasEscolas() {
        return repository.findAll();
    }

    public Escola salvarEscola(Escola escola) {
        return repository.save(escola);
    }

    public Escola buscarEscolaPorId(Long id) {
        Optional<Escola> escolaOptional = repository.findById(id);
        return escolaOptional.orElse(null);
    }

    public void excluirEscola(Long id) {
        repository.deleteById(id);
    }
}
