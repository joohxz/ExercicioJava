
import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal Salario;
    private String Funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.Salario = salario;
        this.Funcao = funcao;
    }

    //Getters
    public BigDecimal getSalario() {
        return this.Salario;
    }

    public String getFuncao() {
        return this.Funcao;
    }

    //Setters
    public void setSalario(BigDecimal salario) {
        this.Salario = salario;
    }

    public void setFuncao(String funcao) {
        this.Funcao = funcao;
    }

    @Override
    public String toString() {
        return getNome() + " | " + getDataNascimento() + " | " + getSalario() + " | " + getFuncao();
    }
}
