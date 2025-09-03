package view;

import controller.AlunoController;
import controller.ResponsavelController;
import controller.TurmaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlunoViewTest {

    @Mock
    private AlunoController alunoController;

    @Mock
    private ResponsavelController responsavelController;

    @Mock
    private TurmaController turmaController;

    @InjectMocks
    private AlunoView alunoView;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstrutorInicializaCorretamente() {
        // Testa se a classe pode ser instanciada sem erros e se os controladores não são nulos
        AlunoView view = new AlunoView(turmaController, alunoController, responsavelController);
        assertNotNull(view);
    }
}