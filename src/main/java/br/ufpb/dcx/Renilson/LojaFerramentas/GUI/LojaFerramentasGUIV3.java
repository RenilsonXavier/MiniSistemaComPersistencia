package br.ufpb.dcx.Renilson.LojaFerramentas.GUI;

import javax.swing.*;
import java.awt.*;

import br.ufpb.dcx.Renilson.LojaFerramentas.SistemaLojaFerramentasPOO;
import br.ufpb.dcx.Renilson.LojaFerramentas.controlador.FerramentasAddController;
import br.ufpb.dcx.Renilson.LojaFerramentas.controlador.FerramentasRemoveController;
import br.ufpb.dcx.Renilson.LojaFerramentas.controlador.FerramentasSearchController;

public class LojaFerramentasGUIV3 extends JFrame{
    JLabel linha1, linha2;
    ImageIcon lojaImg = new ImageIcon("./imgs/loja.jpg");
    ImageIcon addImg = new ImageIcon("./imgs/icons/add_person.png");
    ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");
    ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;

    SistemaLojaFerramentasPOO sistemaLojaFerramentas = new SistemaLojaFerramentasPOO();

    public LojaFerramentasGUIV3(){
        setTitle("Loja de Ferramentas ");
        setSize(800,600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Minha Loja de Ferramentas", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif",Font.BOLD, 24));
        linha2 = new JLabel(lojaImg, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar",addImg);
        botaoAdicionar.addActionListener(new FerramentasAddController(sistemaLojaFerramentas, this));
        botaoPesquisar = new JButton("Pesquisar",pesqImg);
        botaoPesquisar.addActionListener(new FerramentasSearchController(sistemaLojaFerramentas, this));
        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new FerramentasRemoveController(sistemaLojaFerramentas, this));
    }
}
