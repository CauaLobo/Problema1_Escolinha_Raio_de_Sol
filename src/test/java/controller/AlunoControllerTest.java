package controller;

import model.Aluno;
import model.Endereco;
import model.Responsavel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoControllerTest {

    private ResponsavelController responsavelController;
    private TurmaController turmaController;
    private AlunoController alunoController;
    private List<Aluno> alunos;
    private List<Responsavel> responsaveis;
    private List<model.Turma> turmas;

    @BeforeEach
    public void setUp() {
        alunos = new ArrayList<>();
        responsaveis = new ArrayList<>();
        turmas = new ArrayList<>();

        responsavelController = new ResponsavelController(responsaveis);
        turmaController = new TurmaController(turmas, null); // ProfessorController não é necessário para este teste

        alunoController = new AlunoController(alunos, responsavelController);
        alunoController.setTurmaController(turmaController);
    }

    @Test
    public void testCadastrarAluno() {
        Aluno aluno = new Aluno("João", "01/01/2010", new Endereco("Rua A", "Centro", "12345-678", "Cidade A", "Estado A"), "Brasileiro");
        alunoController.cadastrarAluno(aluno);
        assertEquals(1, alunos.size());
        assertEquals("João", alunos.get(0).getNome());
    }

    @Test
    public void testBuscarAlunoPorIdExistente() {
        Aluno aluno = new Aluno("Maria", "02/02/2011", new Endereco("Rua B", "Bairro B", "12345-678", "Cidade B", "Estado B"), "Brasileira");
        alunos.add(aluno);
        Aluno encontrado = alunoController.buscarAlunoPorId(aluno.getId());
        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNome());
    }

    // ... outros testes para o AlunoController
}