package br.senai.sp.escolamvc.api;

import br.senai.sp.escolamvc.model.Professor;
import br.senai.sp.escolamvc.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorRestController {

    @Autowired
    private ProfessorRepository ProfessorRepository;

    @GetMapping ("/listar")
    public List<Professor> listar() {
        return ProfessorRepository.findAll();
    }

    @PostMapping("/inserir")
    public void inserir(@RequestBody Professor Professor) {
        ProfessorRepository.save(Professor);
    }

    @PutMapping ("/alterar")
    public void alterar(@RequestBody Professor Professor) {
        ProfessorRepository.save(Professor);
    }
    @DeleteMapping ("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        ProfessorRepository.deleteById(id);
    }

    @PostMapping ("/inserir-varios")
    public void inserirVarios(@RequestBody List<Professor> Professors) {
        ProfessorRepository.saveAll(Professors);
    }
    @GetMapping("/buscar/{id}")
    public Professor buscar(@PathVariable Long id) {
        return ProfessorRepository.findById(id).get();
    }
    @GetMapping("/buscar-por-nome/{nome}")
    public List<Professor> buscarPorNome(@PathVariable String nome) {
        return ProfessorRepository.findProfessorsByNomeContaining(nome);
    }
}
