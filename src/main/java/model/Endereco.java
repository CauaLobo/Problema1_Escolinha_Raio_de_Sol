package model;

/**
 * Representa a entidade Endereco.
 * Utilizada para armazenar e organizar informações de endereço.
 */
public class Endereco {
    private String rua;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    /**
     * Construtor da classe Endereco.
     *
     * @param rua A rua do endereço.
     * @param bairro O bairro do endereço.
     * @param cep O CEP do endereço.
     * @param cidade A cidade do endereço.
     * @param estado O estado do endereço.
     */
    public Endereco(String rua, String bairro, String cep, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    /** Retorna a rua do endereço. */
    public String getRua() { return rua; }
    /** Define a rua do endereço. */
    public void setRua(String rua) { this.rua = rua; }

    /** Retorna o bairro do endereço. */
    public String getBairro() { return bairro; }
    /** Define o bairro do endereço. */
    public void setBairro(String bairro) { this.bairro = bairro; }

    /** Retorna o CEP do endereço. */
    public String getCep() { return cep; }
    /** Define o CEP do endereço. */
    public void setCep(String cep) { this.cep = cep; }

    /** Retorna a cidade do endereço. */
    public String getCidade() { return cidade; }
    /** Define a cidade do endereço. */
    public void setCidade(String cidade) { this.cidade = cidade; }

    /** Retorna o estado do endereço. */
    public String getEstado() { return estado; }
    /** Define o estado do endereço. */
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Representação em String do objeto Endereco.
     *
     * @return Uma String formatada com os dados do endereço.
     */
    @Override
    public String toString() {
        return rua + ", " + bairro + ", " + cidade + " - " + estado + " (" + cep + ")";
    }
}