package model;

public class Funcionario {
    private int id;
    private String matricula;
    private String departamento;

    public Funcionario() {
    }

    public Funcionario(int id, String matricula, String departamento) {
        this.id = id;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario {" +
                "id=" + id +
                ", matricula ='" + matricula + '\'' +
                ", departamento ='" + departamento + '\'' +
                '}';
    }

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
