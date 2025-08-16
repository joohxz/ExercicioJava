import java.time.LocalDate;

public class Pessoa {
    private String Nome;
    private LocalDate DataNascimento;

    //Getters
    public String getNome() {
        return this.Nome;
    }

    public LocalDate getDataNascimento() {
        return this.DataNascimento;
    }

    //Setters
    public void setNome(String nome) {
        this.Nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.DataNascimento = dataNascimento;
    }
}