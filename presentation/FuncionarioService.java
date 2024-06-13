package presentation;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import data.protocols.IFuncionarioRepository;
import domain.Entities.Funcionario;
import domain.useCases.CriarFuncionario;

public class FuncionarioService {
    Map<String, ArrayList<Funcionario>> funcionariosMap = new HashMap<String, ArrayList<Funcionario>>(); 
    
    private IFuncionarioRepository repositorioDeFuncionarios;
    
    public FuncionarioService(IFuncionarioRepository repositorioDeFuncionarios) {
        this.repositorioDeFuncionarios = repositorioDeFuncionarios;
    }

    public Funcionario criarFuncionario(String nome, int dia, int mes, int ano, String salario, String funcao){
        
        CriarFuncionario criarFuncionario = new CriarFuncionario(nome, LocalDate.of(dia, mes, ano), new BigDecimal(salario), funcao);
        criarFuncionario.run();

        return criarFuncionario.run();
    }
    public void criarFuncionarioEInserir(String nome, int dia, int mes, int ano, String salario, String funcao){
        
        CriarFuncionario criarFuncionario = new CriarFuncionario(nome, LocalDate.of(ano, mes, dia), new BigDecimal(salario), funcao);
        criarFuncionario.run();

        adicionarFuncionarios(criarFuncionario.run());
    }

    public void adicionarFuncionarios(Funcionario funcionario){
        repositorioDeFuncionarios.inserirFuncionario(funcionario);
    }
    public void removerFuncionarios(String nome){
        repositorioDeFuncionarios.removerFuncionario(nome);
    }
    public void mostrarFuncionarios(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.getDefault());
        DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(symbols);

        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            System.out.println(funcionario.getNome()+ " | "+  funcionario.getDataDeNascimento().format(formatter)+ 
            " | " + df.format(funcionario.getSalario()) + " | " +  funcionario.getFuncao()); 
        });
    }

    public void reajustarSalario(double porcentagem){
    
        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            double novoSalario = funcionario.getSalario().doubleValue() *  (1 + porcentagem);
            BigDecimal salarioAtualizado = BigDecimal.valueOf(novoSalario);
            funcionario.updateSalario(salarioAtualizado);
        });
    }

    public void agruparfuncionáriosPorFuncao(){
        funcionariosMap.put("Operador", new ArrayList<Funcionario>());
        funcionariosMap.put("Coordenador", new ArrayList<Funcionario>());
        funcionariosMap.put("Diretor", new ArrayList<Funcionario>());
        funcionariosMap.put("Recepcionista", new ArrayList<Funcionario>());
        funcionariosMap.put("Eletricista", new ArrayList<Funcionario>());
        funcionariosMap.put("Gerente", new ArrayList<Funcionario>());

        funcionariosMap.forEach((chave,lista) -> {
            repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
                if (funcionario.getFuncao() == chave.toString()) {
                    lista.add(funcionario);
                }
            });
        });
        
    }
    public void mostrarfuncionáriosPorFuncao(){
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.getDefault());
        DecimalFormatSymbols symbols = df.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(symbols);

        funcionariosMap.forEach((chave,lista) -> {
            repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
                System.out.println(funcionario.getNome()+ " | "+  funcionario.getDataDeNascimento().format(formatter)+ 
            " | " + df.format(funcionario.getSalario()) + " | " +  funcionario.getFuncao()); 
            });
        });
        
    }
    


}
