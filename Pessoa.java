import java.time.LocalDate;

public class Pessoa {
    private String Nome;
    private LocalDate DataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento){
        this.Nome = nome;
        this.DataNascimento = dataNascimento;
    }

    //Getters
    public String getNome() {
        return this.Nome;
    }

    public LocalDate getDataNascimento() {
        return this.DataNascimento;
    }
}