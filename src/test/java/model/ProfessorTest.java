package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTest {

    private Professor professor;
    private Endereco endereco;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua dos Lagos", "Centro", "55555-555", "Cidade Teste", "Estado Teste");
        professor = new Professor("Ana Clara", "20/03/1975", endereco, "11998877665", "Física");
    }

    @Test
    public void testGettersAndSetters() {
        // Teste dos getters
        assertEquals("Ana Clara", professor.getNome());
        assertEquals("20/03/1975", professor.getDataNascimento());
        assertEquals(endereco, professor.getEndereco());
        assertEquals("11998877665", professor.getTelefone());
        assertEquals("Física", professor.getFormacao()); // Método corrigido para getFormacao()
    }

    @Test
    public void testSetters() {
        professor.setNome("Ana Beatriz");
        professor.setDataNascimento("21/03/1976");
        professor.setTelefone("11911223344");
        professor.setFormacao("Química"); // Método corrigido para setFormacao()

        assertEquals("Ana Beatriz", professor.getNome());
        assertEquals("21/03/1976", professor.getDataNascimento());
        assertEquals("11911223344", professor.getTelefone());
        assertEquals("Química", professor.getFormacao()); // Método corrigido para getFormacao()
    }
}