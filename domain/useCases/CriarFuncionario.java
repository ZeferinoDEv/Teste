package domain.useCases;

import java.math.BigDecimal;
import java.time.LocalDate;

import domain.Entities.Funcionario;

public class CriarFuncionario {
    private String nome;
    private LocalDate dataDeNascimento;
    private BigDecimal salario;
    private String funcao;
    
    public CriarFuncionario(String nome, LocalDate dataDeNascimento, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario run(){
       return new Funcionario(this.nome, this.dataDeNascimento , this.salario, this.funcao );
    }
}
