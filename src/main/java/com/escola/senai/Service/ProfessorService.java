package com.escola.senai.Service;

import com.escola.senai.Interface.ProfessorRepository;
import com.escola.senai.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {
    private final ProfessorRepository repository;

    public EscolaService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listaTodos(){
        return repository.findAll();
    }

     public Professor salvarProfessor(Professor professor){
        return repository.save(professor);
    }

    public void excluirProfessor(Long id){
        repository.deleteById(id);
    }

    public Professor buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }

}
