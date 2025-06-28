package model;

// Classe que representa um Projeto no sistema
public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private int idFuncionario; // ID do funcionário responsável

    // Construtor vazio
    public Projeto() {
    }

    // Construtor completo
    public Projeto(int id, String nome, String descricao, int idFuncionario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idFuncionario = idFuncionario;
    }

    // Exibe os dados do projeto
    @Override
    public String toString() {
        return "Projeto {" +
                "id= " + id +
                ", nome='" + nome + '\'' +
                ", descricao ='" + descricao + '\'' +
                ", Id do Funcionario ='" + idFuncionario + '\'' +
                '}';
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
