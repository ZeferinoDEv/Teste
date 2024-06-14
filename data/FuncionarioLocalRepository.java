package data;
import java.util.ArrayList;
import java.util.Collections;
import data.protocols.IFuncionarioRepository;
import domain.Entities.Funcionario;
import helpers.ComparadorDeNome;

public class FuncionarioLocalRepository implements IFuncionarioRepository  {
      private ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
     
      
     public void inserirFuncionario(Funcionario funcionario){
        listaFuncionarios.add(funcionario);
     }

     public void removerFuncionario(String nome){
      listaFuncionarios.removeIf(funcionario -> (funcionario.getNome() == nome));
     }
     public ArrayList<Funcionario> pegarTodos(){
      return listaFuncionarios;
     }

     public ArrayList<Funcionario> buscarFuncionadoPorMes(int[] dias){
      ArrayList<Funcionario> funcionariosPorMes = new ArrayList<Funcionario>();

         for (int i : dias) {
         listaFuncionarios.forEach((funcionario) -> { 
                if (funcionario.getDataDeNascimento().getMonth().getValue() == i ) {
                  funcionariosPorMes.add(funcionario);
                }
             });
        }
        return funcionariosPorMes;
     }

     public ArrayList<Funcionario> pegarTodosEmOrdemAlfabetica(){
      ArrayList<Funcionario> funcionariosPorMes = listaFuncionarios;
      Collections.sort(funcionariosPorMes, new ComparadorDeNome());
        return funcionariosPorMes;
     }
   
}
