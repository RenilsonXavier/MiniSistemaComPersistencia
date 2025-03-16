package br.ufpb.dcx.Renilson.LojaFerramentas.controlador;


import br.ufpb.dcx.Renilson.LojaFerramentas.FerramentaInexistenteException;
import br.ufpb.dcx.Renilson.LojaFerramentas.FerramentaJaExisteException;
import br.ufpb.dcx.Renilson.LojaFerramentas.Ferramenta;
    import br.ufpb.dcx.Renilson.LojaFerramentas.SistemaLojaFerramentasPOO;

    import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class FerramentasSearchController implements ActionListener{
    private SistemaLojaFerramentasPOO sistema;
    private JFrame janelaPrincipal;
    private Collection <Ferramenta> ferramenta;

    public FerramentasSearchController(SistemaLojaFerramentasPOO sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o codígo a pesquisar? " );
        try {
            Ferramenta ferramenta = sistema.pesquisaFerramenta(codigo);
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Ferramenta encontrada:  \n  " + ferramenta.toString());
        } catch(FerramentaInexistenteException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage());
        }
    }
}
