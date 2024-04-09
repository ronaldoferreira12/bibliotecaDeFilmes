import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaAleatorioController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;
    public BibliotecaAleatorioController(Biblioteca biblioteca, JFrame janelaPrincipal){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(0 == biblioteca.listaDeFilmes().size()){
            JOptionPane.showMessageDialog(janelaPrincipal, "Não temos filmes cadastrados","AVISO",JOptionPane.WARNING_MESSAGE);
        }else {
             Filme filmeRandom = biblioteca.filmeAleatorio();
             JOptionPane.showMessageDialog(janelaPrincipal, filmeRandom);
        }

    }
}
