package view;

import controller.AlunoController;
import controller.ResponsavelController;
import controller.TurmaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResponsavelViewTest {

    @Mock
    private ResponsavelController responsavelController;

    @Mock
    private AlunoController alunoController;

    @Mock
    private TurmaController turmaController;

    @InjectMocks
    private ResponsavelView responsavelView;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstrutorInicializaCorretamente() {
        // Testa se a classe pode ser instanciada com todas as suas dependências
        ResponsavelView view = new ResponsavelView(responsavelController, alunoController, turmaController);
        assertNotNull(view);
    }
}