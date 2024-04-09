import java.util.Collection;
import java.io.*;
import java.util.LinkedList;

public class GravadorDeDados {
    public static final String ARQUIVO_FILMES = "filmes.obj";
    public LinkedList<Filme> recuperaListaDeFilmes() throws IOException {
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_FILMES));
            return (LinkedList<Filme>) in.readObject();
        } catch (Exception e){
            throw new IOException("Não foi possível recuperar os dados do arquivo "+ARQUIVO_FILMES);
        }finally {
            if(in!=null){
                in.close();
            }
        }
    }
    public void salvaListaDeFilmes(LinkedList<Filme> listaDeFilmes) throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_FILMES));
            out.writeObject(listaDeFilmes);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Erro ao salvar os filmes no arquivo "+ ARQUIVO_FILMES);
        }
    }
}
