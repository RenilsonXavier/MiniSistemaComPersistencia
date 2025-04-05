package br.ufpb.dcx.Renilson.LojaFerramentas;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaLojaFerramentasPOO implements SistemaLojaFerramentas{
    private GravadorDeFerramentas gravadorDeFerramentas;
    private Map <String, Ferramenta> ferramentaMap;

    public SistemaLojaFerramentasPOO(){
        this.ferramentaMap = new HashMap<>();
        this.gravadorDeFerramentas = new GravadorDeFerramentas();
    }

    @Override
    public void cadastraFerramenta(String nome, String codigo, int quantidade) throws FerramentaJaExisteException {
        if (this.ferramentaMap.containsKey(codigo)) {
            throw new FerramentaJaExisteException("Ferramenta já cadastrada: " + codigo);
        } else {
            Ferramenta f = new Ferramenta(nome, codigo, quantidade);
            this.ferramentaMap.put(codigo, f);
        }
    }

    @Override
    public Ferramenta pesquisaFerramenta(String codigo) throws FerramentaInexistenteException {
        return ferramentaMap.values().stream()
                .filter(ferramenta -> ferramenta.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new FerramentaInexistenteException("Não existe ferramenta com este código: " + codigo));

    }
//        if (this.ferramentaMap.containsKey(codigo)) {
//            return this.ferramentaMap.get(codigo);
//        } else {
//            throw new FerramentaInexistenteException("Não existe ferramenta com esté código: " + codigo);
//        }


    public void removeFerramenta(String codigo) throws FerramentaInexistenteException {
        if (this.ferramentaMap.containsKey(codigo)){
            this.ferramentaMap.remove(codigo);
        } else {
            throw new FerramentaInexistenteException("Não existe contato com o codígo: " + codigo);
        }
    }

    public void recuperaFerramentas() throws IOException, FerramentaJaExisteException{
        Collection<Ferramenta> ferramentasAchadas = this.gravadorDeFerramentas.recuperaFerramentas();
        for (Ferramenta f: ferramentasAchadas){
            this.cadastraFerramenta(f.getCodigo(), f.getNome(), f.getQuantidade());
        }
    }

    public void salvarFerramentas() throws IOException{
        this.gravadorDeFerramentas.gravaFerramentas(this.ferramentaMap.values());
    }


}
