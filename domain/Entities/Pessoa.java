package domain.Entities;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    public Pessoa(String nome, LocalDate dataDeNascimento){
      this.nome = nome;
      this.dataDeNascimento = dataDeNascimento;
    }
    public String getNome(){
        return this.nome;
    }
    public LocalDate getDataDeNascimento(){
        return this.dataDeNascimento;
    }
  }