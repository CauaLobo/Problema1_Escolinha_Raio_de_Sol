package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {

    private Endereco endereco;

    @BeforeEach
    public void setUp() {
        endereco = new Endereco("Rua X", "Bairro Y", "12345-000", "Cidade Z", "Estado W");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Rua X", endereco.getRua());
        assertEquals("Bairro Y", endereco.getBairro());
        assertEquals("12345-000", endereco.getCep());
        assertEquals("Cidade Z", endereco.getCidade());
        assertEquals("Estado W", endereco.getEstado());

        endereco.setRua("Rua Nova");
        endereco.setBairro("Bairro Novo");
        endereco.setCep("98765-432");
        endereco.setCidade("Nova Cidade");
        endereco.setEstado("Novo Estado");

        assertEquals("Rua Nova", endereco.getRua());
        assertEquals("Bairro Novo", endereco.getBairro());
        assertEquals("98765-432", endereco.getCep());
        assertEquals("Nova Cidade", endereco.getCidade());
        assertEquals("Novo Estado", endereco.getEstado());
    }
}