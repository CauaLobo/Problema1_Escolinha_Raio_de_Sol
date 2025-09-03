package controller;

import model.Endereco;
import model.Professor;
import model.Turma;

import java.util.List;

/**
 * Controla as operações relacionadas aos professores, como cadastro e remoção.
 * Gerencia a lógica de negócio para a entidade Professor.
 */
public class ProfessorController {
    private List<Professor> professores;
    private List<Turma> turmas;
    private ResponsavelController responsavelController;

    /**
     * Construtor da classe ProfessorController.
     *
     * @param professores A lista de professores a ser gerenciada.
     * @param turmas A lista de turmas para vinculação.
     */
    public ProfessorController(List<Professor> professores, List<Turma> turmas) {
        this.professores = professores;
        this.turmas = turmas;
    }

    /**
     * Define o controlador de responsáveis para permitir a dupla vinculação.
     *
     * @param responsavelController O controlador de responsáveis a ser definido.
     */
    public void setResponsavelController(ResponsavelController responsavelController) {
        this.responsavelController = responsavelController;
    }

    /**
     * Cadastra um novo professor na lista e o adiciona como responsável.
     *
     * @param professor O objeto Professor a ser cadastrado.
     */
    public void cadastrarProfessor(Professor professor) {
        professores.add(professor);
        // Adiciona o professor também como um responsável, se ele não for já um.
        if (!responsavelController.listar().contains(professor)) {
            responsavelController.cadastrarResponsavel(professor);
        }
    }

    /**
     * Retorna a lista de todos os professores cadastrados.
     *
     * @return Uma lista de objetos Professor.
     */
    public List<Professor> listarProfessores() {
        return professores;
    }

    /**
     * Busca um professor pelo seu ID.
     *
     * @param id O ID do professor a ser buscado.
     * @return O objeto Professor correspondente, ou null se não for encontrado.
     */
    public Professor buscarProfessorPorId(int id) {
        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    /**
     * Remove um professor da lista, removendo também suas referências.
     *
     * @param id O ID do professor a ser removido.
     * @return true se o professor foi removido com sucesso, false caso contrário.
     */
    public boolean removerProfessor(int id) {
        Professor professor = buscarProfessorPorId(id);
        if (professor != null) {
            // Remove o professor como responsável primeiro
            responsavelController.removerResponsavel(professor.getId());
            // Remove as turmas que ele leciona
            for (Turma turma : professor.getTurmas()) {
                turma.setProfessorRegente(null);
            }
            // Remove o professor da lista de professores
            return professores.remove(professor);
        }
        return false;
    }

    /**
     * Atualiza os dados de um professor existente.
     *
     * @param id O ID do professor a ser atualizado.
     * @param nome O novo nome do professor.
     * @param dataNascimento A nova data de nascimento.
     * @param endereco O novo endereço do professor.
     * @param telefone O novo telefone do professor.
     * @param formacao A nova formação do professor.
     */
    public void atualizarProfessor(int id, String nome, String dataNascimento, Endereco endereco, String telefone, String formacao) {
        Professor p = buscarProfessorPorId(id);

        // Se o professor for encontrado, atualiza os dados
        if (p != null) {
            p.setNome(nome);
            p.setDataNascimento(dataNascimento);
            p.setEndereco(endereco);
            p.setTelefone(telefone);
            p.setFormacao(formacao);
        }
    }
}