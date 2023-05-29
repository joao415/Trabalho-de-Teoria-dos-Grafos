// João Marcelo Schneider da Silva e Souza
// Guilherme Soares

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ComponentesFortementeConexas {
    int qtdTestes = 1;

    int qtdVertices = 10;
    int qtdArestas = 15;

    String[] verticesString = new String[qtdVertices];
    int[] verticesInt = new int[qtdVertices];

    ArrayList<String[]> arestas = new ArrayList<>();
    int[] coloracao = new int[qtdVertices];

    Map<String, List<String>> grafo = new HashMap<>();
    Set<String> visitados = new HashSet<>();
    Stack<String> pilha = new Stack<>();

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

        ArrayList<ArrayList<String>> componentes = componentesFortementeConexas(arestas);
        System.out.println(componentes.toString());

        String resultado = "";

        for (ArrayList<String> componente: componentes) {
            resultado += "{ ";

            for (String vertice: componente) {
                resultado += vertice + " ";
                System.out.println(vertice);
            }

            resultado += "}\n";
        }

        System.out.println(resultado);

    }

    private ArrayList<ArrayList<String>> componentesFortementeConexas(ArrayList<String[]> arestas) {
        construirGrafo(arestas);

        for (String vertice: grafo.keySet()) {
            if (!visitados.contains(vertice)) {
                buscaEmProfundidade(vertice);
            }
        }

        ArrayList<ArrayList<String>> componentesFortementeConexas = new ArrayList<>();

        while (!pilha.isEmpty()) {
            String vertice = pilha.pop();

            if (!visitados.contains(vertice)) {
                ArrayList<String> componente = new ArrayList<>();
                grafo = grafoTransposto(grafo);
                dfsTransposta(grafo, vertice, componente);
                componentesFortementeConexas.add(componente);

            }
        }

        return componentesFortementeConexas;

    }

    private void construirGrafo(ArrayList<String[]> arestas) {
        String origem;
        String destino;
        
        for (String[] aresta: arestas) {
            origem = aresta[0];
            destino = aresta[1];

            grafo.putIfAbsent(origem, new ArrayList<>());
            grafo.get(origem).add(destino);

        }
    }

    private void buscaEmProfundidade(String vertice) {
        visitados.add(vertice);

        if (grafo.containsKey(vertice)) {
            for (String adjacente: grafo.get(vertice)) {
                if (!visitados.contains(adjacente)) {
                    buscaEmProfundidade(adjacente);
                }
            }
        }

        pilha.push(vertice);

    }

    private Map<String, List<String>> grafoTransposto(Map<String, List<String>> grafoTransposto) {

        for (String vertice: grafo.keySet()) {
            grafoTransposto.put(vertice, new ArrayList<>());
        }

        for (String origem: grafo.keySet()) {
            for (String destino: grafo.get(origem)) {
                grafoTransposto.get(origem).add(destino);
            }
        }

        return grafoTransposto;

    }

    private void dfsTransposta(
        Map<String, List<String>> grafo, String vertice, ArrayList<String> componente
    ) {
        visitados.add(vertice);
        componente.add(vertice);

        if (grafo.containsKey(vertice)) {
            for (String adjacente: grafo.get(vertice)) {
                if (!visitados.contains(adjacente)) {
                    dfsTransposta(grafo, adjacente, componente);
                }
            }
        }

    }
}
