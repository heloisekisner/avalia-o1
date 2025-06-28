package model;

// Classe Funcionario que está associada a uma Pessoa pelo ID
public class Funcionario {
    private int id;               // ID da pessoa (chave estrangeira)
    private String matricula;     // Matrícula do funcionário
    private String departamento;  // Departamento onde trabalha

    public Funcionario() {
    }

    // Construtor completo
    public Funcionario(int id, String matricula, String departamento) {
        this.id = id;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    // Impressão formatada do funcionário
    @Override
    public String toString() {
        return "Funcionario {" +
                "id=" + id +
                ", matricula ='" + matricula + '\'' +
                ", departamento ='" + departamento + '\'' +
                '}';
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
