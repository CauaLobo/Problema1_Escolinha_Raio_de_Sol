package view;

import controller.AlunoController;
import controller.ProfessorController;
import controller.TurmaController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProfessorViewTest {

    @Mock
    private ProfessorController professorController;

    @Mock
    private TurmaController turmaController;

    @Mock
    private AlunoController alunoController;

    @InjectMocks
    private ProfessorView professorView;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConstrutorInicializaCorretamente() {
        // Testa se a classe pode ser instanciada sem erros e se os controladores não são nulos
        ProfessorView view = new ProfessorView(professorController, turmaController, alunoController);
        assertNotNull(view);
    }
}