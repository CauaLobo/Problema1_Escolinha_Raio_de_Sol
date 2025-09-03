package model;

/**
 * Superclasse que representa a entidade Pessoa.
 * Contém atributos e métodos comuns a Aluno, Professor e Responsavel.
 */
public class Pessoa {

    private static int proximoId = 1;

    protected int id;
    protected String nome;
    protected String dataNascimento;
    protected Endereco endereco;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome O nome da pessoa.
     * @param dataNascimento A data de nascimento da pessoa.
     * @param endereco O endereço da pessoa.
     */
    public Pessoa(String nome, String dataNascimento, Endereco endereco) {
        this.id = proximoId++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    /** Retorna o ID da pessoa. */
    public int getId() { return id; }

    /** Retorna o nome da pessoa. */
    public String getNome() { return nome; }
    /** Define o nome da pessoa. */
    public void setNome(String nome) { this.nome = nome; }

    /** Retorna a data de nascimento da pessoa. */
    public String getDataNascimento() { return dataNascimento; }
    /** Define a data de nascimento da pessoa. */
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    /** Retorna o endereço da pessoa. */
    public Endereco getEndereco() { return endereco; }
    /** Define o endereço da pessoa. */
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    /**
     * Representação em String do objeto Pessoa.
     *
     * @return Uma String formatada com o nome e o ID da pessoa.
     */
    @Override
    public String toString() {
        return nome + " (id=" + id + ")";
    }
}