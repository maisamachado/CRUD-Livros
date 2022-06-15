package project.model;

public class Livro extends Produto{
    private Integer Id;
    private String nome;
    private Integer edicao;
    private Integer anoPublicacao;
    private String autor;

    public Livro(String nome, Integer edicao, Integer anoPublicacao, String autor, double valorProduto, Integer quantidade ){
        super(valorProduto, quantidade);

        this.Id = 0;
        this.nome = nome;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }


    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEdicao() {
        return edicao;
    }
    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

}







