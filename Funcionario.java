
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
        var simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", simbolos);

        return getNome() + " | " + getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | " + decimalFormat.format(getSalario()) + " | " + getFuncao();
    }
}
