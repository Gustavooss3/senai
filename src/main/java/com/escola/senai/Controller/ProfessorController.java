package com.escola.senai.Controller;


import com.escola.senai.Model.Professor;
import com.escola.senai.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> buscarProfessor(){
        return service.listaTodos();
    }

    @PostMapping
    public Professor salvarNovoProfessor(@RequestBody Professor professor){
        return service.salvarProfessor(professor);
    }

    @GetMapping("/{id}")
    public Professor buscarProfessorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        service.excluirProfessor(id);
    }


    @PutMapping("/{id}")
    public Professor atualizaAluno(@PathVariable Long id, @RequestBody Professor professorAtualizado){
        Professor existeProfessor = service.buscarPorId(id);

        if (existeProfessor == null) return null;
        existeProfessor.setNome(professorAtualizado.getNome());
        existeProfessor.setEmail(professorAtualizado.getEmail());
        existeProfessor.setTelefone(professorAtualizado.getTelefone());

        return  service.salvarProfessor(existeProfessor);
    }

}
