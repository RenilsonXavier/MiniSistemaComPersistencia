package br.ufpb.dcx.Renilson.LojaFerramentas.controlador;

import br.ufpb.dcx.Renilson.LojaFerramentas.FerramentaJaExisteException;
import br.ufpb.dcx.Renilson.LojaFerramentas.SistemaLojaFerramentasPOO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerramentasAddController implements ActionListener{
        private SistemaLojaFerramentasPOO sistema;
        private JFrame janelaPrincipal;

        public FerramentasAddController(SistemaLojaFerramentasPOO sistema, JFrame janela) {
            this.sistema = sistema;
            this.janelaPrincipal = janela;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = JOptionPane.showInputDialog(janelaPrincipal,
                    "Qual o nome da Ferramenta?");
            String codigo = JOptionPane.showInputDialog(janelaPrincipal,
                    "Qual é o codígo dessa ferramenta? ");
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                    "Qual a quantidade de ferramentas? "));
            try {
                sistema.cadastraFerramenta(nome, codigo, quantidade);
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Ferramenta cadastrada!");

            } catch(FerramentaJaExisteException ex)  {
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Ferramenta não foi cadastrada. " +
                                "Verifique se já não existia!");
            }
        }
}

