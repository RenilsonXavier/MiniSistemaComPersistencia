package br.ufpb.dcx.Renilson.LojaFerramentas.GUI;

import javax.swing.*;

public class LojaFerramentasGUIV3_Com_Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                JFrame janela = new LojaFerramentasGUIV3();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
