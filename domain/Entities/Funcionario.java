package domain.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funçao;
    public Funcionario(String nome, LocalDate dataDeNascimento ,BigDecimal salario, String funçao){
      super(nome, dataDeNascimento);
      this.salario = salario;
      this.funçao = funçao;
    }

    public String getNome(){
      return super.getNome();
    }

    public String getFuncao(){
      return this.funçao;
    }

    public LocalDate getDataDeNascimento(){
      return super.getDataDeNascimento();
    }
    public BigDecimal getSalario(){
      return this.salario;
    }

    public void updateSalario(BigDecimal novoSalario){
      this.salario = novoSalario;
    }
  
  }