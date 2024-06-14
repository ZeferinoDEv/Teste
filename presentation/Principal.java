package presentation;


import data.FuncionarioLocalRepository;

public class Principal {

    public static void main(String[] args) {
      FuncionarioLocalRepository repositorioDeFuncionarios = new FuncionarioLocalRepository();
      FuncionarioService funcionarioService = new FuncionarioService(repositorioDeFuncionarios);
      //Inserir todos os funcionários, na mesma ordem e informações da tabela acima
      funcionarioService.criarFuncionarioEInserir("Maria", 18,10,2000,"2009.44", "Operador");
      funcionarioService.criarFuncionarioEInserir("João", 12,5,1990,"2284.38", "Operador");
      funcionarioService.criarFuncionarioEInserir("Caio", 2,5,1961,"9836.14", "Coordenador");
      funcionarioService.criarFuncionarioEInserir("Miguel", 14,10,1988,"19119.88", "Diretor");
      funcionarioService.criarFuncionarioEInserir("Alice", 5,1,1995,"2234.68", "Recepcionista");
      funcionarioService.criarFuncionarioEInserir("Heitor", 19,11,1999,"1582.72", "Operador");
      funcionarioService.criarFuncionarioEInserir("Arthur", 31,3,1993,"4071.84", "Contador");
      funcionarioService.criarFuncionarioEInserir("Laura", 8,7,1994,"3017.45", "Gerente");
      funcionarioService.criarFuncionarioEInserir("Heloísa", 24,5,2003,"1606.85", "Eletricista");
      funcionarioService.criarFuncionarioEInserir("Helena", 2,9,1996,"2799.93", "Gerente");
      //Remover o funcionário “João” da lista.
      funcionarioService.removerFuncionarios("João");
      //Imprimir todos os funcionários com todas suas informações
      funcionarioService.mostrarFuncionarios();
      // funcionários receberam 10% de aumento de salário
      funcionarioService.reajustarSalario(0.10);
      //agrupar funcioraios por funcao
      funcionarioService.agruparfuncionáriosPorFuncao();
      //Imprimir todos os funcionários adrupados por funcao com todas suas informações
      funcionarioService.mostrarfuncionáriosPorFuncao();
      //Imprimir os funcionários que fazem aniversário no mês 10 e 12.
      int[] datasFiltro = {10,12};
      funcionarioService.mostrarFuncionariosPorMesDeAniversario(datasFiltro);
      //Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
      funcionarioService.mostrarFuncionariosMaisvelho();
      //Imprimir a lista de funcionários por ordem alfabética.
      funcionarioService.mostrarfuncionáriosPorOrdemAlfabetica();
      // Imprimir o total dos salários dos funcionários
      funcionarioService.somarFolhaSalarial();
      //Imprimir quantos salários mínimos ganha cada funcionário
      funcionarioService.calcularSalariosMin();
  }
}