package presentation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
        System.out.println("\n");
        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            imprimirFuncionários(funcionario); 
        });
    }

    
    public void mostrarFuncionariosPorMesDeAniversario(int[] dias){
        System.out.println("\n");
        repositorioDeFuncionarios.buscarFuncionadoPorMes(dias).forEach((funcionario) -> { 
            imprimirFuncionários(funcionario); 
        });
    }
    public void mostrarFuncionariosMaisvelho(){
        System.out.println("\n");
       
        ArrayList<Funcionario> maisVelho =  new ArrayList<Funcionario>();
        maisVelho.add(repositorioDeFuncionarios.pegarTodos().getFirst());
        
        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            if (funcionario.getDataDeNascimento().isBefore(maisVelho.getFirst().getDataDeNascimento())) {
               maisVelho.clear();
               maisVelho.add(funcionario);
            }
        });

        System.out.println("Nome do funcionário mais velho: " + maisVelho.getFirst().getNome()+ 
            " | idade: "+ LocalDate.now().compareTo( maisVelho.getFirst().getDataDeNascimento())); 

    }

    public void reajustarSalario(double porcentagem){
    
        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            double novoSalario = funcionario.getSalario().doubleValue() + funcionario.getSalario().doubleValue() * porcentagem;
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
      
        System.out.println("\n");
        funcionariosMap.forEach((chave,lista) -> {
           lista.forEach((funcionario) -> { 
                imprimirFuncionários(funcionario); 
            });
        });
        
    }
    public void mostrarfuncionáriosPorOrdemAlfabetica(){
       
        System.out.println("\n");
        repositorioDeFuncionarios.pegarTodosEmOrdemAlfabetica().forEach((funcionario) -> { 
            imprimirFuncionários(funcionario); 
        });
    }
    public void somarFolhaSalarial(){
        
        System.out.println("\n");
        BigDecimal totalFolha = BigDecimal.ZERO;
        for (Funcionario funcionario : repositorioDeFuncionarios.pegarTodos()) {
            totalFolha = totalFolha.add(funcionario.getSalario());
        }
        
        System.out.println("Valor Total de Salários: "+ SalaryFormater.FormatarSalario(totalFolha)); 
    }

    public void calcularSalariosMin(){
        
        System.out.println("\n");
     
        repositorioDeFuncionarios.pegarTodos().forEach((funcionario) -> { 
            BigDecimal salariosMin = funcionario.getSalario().divide(new BigDecimal("1212.00"),2,RoundingMode.CEILING);
            System.out.println("O Funcionario: " + funcionario.getNome() + " recebe " + SalaryFormater.FormatarSalario(salariosMin) + " salários mínimos"); 
        });

    
    }
    

    private void imprimirFuncionários(Funcionario funcionario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        System.out.println(funcionario.getNome()+ " | "+  funcionario.getDataDeNascimento().format(formatter)+ 
        " | " + SalaryFormater.FormatarSalario(funcionario.getSalario()) + " | " +  funcionario.getFuncao());
    }
}
