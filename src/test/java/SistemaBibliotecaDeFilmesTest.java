import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaBibliotecaDeFilmesTest {
    @Test
    public void testaCadastraFilme() throws FilmeJaExisteException {
        SistemaBibliotecaDeFilmes biblioteca = new SistemaBibliotecaDeFilmes();
        assertTrue(biblioteca.cadastraFilme("Titanic",1999));
        assertThrows(FilmeJaExisteException.class, () -> biblioteca.cadastraFilme("Titanic",1999));
    }
    @Test
    public void testaRemoveFilme() throws FilmeNaoExisteException, FilmeJaExisteException {
        SistemaBibliotecaDeFilmes biblioteca = new SistemaBibliotecaDeFilmes();
        assertTrue(biblioteca.cadastraFilme("Titanic",1999));
        Filme filmeRemove = new Filme("Titanic",1999);
        assertTrue(biblioteca.remove(filmeRemove));
        Filme filmeException = new Filme("Pokemon",2002);
        assertThrows(FilmeNaoExisteException.class, () -> biblioteca.remove(filmeException));
    }
    @Test
    public void testaListaDeFilme() throws FilmeJaExisteException {
        Filme filme = new Filme("pokemon",2002);
        Collection<Filme> esperado = new LinkedList<>();
        esperado.add(filme);

        SistemaBibliotecaDeFilmes biblioteca = new SistemaBibliotecaDeFilmes();
        biblioteca.cadastraFilme("pokemon",2002);
        Collection<Filme> resultado = biblioteca.listaDeFilmes();

        assertEquals(esperado, resultado);

    }

}
