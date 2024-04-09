import java.util.Collection;

public interface Biblioteca {
    boolean cadastraFilme(String nome, int ano) throws FilmeJaExisteException;
    boolean remove(Filme filme) throws FilmeNaoExisteException;
    Collection<Filme> listaDeFilmes();
    Filme filmeAleatorio();
}

