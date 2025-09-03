package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade Professor.
 * Esta classe estende a classe Responsavel, já que um professor também pode ser um responsável.
 */
public class Professor extends Responsavel{
    private String formacao;
    private List<Turma> turmas;

    /**
     * Construtor da classe Professor.
     *
     * @param nome O nome do professor.
     * @param dataNascimento A data de nascimento do professor.
     * @param endereco O endereço do professor.
     * @param telefone O telefone do professor.
     * @param formacao A formação acadêmica do professor.
     */
    public Professor(String nome, String dataNascimento, Endereco endereco, String  telefone, String formacao){
        super(nome,dataNascimento,endereco,telefone);
        this.formacao = formacao;
        this.turmas= new ArrayList<>();
    }

    /** Retorna a formação do professor. */
    public String getFormacao() { return formacao; }
    /** Define a formação do professor. */
    public void setFormacao(String formacao) { this.formacao = formacao; }

    /**
     * Adiciona uma turma à lista de turmas que o professor leciona.
     *
     * @param turma A turma a ser adicionada.
     */
    public void addTurma(Turma turma){
        turmas.add(turma);
    }

    /** Retorna a lista de turmas que o professor leciona. */
    public List<Turma> getTurmas(){
        return turmas;
    }

    /**
     * Representação em String do objeto Professor.
     *
     * @return Uma String formatada com os dados do professor.
     */
    @Override
    public String toString() {
        return "Professor{id=" + id +
                ", nome='" + nome + '\'' +
                ", formacao='" + formacao + '\'' +
                ", turmas=" + (turmas != null ? turmas.size() : 0) +
                '}';
    }
}