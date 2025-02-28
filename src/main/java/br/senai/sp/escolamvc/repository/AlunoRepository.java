package br.senai.sp.escolamvc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.sp.escolamvc.model.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findAlunosByNomeContaining(String nome);
}
