package controller;

import model.Aluno;
import model.Responsavel;
import model.Turma;

import java.util.List;

/**
 * Controla as operações relacionadas aos alunos, como cadastro, remoção e busca.
 * Gerencia a lógica de negócio e a interação entre a view e o modelo Aluno.
 */
public class AlunoController {
    private List<Aluno> alunos;
    private ResponsavelController responsavelController;
    private TurmaController turmaController;

    /**
     * Construtor da classe AlunoController.
     *
     * @param alunos A lista de alunos que será gerenciada.
     * @param responsavelController O controlador de responsáveis para vincular alunos.
     */
    public AlunoController(List<Aluno> alunos, ResponsavelController responsavelController) {
        this.alunos = alunos;
        this.responsavelController = responsavelController;
    }

    /**
     * Define o controlador de turmas para permitir a vinculação de alunos.
     *
     * @param turmaController O controlador de turmas a ser definido.
     */
    public void setTurmaController(TurmaController turmaController) {
        this.turmaController = turmaController;
    }

    /**
     * Cadastra um novo aluno na lista.
     *
     * @param aluno O objeto Aluno a ser cadastrado.
     */
    public void cadastrarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    /**
     * Vincula um aluno a um responsável existente.
     *
     * @param aluno O aluno a ser vinculado.
     * @param idResponsavel O ID do responsável ao qual o aluno será vinculado.
     */
    public void vincularResponsavel(Aluno aluno, int idResponsavel) {
        Responsavel responsavel = responsavelController.buscarPorId(idResponsavel);
        if (responsavel != null) {
            aluno.setResponsavel(responsavel);
            responsavel.addDependente(aluno);
            System.out.println("Aluno vinculado ao responsável com sucesso.");
        } else {
            System.out.println("Responsável não encontrado.");
        }
    }

    /**
     * Retorna a lista completa de alunos cadastrados.
     *
     * @return Uma lista de objetos Aluno.
     */
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    /**
     * Busca um aluno pelo seu ID.
     *
     * @param id O ID do aluno a ser buscado.
     * @return O objeto Aluno correspondente, ou null se não for encontrado.
     */
    public Aluno buscarAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    /**
     * Remove um aluno da lista e suas referências.
     *
     * @param id O ID do aluno a ser removido.
     * @return true se o aluno foi removido com sucesso, false caso contrário.
     */
    public boolean removerAluno(int id) {
        Aluno aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            // Remover a referência ao responsável no aluno
            aluno.setResponsavel(null);

            // Remover o aluno da lista de dependentes do responsável
            Responsavel responsavel = aluno.getResponsavel();
            if (responsavel != null) {
                responsavel.getDependentes().remove(aluno);
            }

            // Remover o aluno da turma
            Turma turma = aluno.getTurma();
            if (turma != null) {
                turma.getAlunos().remove(aluno);
            }

            // Remover o aluno da lista principal de alunos
            alunos.remove(aluno);
            return true;
        }
        return false;
    }

    /**
     * Atualiza os dados de um aluno existente.
     *
     * @param id O ID do aluno a ser atualizado.
     * @param nome O novo nome do aluno.
     * @param dataNascimento A nova data de nascimento do aluno.
     * @param naturalidade A nova naturalidade do aluno.
     */
    public void atualizarAluno(int id, String nome, String dataNascimento, String naturalidade) {
        Aluno a = buscarAlunoPorId(id);
        if (a != null) {
            a.setNome(nome);
            a.setDataNascimento(dataNascimento);
            a.setNaturalidade(naturalidade);
        }
    }
}