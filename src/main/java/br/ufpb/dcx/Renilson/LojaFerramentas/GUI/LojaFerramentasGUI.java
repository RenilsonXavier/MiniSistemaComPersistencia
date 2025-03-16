package br.ufpb.dcx.Renilson.LojaFerramentas.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LojaFerramentasGUI extends JFrame {
    public LojaFerramentasGUI(){
        setTitle("Loja de Ferramentas de Renilson");
        setSize(600,600);
        setLocation(0,0);
        // localização da janela na tela
        setResizable(false);
        // janela não redimensionável
        getContentPane().setBackground(Color.lightGray);
    }
    //...
    public static void main(String [] args){
        LojaFerramentasGUI janela = new LojaFerramentasGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}
