package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade Responsável.
 * Esta classe estende a classe Pessoa e adiciona atributos específicos de um responsável,
 * como telefone e uma lista de dependentes.
 */
public class Responsavel extends Pessoa {
    private String telefone;
    private List<Aluno> dependentes;

    /**
     * Construtor da classe Responsavel.
     *
     * @param nome O nome do responsável.
     * @param dataNascmento A data de nascimento do responsável.
     * @param endereco O endereço do responsável.
     * @param telefone O telefone de contato do responsável.
     */
    public Responsavel(String nome, String dataNascmento, Endereco endereco, String  telefone){
        super(nome,dataNascmento,endereco);
        this.telefone =telefone;
        this.dependentes = new ArrayList<>();
    }

    /** Retorna o telefone de contato do responsável. */
    public String getTelefone(){ return telefone; }
    /** Define o telefone de contato do responsável. */
    public void setTelefone(String telefone){ this.telefone = telefone; }

    /** Retorna a lista de alunos dependentes. */
    public List<Aluno> getDependentes(){ return dependentes; }

    /**
     * Adiciona um aluno à lista de dependentes.
     *
     * @param dependente O aluno a ser adicionado.
     */
    public void addDependente(Aluno dependente){ dependentes.add(dependente); }

    /**
     * Representação em String do objeto Responsavel.
     *
     * @return Uma String formatada com os dados do responsável.
     */
    @Override
    public String toString() {
        return "Responsavel{id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dependentes=" + (dependentes != null ? dependentes.size() : 0) +
                '}';
    }
}