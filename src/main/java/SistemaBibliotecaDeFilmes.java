import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

public class SistemaBibliotecaDeFilmes implements Biblioteca {
    private LinkedList<Filme> listaDeFilmes;
    private GravadorDeDados dados = new GravadorDeDados();
    public SistemaBibliotecaDeFilmes(){
        this.listaDeFilmes = new LinkedList<>();
        recuperaDados();
    }
    public void salvarDados(){
        try {
            this.dados.salvaListaDeFilmes(this.listaDeFilmes);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void recuperaDados(){
        try{
            this.listaDeFilmes = dados.recuperaListaDeFilmes();

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public boolean cadastraFilme(String nome, int ano) throws FilmeJaExisteException {
        Filme filmeCadastrar = new Filme(nome,ano);
        for(Filme e : listaDeFilmes){
            if(filmeCadastrar.equals(e)){
                throw new FilmeJaExisteException(filmeCadastrar + " já existe");
            }
        }
        listaDeFilmes.add(filmeCadastrar);
        return true;
    }

    @Override
    public boolean remove(Filme filme) throws FilmeNaoExisteException {
        for(Filme e : this.listaDeFilmes){
            if (e.equals(filme)) {
                this.listaDeFilmes.remove(filme);
                return true;
            }
        }
        throw new FilmeNaoExisteException("O filme: " + filme + " não existe");
    }

    @Override
    public Collection<Filme> listaDeFilmes() {
        if(listaDeFilmes != null){
            return listaDeFilmes;
        }
        return null;
    }
    @Override
    public Filme filmeAleatorio(){
        Random random = new Random();
        int aleatorio = random.nextInt(listaDeFilmes.size());
        return listaDeFilmes.get(aleatorio);
    }
}
