package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {

    private Turma turma;
    private Professor professor;
    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        turma = new Turma("5º Ano", 2024);
        professor = new Professor("Pedro", "10/10/1980", null, "11223344", "História");
        aluno = new Aluno("Ana", "05/05/2015", null, "Brasileira");
    }

    @Test
    public void testAddAndRemoveAluno() {
        turma.addAluno(aluno);
        assertEquals(1, turma.getAlunos().size());
        assertTrue(turma.getAlunos().contains(aluno));

        turma.removeAluno(aluno);
        assertEquals(0, turma.getAlunos().size());
        assertFalse(turma.getAlunos().contains(aluno));
    }

    @Test
    public void testDefinirProfessorRegente() {
        turma.setProfessorRegente(professor);
        assertEquals(professor, turma.getProfessorRegente());
    }
}