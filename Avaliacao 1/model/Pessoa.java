package model;

// Classe que representa uma Pessoa com id, nome e email
public class Pessoa {
    private int id;
    private String nome;
    private String email;

    // Construtor vazio (obrigatório para JavaBeans e frameworks)
    public Pessoa() {
    }

    // Construtor sem ID (para novos cadastros)
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Construtor completo
    public Pessoa(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Representação da Pessoa como string (útil para debug ou exibição)
    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
