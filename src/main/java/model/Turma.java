package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a entidade Turma.
 * Armazena informações sobre uma turma, incluindo o professor regente e a lista de alunos.
 */
public class Turma {

    private static int proximoId = 1;

    private int id;
    private String serie;
    private Integer ano;
    private Professor professorRegente;
    private List<Aluno> alunos;

    /**
     * Construtor da classe Turma.
     *
     * @param serie A série da turma.
     * @param ano O ano letivo da turma.
     */
    public Turma(String serie, Integer ano) {
        this.id = proximoId++;
        this.serie = serie;
        this.ano = ano;
        this.alunos = new ArrayList<>();
    }

    /** Retorna o ID da turma. */
    public int getId() { return this.id; }

    /** Retorna a série da turma. */
    public String getSerie() { return serie; }
    /** Define a série da turma. */
    public void setSerie(String serie) { this.serie = serie; }

    /** Retorna o ano letivo da turma. */
    public Integer getAno() { return ano; }
    /** Define o ano letivo da turma. */
    public void setAno(Integer ano) { this.ano = ano; }

    /** Retorna o professor regente da turma. */
    public Professor getProfessorRegente() { return professorRegente; }
    /** Define o professor regente da turma. */
    public void setProfessorRegente(Professor professorRegente) { this.professorRegente = professorRegente; }

    /**
     * Adiciona um aluno à turma.
     *
     * @param aluno O aluno a ser adicionado.
     */
    public void addAluno(Aluno aluno){ alunos.add(aluno); }

    /**
     * Remove um aluno da turma.
     *
     * @param aluno O aluno a ser removido.
     */
    public void removeAluno(Aluno aluno){ alunos.remove(aluno); }

    /** Retorna a lista de alunos da turma. */
    public List<Aluno> getAlunos(){ return alunos; }

    /**
     * Representação em String do objeto Turma.
     *
     * @return Uma String formatada com os dados da turma.
     */
    @Override
    public String toString() {
        return "Turma{id=" + id +
                ", serie='" + serie + '\'' +
                ", ano=" + ano +
                ", professor=" + (professorRegente != null ? professorRegente.getNome() : "sem professor") +
                ", qtdAlunos=" + (alunos != null ? alunos.size() : 0) +
                '}';
    }
}