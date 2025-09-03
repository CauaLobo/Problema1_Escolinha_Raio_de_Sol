package controller;

import model.Aluno;
import model.Professor;
import model.Turma;

import java.util.List;

/**
 * Controla as operações relacionadas às turmas, como cadastro, matrícula e vinculação de professor.
 * Gerencia a lógica de negócio para a entidade Turma.
 */
public class TurmaController {
    private List<Turma> turmas;
    private ProfessorController professorController;
    private AlunoController alunoController;

    /**
     * Construtor da classe TurmaController.
     *
     * @param turmas A lista de turmas a ser gerenciada.
     * @param professorController O controlador de professores para vincular professores.
     */
    public TurmaController(List<Turma> turmas, ProfessorController professorController) {
        this.turmas = turmas;
        this.professorController = professorController;
    }

    /**
     * Define o controlador de alunos para permitir a matrícula.
     *
     * @param alunoController O controlador de alunos a ser definido.
     */
    public void setAlunoController(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    /**
     * Cadastra uma nova turma na lista.
     *
     * @param turma O objeto Turma a ser cadastrado.
     */
    public void cadastrarTurma(Turma turma) {
        turmas.add(turma);
    }

    /**
     * Retorna a lista completa de turmas cadastradas.
     *
     * @return Uma lista de objetos Turma.
     */
    public List<Turma> listarTurmas() {
        return turmas;
    }

    /**
     * Busca uma turma pelo seu ID.
     *
     * @param id O ID da turma a ser buscada.
     * @return O objeto Turma correspondente, ou null se não for encontrado.
     */
    public Turma buscarTurmaPorId(int id) {
        for (Turma turma : turmas) {
            if (turma.getId() == id) {
                return turma;
            }
        }
        return null;
    }

    /**
     * Define um professor regente para uma turma.
     *
     * @param idTurma O ID da turma.
     * @param idProfessor O ID do professor a ser vinculado.
     * @return true se a vinculação foi bem-sucedida, false caso contrário.
     */
    public boolean definirProfessorRegente(int idTurma, int idProfessor) {
        Turma turma = buscarTurmaPorId(idTurma);
        Professor professor = professorController.buscarProfessorPorId(idProfessor);

        if (turma != null && professor != null) {
            turma.setProfessorRegente(professor);
            return true;
        }
        return false;
    }

    /**
     * Matricula um aluno em uma turma.
     *
     * @param idTurma O ID da turma.
     * @param idAluno O ID do aluno a ser matriculado.
     * @return true se a matrícula foi bem-sucedida, false caso contrário.
     */
    public boolean matricularAluno(int idTurma, int idAluno) {
        Turma turma = buscarTurmaPorId(idTurma);
        Aluno aluno = alunoController.buscarAlunoPorId(idAluno);

        if (turma != null && aluno != null) {
            turma.addAluno(aluno);
            return true;
        }
        return false;
    }


    /**
     * Remove uma turma da lista.
     *
     * @param id O ID da turma a ser removida.
     * @return true se a turma foi removida com sucesso, false caso contrário.
     */
    public boolean removerTurma(int id) {
        Turma turma = buscarTurmaPorId(id);
        if (turma != null) {
            return turmas.remove(turma);
        }
        return false;
    }
}