package controller;

import model.Aluno;
import model.Endereco;
import model.Responsavel;

import java.util.ArrayList;
import java.util.List;

/**
 * Controla as operações relacionadas aos responsáveis, como cadastro, busca e remoção.
 * Gerencia a lógica de negócio para a entidade Responsavel.
 */
public class ResponsavelController {
    private List<Responsavel> responsaveis;
    private AlunoController alunoController;

    /**
     * Construtor da classe ResponsavelController.
     *
     * @param responsaveis A lista de responsáveis a ser gerenciada.
     */
    public ResponsavelController(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    /**
     * Define o controlador de alunos para permitir a vinculação e remoção.
     *
     * @param alunoController O controlador de alunos a ser definido.
     */
    public void setAlunoController(AlunoController alunoController) {
        this.alunoController = alunoController;
    }

    /**
     * Cadastra um novo responsável na lista.
     *
     * @param responsavel O objeto Responsavel a ser cadastrado.
     */
    public void cadastrarResponsavel(Responsavel responsavel) {
        responsaveis.add(responsavel);
    }

    /**
     * Vincula um aluno a um responsável.
     *
     * @param responsavel O responsável.
     * @param aluno O aluno a ser vinculado.
     */
    public void vincularAluno(Responsavel responsavel, Aluno aluno) {
        responsavel.addDependente(aluno);
    }

    /**
     * Retorna a lista completa de responsáveis cadastrados.
     *
     * @return Uma lista de objetos Responsavel.
     */
    public List<Responsavel> listar() {
        return responsaveis;
    }

    /**
     * Busca um responsável pelo seu ID.
     *
     * @param id O ID do responsável a ser buscado.
     * @return O objeto Responsavel correspondente, ou null se não for encontrado.
     */
    public Responsavel buscarPorId(int id) {
        for (Responsavel r : responsaveis) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    /**
     * Remove um responsável, e também remove todos os seus dependentes.
     *
     * @param id O ID do responsável a ser removido.
     * @return true se o responsável foi removido com sucesso, false caso contrário.
     */
    public boolean removerResponsavel(int id) {
        Responsavel responsavel = buscarPorId(id);
        if (responsavel != null) {
            // Cria uma cópia da lista de dependentes para evitar o ConcurrentModificationException
            List<Aluno> dependentesParaRemover = new ArrayList<>(responsavel.getDependentes());
            for (Aluno aluno : dependentesParaRemover) {
                alunoController.removerAluno(aluno.getId());
            }
            return responsaveis.remove(responsavel);
        }
        return false;
    }

    /**
     * Atualiza os dados de um responsável existente.
     *
     * @param id O ID do responsável a ser atualizado.
     * @param nome O novo nome.
     * @param dataNascimento A nova data de nascimento.
     * @param endereco O novo endereço.
     * @param telefone O novo telefone.
     */
    public void atualizarResponsavel(Integer id, String nome, String dataNascimento, Endereco endereco, String telefone) {
        Responsavel r = buscarPorId(id);

        // Se o responsável for encontrado, atualiza os dados
        if (r != null) {
            r.setNome(nome);
            r.setDataNascimento(dataNascimento);
            r.setEndereco(endereco);
            r.setTelefone(telefone);
        }
    }
}