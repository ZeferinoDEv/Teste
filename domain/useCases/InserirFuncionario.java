package domain.useCases;

import data.protocols.IFuncionarioRepository;
import domain.Entities.Funcionario;
 
public class InserirFuncionario {
    private IFuncionarioRepository repositorioDeFuncionarios;
 
    public InserirFuncionario(IFuncionarioRepository repositorioDeFuncionarios) {
        this.repositorioDeFuncionarios = repositorioDeFuncionarios;
    }
    
    public void run (Funcionario funcionario){
        repositorioDeFuncionarios.inserirFuncionario(funcionario);
    }
}
