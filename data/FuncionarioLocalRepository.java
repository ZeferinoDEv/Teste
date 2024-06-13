package data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.protocols.IFuncionarioRepository;
import domain.Entities.Funcionario;

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
   
}
