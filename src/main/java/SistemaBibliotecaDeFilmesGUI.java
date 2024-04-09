import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SistemaBibliotecaDeFilmesGUI extends JFrame{

    JButton cadastraFilme, removeFilme, listaDeFilmes, filmeAleatorio;
    SistemaBibliotecaDeFilmes biblioteca = new SistemaBibliotecaDeFilmes();
    JLabel linhaLogo, linhaTexto;
    ImageIcon logo = new ImageIcon("./imagens/logoCinema.jpg");
    public SistemaBibliotecaDeFilmesGUI(){
        setTitle("Biblioteca de filme");
        setLocation(350,50);
        setSize(900,500);

        cadastraFilme = new JButton("Cadastra Filme");
        cadastraFilme.addActionListener(new BibliotecaCadastraController(biblioteca,this));
        add(cadastraFilme);

        removeFilme = new JButton("Remove Filme");
        removeFilme.addActionListener(new BibliotecaRemoveController(biblioteca, this));
        add(removeFilme);

        listaDeFilmes = new JButton("Lista de Filmes");
        listaDeFilmes.addActionListener(new BibliotecaListaController(biblioteca,this));
        add(listaDeFilmes);

        filmeAleatorio = new JButton("Filme Aleatório");
        filmeAleatorio.addActionListener(new BibliotecaAleatorioController(biblioteca,this));
        add(filmeAleatorio);

        Image newimg = logo.getImage().getScaledInstance(230, 230,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon logo = new ImageIcon(newimg);
        linhaLogo = new JLabel(logo);

        linhaTexto = new JLabel("Biblioteca de Filmes", JLabel.CENTER);
        linhaTexto.setForeground(Color.BLUE);
        linhaTexto.setFont(new Font("Texto",Font.ITALIC,20));



        getContentPane().setLayout(new GridLayout(2,4));
        getContentPane().add(new JLabel());
        getContentPane().add(linhaLogo);
        getContentPane().add(linhaTexto);
        getContentPane().add(new JLabel());
        getContentPane().add(cadastraFilme);
        getContentPane().add(removeFilme);
        getContentPane().add(listaDeFilmes);
        getContentPane().add(filmeAleatorio);
        addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e){
               biblioteca.salvarDados();
           }
        });
        pack();
        setResizable(false);
        setVisible(true);

    }
    public static void main(String[] args){
        SistemaBibliotecaDeFilmesGUI janela = new SistemaBibliotecaDeFilmesGUI();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
