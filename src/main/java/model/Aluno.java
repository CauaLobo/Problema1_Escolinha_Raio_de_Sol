package model;

/**
 * Representa a entidade Aluno.
 * Esta classe estende a classe Pessoa e adiciona atributos específicos de um aluno,
 * como naturalidade e referências para seu responsável e turma.
 */
public class Aluno extends Pessoa {
    private String naturalidade;
    private Responsavel responsavel;
    private Turma turma;

    /**
     * Construtor da classe Aluno.
     *
     * @param nome O nome do aluno.
     * @param dataNascimento A data de nascimento do aluno.
     * @param endereco O endereço do aluno.
     * @param naturalidade A naturalidade do aluno.
     */
    public Aluno(String nome, String dataNascimento, Endereco endereco, String naturalidade) {
        super(nome, dataNascimento, endereco);
        this.naturalidade = naturalidade;
    }

    /**
     * Retorna a naturalidade do aluno.
     *
     * @return A naturalidade do aluno.
     */
    public String getNaturalidade () {
        return naturalidade;
    }

    /**
     * Define a naturalidade do aluno.
     *
     * @param naturalidade A nova naturalidade do aluno.
     */
    public void setNaturalidade(String naturalidade){
        this.naturalidade = naturalidade;
    }

    /**
     * Retorna o responsável do aluno.
     *
     * @return O objeto Responsavel do aluno.
     */
    public Responsavel getResponsavel(){
        return responsavel;
    }

    /**
     * Define o responsável do aluno.
     *
     * @param responsavel O objeto Responsavel a ser associado.
     */
    public void setResponsavel(Responsavel responsavel){
        this.responsavel = responsavel;
    }

    /**
     * Retorna a turma do aluno.
     *
     * @return O objeto Turma do aluno.
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * Define a turma do aluno.
     *
     * @param turma O objeto Turma a ser associado.
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * Representação em String do objeto Aluno, com informações detalhadas.
     *
     * @return Uma String formatada com os dados do aluno.
     */
    @Override
    public String toString() {
        return "Aluno{id=" + id +
                ", nome='" + nome + '\'' +
                ", nasc='" + dataNascimento + '\'' +
                ", naturalidade='" + naturalidade + '\'' +
                ", turma=" + (turma != null ? turma.getId() + " (" + turma.getSerie() + "-" + turma.getAno() + ")" : "sem turma") +
                ", responsavel=" + (responsavel != null ? responsavel.getNome() : "sem responsável") +
                '}';
    }
}