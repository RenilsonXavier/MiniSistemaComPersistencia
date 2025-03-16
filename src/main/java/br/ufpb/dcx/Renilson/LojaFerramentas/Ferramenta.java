package br.ufpb.dcx.Renilson.LojaFerramentas;

import java.io.Serializable;
import java.util.Objects;

public class Ferramenta implements Serializable {
    private String nome;
    private String codigo;
    private int quantidade;

    public Ferramenta(String nome, String codigo, int quantidade){
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Ferramenta{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferramenta that = (Ferramenta) o;
        return quantidade == that.quantidade && Objects.equals(codigo, that.codigo) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash( nome, codigo, quantidade);
    }

}
