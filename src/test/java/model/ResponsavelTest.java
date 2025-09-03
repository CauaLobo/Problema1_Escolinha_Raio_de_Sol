package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResponsavelTest {

    private Responsavel responsavel;
    private Endereco endereco;
    private Aluno dependente1;
    private Aluno dependente2;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua Principal", "Bairro", "12345-000", "Cidade", "Estado");
        responsavel = new Responsavel("Carlos", "01/01/1980", endereco, "11987654321");
        dependente1 = new Aluno("Filho A", "01/01/2010", endereco, "Brasileiro");
        dependente2 = new Aluno("Filho B", "02/02/2012", endereco, "Brasileiro");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Carlos", responsavel.getNome());
        assertEquals("01/01/1980", responsavel.getDataNascimento());
        assertEquals(endereco, responsavel.getEndereco());
        assertEquals("11987654321", responsavel.getTelefone());
        assertNotNull(responsavel.getDependentes());
        assertTrue(responsavel.getDependentes().isEmpty());
    }

    @Test
    public void testAddDependente() {
        responsavel.addDependente(dependente1);
        assertEquals(1, responsavel.getDependentes().size());
        assertTrue(responsavel.getDependentes().contains(dependente1));

        responsavel.addDependente(dependente2);
        assertEquals(2, responsavel.getDependentes().size());
        assertTrue(responsavel.getDependentes().contains(dependente2));
    }
}