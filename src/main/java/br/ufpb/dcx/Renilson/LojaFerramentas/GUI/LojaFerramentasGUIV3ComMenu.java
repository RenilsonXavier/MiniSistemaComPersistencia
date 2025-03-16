package br.ufpb.dcx.Renilson.LojaFerramentas.GUI;

import br.ufpb.dcx.Renilson.LojaFerramentas.FerramentaJaExisteException;
import br.ufpb.dcx.Renilson.LojaFerramentas.SistemaLojaFerramentasPOO;
import br.ufpb.dcx.Renilson.LojaFerramentas.controlador.FerramentasRemoveController;
import br.ufpb.dcx.Renilson.LojaFerramentas.controlador.FerramentasSearchController;

import javax.swing.*;
import java.awt.*;

public class LojaFerramentasGUIV3ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon lojaImg = new ImageIcon("./imgs/loja.jpg");
    SistemaLojaFerramentasPOO sistemaLojaFerramentasPOO = new SistemaLojaFerramentasPOO();
    JMenuBar barraDeMenu = new JMenuBar();

    public LojaFerramentasGUIV3ComMenu(){
        setTitle("Loja de Ferramentas");
        setSize(800, 600); // tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        linha1 = new JLabel("Minha Loja de Ferramentas", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(lojaImg, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarFerramenta = new JMenuItem("Cadastrar ferramenta");
        menuCadastrar.add(menuCadastrarFerramenta);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarFerramenta = new JMenuItem("Pesquisar Ferramenta");
        menuPesquisar.add(menuPesquisarFerramenta);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverFerramenta = new JMenuItem("Remover Ferramenta");
        menuRemover.add(menuRemoverFerramenta);
        menuPesquisarFerramenta.addActionListener(new FerramentasSearchController(sistemaLojaFerramentasPOO, this));
        menuRemoverFerramenta.addActionListener(new FerramentasRemoveController(sistemaLojaFerramentasPOO, this));
        menuCadastrarFerramenta.addActionListener(
                (ae) -> {
                    String nome = JOptionPane.showInputDialog(this, "Qual o nome da Ferramenta?");
                    String codigo = JOptionPane.showInputDialog(this, "Qual o codígo da Ferramenta?");
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Qual a quantidade?"));
                    try {
                        sistemaLojaFerramentasPOO.cadastraFerramenta(nome, codigo, quantidade);
                        JOptionPane.showMessageDialog(this, "Ferramenta Cadastrada de código" + codigo);
                    }catch(FerramentaJaExisteException ex){
                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                });
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }

    //...
    public static void main(String[] args) {
        JFrame janela = new LojaFerramentasGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
