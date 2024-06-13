package data.protocols;
import java.util.ArrayList;

import domain.Entities.Funcionario;

public interface IFuncionarioRepository {
    public void inserirFuncionario(Funcionario funcionario);
    public void removerFuncionario(String nome);
    public ArrayList<Funcionario>  pegarTodos();
     
 }
 