package controller;

import model.Endereco;
import model.Professor;
import model.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProfessorControllerTest {

    @Mock
    private ResponsavelController responsavelController;

    @InjectMocks
    private ProfessorController professorController;

    private List<Professor> professores;
    private List<Turma> turmas;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        professores = new ArrayList<>();
        turmas = new ArrayList<>();
        professorController = new ProfessorController(professores, turmas);
        professorController.setResponsavelController(responsavelController);
    }

    @Test
    public void testCadastrarProfessor() {
        Professor professor = new Professor("João", "01/01/1980", new Endereco("Rua A", "Bairro A", "12345-000", "Cidade A", "Estado A"), "11987654321", "Matemática");
        professorController.cadastrarProfessor(professor);
        assertEquals(1, professores.size());
        assertEquals("João", professores.get(0).getNome());
        verify(responsavelController, times(1)).cadastrarResponsavel(any(Professor.class));
    }

    @Test
    public void testBuscarProfessorPorIdExistente() {
        Professor professor = new Professor("Maria", "02/02/1985", new Endereco("Rua B", "Bairro B", "12345-000", "Cidade B", "Estado B"), "11998765432", "Português");
        professores.add(professor);
        Professor encontrado = professorController.buscarProfessorPorId(professor.getId());
        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNome());
    }

    @Test
    public void testRemoverProfessorComSucesso() {
        Professor professor = new Professor("Carlos", "03/03/1990", new Endereco("Rua C", "Bairro C", "12345-000", "Cidade C", "Estado C"), "11987654321", "História");
        professores.add(professor);
        when(responsavelController.removerResponsavel(professor.getId())).thenReturn(true);
        boolean removido = professorController.removerProfessor(professor.getId());
        assertTrue(removido);
        assertTrue(professores.isEmpty());
        verify(responsavelController, times(1)).removerResponsavel(professor.getId());
    }

    @Test
    public void testAtualizarProfessorComSucesso() {
        Professor professor = new Professor("Ana", "04/04/1995", new Endereco("Rua D", "Bairro D", "12345-000", "Cidade D", "Estado D"), "11999999999", "Ciências");
        professores.add(professor);

        String novoNome = "Ana Beatriz";
        String novoTelefone = "11888888888";
        Endereco novoEndereco = new Endereco("Rua E", "Bairro E", "12345-000", "Cidade E", "Estado E");

        professorController.atualizarProfessor(professor.getId(), novoNome, "04/04/1995", novoEndereco, novoTelefone, "Ciências");

        assertEquals(novoNome, professor.getNome());
        assertEquals(novoTelefone, professor.getTelefone());
        assertEquals(novoEndereco.getRua(), professor.getEndereco().getRua());
    }
}