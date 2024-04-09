import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaCadastraController implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame janelaPrincipal;

    public BibliotecaCadastraController(Biblioteca biblioteca, JFrame janelaPrincipal){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do filme?");

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
            JOptionPane.showMessageDialog(janelaPrincipal, "Cadastro cancelado.", "Cancelado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int ano = 0;
        try{
            ano = Integer.parseInt(anoString);
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "O ano deve ser um número valido", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(ano < 1800 || ano > java.time.Year.now().getValue()){
            JOptionPane.showMessageDialog(janelaPrincipal, "Digite um ano válido", "ERRO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            boolean cadastrou = biblioteca.cadastraFilme(nome,ano);
            JOptionPane.showMessageDialog(janelaPrincipal,"Filme foi cadastrado com sucesso!");
        } catch (FilmeJaExisteException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
