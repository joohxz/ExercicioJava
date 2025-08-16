import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args){

        //Date format utilizado
        var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Declaração de lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
            new Funcionario("Maria", LocalDate.parse("18/10/2000", dateFormat), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", LocalDate.parse("12/05/1990", dateFormat), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", LocalDate.parse("02/05/1961", dateFormat), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", LocalDate.parse("14/10/1988", dateFormat), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", LocalDate.parse("05/01/1995", dateFormat), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", LocalDate.parse("19/11/1999", dateFormat), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", LocalDate.parse("31/03/1993", dateFormat), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", LocalDate.parse("08/07/1994", dateFormat), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", LocalDate.parse("24/05/2003", dateFormat), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", LocalDate.parse("02/09/1996", dateFormat), new BigDecimal("2799.93"), "Gerente")
        ));

        //Remove funcionário com nome João
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //Setta formatação de números decimais
        var simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", simbolos);

        //Print de todos os funcionários
        int indice = 1;
        for (var funcionario : funcionarios) {
            String stringSalario = decimalFormat.format(funcionario.getSalario());

            System.out.println("Funcionário " + indice + 
                                "\nNome: " + funcionario.getNome() + 
                                " | Data de Nascimento: " + funcionario.getDataNascimento().format(dateFormat) + 
                                " | Salário: " + stringSalario + 
                                " | Função: " + funcionario.getFuncao());
            System.out.println("-------------------------------");
            indice++;
        }

        //Aumenta salários em 10%
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal(1.10))));

        //Group by da lista de funcionários por função
        Map<String, List<Funcionario>> funcionariosAgrupadosFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //Print funcionários por função
        funcionariosAgrupadosFuncao.forEach((funcao, funcionariosAgrupados) -> {
            System.out.println("Função: " + funcao);
            System.out.println("Funcionários: " + funcionariosAgrupados);
        });

        //Filtro funcionários que nasceram nos meses 10 e 12
        var funcionariosFiltradosOutubroDezembro = funcionarios.stream().filter(funcionario -> {
            int mes = funcionario.getDataNascimento().getMonthValue();
            return mes == 10 || mes == 12;
        }).collect(Collectors.toList());

        funcionariosFiltradosOutubroDezembro.forEach(funcionario -> {
            String stringSalario = decimalFormat.format(funcionario.getSalario());

            System.out.println( "\nNome: " + funcionario.getNome() + 
                                " | Data de Nascimento: " + funcionario.getDataNascimento().format(dateFormat) + 
                                " | Salário: " + stringSalario + 
                                " | Função: " + funcionario.getFuncao());
            System.out.println("-------------------------------");
        });
    }
}
