package br.ufpb.dcx.Renilson.LojaFerramentas.controlador;

import br.ufpb.dcx.Renilson.LojaFerramentas.FerramentaInexistenteException;
import br.ufpb.dcx.Renilson.LojaFerramentas.SistemaLojaFerramentasPOO;

import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FerramentasRemoveController implements ActionListener {
    private SistemaLojaFerramentasPOO sistema;
    private JFrame janelaPrincipal;

    public FerramentasRemoveController(SistemaLojaFerramentasPOO sistema, JFrame janela) {
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o codígo da Ferramenta a remover?");
        try {
            sistema.removeFerramenta(nome);
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Ferramenta removida com sucesso.");
        } catch (FerramentaInexistenteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Ferramenta não foi encontrado. "+
                            "Operação não realizada!");
        }
    }
}
