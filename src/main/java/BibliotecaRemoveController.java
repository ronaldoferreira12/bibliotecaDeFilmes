import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaRemoveController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;
    public BibliotecaRemoveController(Biblioteca biblioteca, JFrame janelaPrincipal){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do filme: ");

        if (nome == null) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado.", "Cancelado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (nome.trim().isEmpty()){
            JOptionPane.showMessageDialog(janelaPrincipal,"O nome do filme não pode ser vazio","ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }

        String anoString = JOptionPane.showInputDialog(janelaPrincipal, "Digite o ano do filme?");

        if (anoString == null) {
            JOptionPane.showMessageDialog(janelaPrincipal, "Remoção cancelado.", "Cancelado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int ano = 0;
        try{
            ano = Integer.parseInt(anoString);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "O ano deve ser um número valido", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try{
            Filme removeFilme = new Filme(nome,ano);
            boolean remove = biblioteca.remove(removeFilme);
            JOptionPane.showMessageDialog(janelaPrincipal,"Filme foi removido com sucesso!");
        } catch (FilmeNaoExisteException ex){
            JOptionPane.showMessageDialog(janelaPrincipal,ex.getMessage(), "AVISO", JOptionPane.WARNING_MESSAGE);
        }
    }
}
