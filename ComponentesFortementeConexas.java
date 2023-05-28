// João Marcelo Schneider da Silva e Souza
// Guilherme Soares

import java.util.ArrayList;

public class ComponentesFortementeConexas {
    int qtdTestes = 1;

    int qtdVertices = 10;
    int qtdArestas = 15;

    String[] verticesString = new String[qtdVertices];
    int[] verticesInt = new int[qtdVertices];

    ArrayList<String[]> arestas = new ArrayList<>();
    int[] coloracao = new int[qtdVertices];

    String[] aresta1 = {"A", "C"};
    String[] aresta2 = {"B", "A"};
    String[] aresta3 = {"C", "B"};
    String[] aresta4 = {"C", "F"};
    String[] aresta5 = {"D", "A"};
    String[] aresta6 = {"D", "C"};
    String[] aresta7 = {"E", "C"};
    String[] aresta8 = {"E", "D"};
    String[] aresta9 = {"F", "B"};
    String[] aresta10 = {"F", "G"};
    String[] aresta11 = {"F", "H"};
    String[] aresta12 = {"H", "G"};
    String[] aresta13 = {"H", "I"};
    String[] aresta14 = {"I", "J"};
    String[] aresta15 = {"J", "H"};

    public void componentesFortementeConexas() {
        
        for (int i = 0; i < qtdVertices; i++) {
            verticesInt[i] = i;
            coloracao[i] = 0;
        }

        arestas.add(aresta1);
        arestas.add(aresta2);
        arestas.add(aresta3);
        arestas.add(aresta4);
        arestas.add(aresta5);
        arestas.add(aresta6);
        arestas.add(aresta7);
        arestas.add(aresta8);
        arestas.add(aresta9);
        arestas.add(aresta10);
        arestas.add(aresta11);
        arestas.add(aresta12);
        arestas.add(aresta13);
        arestas.add(aresta14);
        arestas.add(aresta15);

        componentesFortementeConexas(verticesInt[0]);

    }

    private String componentesFortementeConexas(int vertice) {
        // TODO

        coloracao[vertice]++;

        for (int i = 0; i < arestas.size(); i++) {

        }

        return "foo";

    }

    private int letrasParaNumeros(String vertice) {
        char letra = Character.toUpperCase(vertice.charAt(0));
        return letra - 'A';
    }

    private String numerosParaLetras(int vertice) {
        char letra = (char) ('A' + vertice);
        return String.valueOf(letra);
    }
}
