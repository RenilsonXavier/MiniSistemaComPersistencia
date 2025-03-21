package br.ufpb.dcx.Renilson.LojaFerramentas;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProgramaGravacao {
    public static void main(String [] args){

        Ferramenta f1 = new Ferramenta("Motosserra", "666" , 12);
        Ferramenta f2 = new Ferramenta("Furadeira" , "222", 21);

        List<Ferramenta> ferramentas = new LinkedList<>();
        ferramentas.add(f1);
        ferramentas.add(f2);

        GravadorDeFerramentas gravadorDeFerramentas = new GravadorDeFerramentas();
        try {
            gravadorDeFerramentas.gravaFerramentas(ferramentas);
            System.out.println("Ferramentas salvas com sucesso. ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Recuperando ferramentas...");
        try {
            Collection<Ferramenta> ferramentasAchadas = gravadorDeFerramentas.recuperaFerramentas();
            System.out.println("Ferramentas achadas:");
            for (Ferramenta f: ferramentasAchadas){
                System.out.println(f.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
