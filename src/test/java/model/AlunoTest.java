package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    private Aluno aluno;
    private Endereco endereco;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua A", "Bairro B", "12345-000", "Cidade C", "Estado D");
        aluno = new Aluno("João Silva", "10/05/2010", endereco, "Brasileiro");
    }

    @Test
    public void testGettersAndSetters() {
        // Teste dos getters
        assertEquals("João Silva", aluno.getNome());
        assertEquals("10/05/2010", aluno.getDataNascimento());
        assertEquals(endereco, aluno.getEndereco());
        assertEquals("Brasileiro", aluno.getNaturalidade());
        assertNotNull(aluno.getId());

        // Teste dos setters
        aluno.setNome("João Souza");
        assertEquals("João Souza", aluno.getNome());
    }

    @Test
    public void testVinculacaoComResponsavel() {
        Responsavel responsavel = new Responsavel("Maria", "01/01/1980", endereco, "987654321");
        aluno.setResponsavel(responsavel);
        assertEquals(responsavel, aluno.getResponsavel());
    }
}