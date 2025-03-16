package br.ufpb.dcx.Renilson.LojaFerramentas;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeFerramentas {

    private String arquivoFerramentas;

    public GravadorDeFerramentas() {
        this.arquivoFerramentas = "ferramentas.dat";
    }

    public Collection<Ferramenta> recuperaFerramentas() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoFerramentas))) {
            Collection<Ferramenta> ferramentasAchadas =  (ArrayList<Ferramenta>) in.readObject();
            return ferramentasAchadas;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IOException(e);
        }
    }

    public void gravaFerramentas(Collection<Ferramenta> ferramentas) throws IOException {
        ArrayList<Ferramenta> roupasArrayList = new ArrayList<>();
        roupasArrayList.addAll(ferramentas);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoFerramentas))){
            out.writeObject(roupasArrayList);
        }

    }


}
