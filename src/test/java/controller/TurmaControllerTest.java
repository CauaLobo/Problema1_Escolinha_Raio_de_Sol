package controller;

import model.Aluno;
import model.Professor;
import model.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaControllerTest {

    private ProfessorController professorController;
    private AlunoController alunoController;
    private TurmaController turmaController;
    private List<Turma> turmas;
    private List<Professor> professores;
    private List<Aluno> alunos;

    @BeforeEach
    public void setUp() {
        turmas = new ArrayList<>();
        professores = new ArrayList<>();
        alunos = new ArrayList<>();

        professorController = new ProfessorController(professores, turmas);
        alunoController = new AlunoController(alunos, null); // ResponsavelController não é necessário para este teste
        turmaController = new TurmaController(turmas, professorController);
        turmaController.setAlunoController(alunoController);
    }

    @Test
    public void testCadastrarTurma() {
        Turma turma = new Turma("1º Ano", 2025);
        turmaController.cadastrarTurma(turma);
        assertEquals(1, turmas.size());
        assertEquals("1º Ano", turmas.get(0).getSerie());
    }

    @Test
    public void testDefinirProfessorRegenteComSucesso() {
        Turma turma = new Turma("2º Ano", 2025);
        turmas.add(turma);
        Professor professor = new Professor("Prof. Teste", "01/01/1980", null, "11987654321", "História");
        professorController.cadastrarProfessor(professor);

        boolean resultado = turmaController.definirProfessorRegente(turma.getId(), professor.getId());

        assertTrue(resultado);
        assertNotNull(turma.getProfessorRegente());
        assertEquals(professor, turma.getProfessorRegente());
    }

    // ... outros testes para o TurmaController
}