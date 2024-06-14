package helpers;

import java.util.Comparator;

import domain.Entities.Funcionario;

public class ComparadorDeNome implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario f1, Funcionario f2) 
    { 
        return f1.getNome().compareTo(f2.getNome()); 
    } 

} 