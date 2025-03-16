package br.ufpb.dcx.Renilson.LojaFerramentas;

import java.io.IOException;

    /*
    * Interface para as operações básicas de uma loja de ferramentas.
     */
public interface SistemaLojaFerramentas {

        void cadastraFerramenta(String nome, String codigo, int quantidade) throws FerramentaJaExisteException;
        Ferramenta pesquisaFerramenta(String codigo) throws FerramentaInexistenteException;
        void removeFerramenta(String codigo) throws FerramentaInexistenteException;
        void recuperaFerramentas() throws IOException, FerramentaJaExisteException;
        void salvarFerramentas() throws IOException;
}
