import java.io.Serializable;
import java.util.Objects;

public class Filme implements Serializable {
    private String nome;
    private int ano;

    public Filme(String nome,int ano){
        this.nome = nome;
        this.ano = ano;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getAno(){
        return this.ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return ano == filme.ano && nome.equals(filme.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ano);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " e Ano: " + ano;
    }
}
