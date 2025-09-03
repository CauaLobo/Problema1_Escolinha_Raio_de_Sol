package controller;

import model.Aluno;
import model.Endereco;
import model.Responsavel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResponsavelControllerTest {

    private ResponsavelController responsavelController;
    private AlunoController alunoController;
    private List<Responsavel> responsaveis;
    private List<Aluno> alunos;

    @BeforeEach
    public void setUp() {
        responsaveis = new ArrayList<>();
        alunos = new ArrayList<>();
        alunoController = new AlunoController(alunos, null); // ResponsavelController não é necessário para este teste
        responsavelController = new ResponsavelController(responsaveis);
        responsavelController.setAlunoController(alunoController);
    }

    @Test
    public void testCadastrarResponsavel() {
        Responsavel responsavel = new Responsavel("José", "10/10/1975", new Endereco("Rua A", "Bairro A", "12345-000", "Cidade A", "Estado A"), "11911111111");
        responsavelController.cadastrarResponsavel(responsavel);
        assertEquals(1, responsaveis.size());
        assertEquals("José", responsaveis.get(0).getNome());
    }

    @Test
    public void testBuscarPorIdExistente() {
        Responsavel responsavel = new Responsavel("Maria", "11/11/1980", new Endereco("Rua B", "Bairro B", "12345-000", "Cidade B", "Estado B"), "11922222222");
        responsaveis.add(responsavel);
        Responsavel encontrado = responsavelController.buscarPorId(responsavel.getId());
        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNome());
    }

    // ... outros testes para o ResponsavelController
}