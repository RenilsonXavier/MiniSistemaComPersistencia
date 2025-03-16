package br.ufpb.dcx.Renilson.LojaFerramentas.GUI;

import javax.swing.*;
import java.awt.*;

public class LojaFerramentasGUIV2 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon lojaImg = new ImageIcon("./imgs/loja.jpg");
    Image image = lojaImg.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(image);
    public LojaFerramentasGUIV2(){
        setTitle("Loja de Ferramentas de Renilson");
        setSize(700, 600); //tamanho da janela
        setLocation(0, 0);
        setResizable(true);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Minha Loja de Ferramentas!", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(resizedIcon, JLabel.CENTER);
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);

    }
    public static void main(String [] args){
        JFrame janela = new LojaFerramentasGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}