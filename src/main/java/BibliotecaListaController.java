import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaListaController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;

    public BibliotecaListaController(Biblioteca biblioteca, JFrame janelaPrincipal){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(0 != biblioteca.listaDeFilmes().size()){
            DefaultListModel<Filme> listaPadrao = new DefaultListModel<>();
            for (Filme filme : biblioteca.listaDeFilmes()){
                listaPadrao.addElement(filme);
            }
            JList<Filme> lista = new JList<>(listaPadrao);
            JScrollPane listaFinal = new JScrollPane(lista);
            JOptionPane.showMessageDialog(janelaPrincipal, listaFinal,"Lista de Filmes",JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Lista de filmes está vazia");
        }
    }
}
