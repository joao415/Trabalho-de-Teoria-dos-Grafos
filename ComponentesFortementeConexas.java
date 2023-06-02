// João Marcelo Schneider da Silva e Souza
// Guilherme Soares

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComponentesFortementeConexas {
    int qtdTestes = 1;

    int qtdVertices = 10;
    int qtdArestas = 15;

    String[] aresta1 = { "A", "C" };
    String[] aresta2 = { "B", "A" };
    String[] aresta3 = { "C", "B" };
    String[] aresta4 = { "C", "F" };
    String[] aresta5 = { "D", "A" };
    String[] aresta6 = { "D", "C" };
    String[] aresta7 = { "E", "C" };
    String[] aresta8 = { "E", "D" };
    String[] aresta9 = { "F", "B" };
    String[] aresta10 = { "F", "G" };
    String[] aresta11 = { "F", "H" };
    String[] aresta12 = { "H", "G" };
    String[] aresta13 = { "H", "I" };
    String[] aresta14 = { "I", "J" };
    String[] aresta15 = { "J", "H" };

    Map<String, List<String>> grafo; 
    Map<String, Integer> fechamento; 
    Map<String, List<String>> transposto;

    Set<String> visitados = new HashSet<>();
    Set<String> visitadosTransposto = new HashSet<>();
    List<Integer> tempos;

    int tempo;
    int tempoTransposto;
    int acrescimo = 0;

    public void componentesFortementeConexas() {

        ArrayList<String[]> arestas = new ArrayList<>();

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

        grafo = construirGrafo(arestas);
        fechamento = dfs(grafo);
        transposto = transporGrafo(grafo);

        System.out.println(transposto.toString());

        List<List<String>> cfc = encontrarCfc(transposto);

    }


    private List<List<String>> encontrarCfc(Map<String, List<String>> grafo) {
        List<List<String>> componentes = new ArrayList<>();
        List<String> cfc = new ArrayList<>();
        Set<String> visitados = new HashSet<>();

        Map<String, Integer> achamento = dfsTransposto(grafo);

        int tempo = 0;

        for (String vertice: grafo.keySet()) {
            if (!visitados.contains(vertice)) {
                cfc.add(vertice);
                visitados.add(vertice);

                for (String f: fechamento.keySet()) {
                    if (f.equals(vertice)) {
                        tempo = fechamento.get(f);
                    }

                    for (String vizinho : grafo.get(vertice)) { 
                        if (fechamento.get(vizinho) == (tempo - 1) && !visitados.contains(vizinho)) {
                            cfc.add(vizinho);
                            visitados.add(vizinho);
                            tempo--;
                        }
        
                    }

                }

                componentes.add(cfc);
                cfc.clear();
                tempo = 0;

            }
            
        }

        return componentes;

    }

    public Map<String, List<String>> transporGrafo(Map<String, List<String>> grafo) {
        Map<String, List<String>> transposto = new HashMap<>();

        for (String vertice: grafo.keySet()) {
            transposto.put(vertice, new ArrayList<>());
        }

        for (String vertice: grafo.keySet()) {

            for (String vizinho : grafo.get(vertice)) {
                transposto.get(vizinho).add(vertice);

            }
        }

        return transposto;

    }


    private Map<String, List<String>> construirGrafo(ArrayList<String[]> arestas) {
        Map<String, List<String>> grafo = new HashMap<>();

        for (String[] aresta : arestas) {
            String origem = aresta[0];
            String destino = aresta[1];

            if (!grafo.containsKey(origem)) {
                grafo.put(origem, new ArrayList<>());
            }
            if (!grafo.containsKey(destino)) {
                grafo.put(destino, new ArrayList<>());
            }

            grafo.get(origem).add(destino);

        }

        return grafo;

    }

    private Map<String, Integer> dfs(Map<String, List<String>> grafo) {
        tempo = 0;
        Map<String, Integer> fechamento = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        for (String vertice: grafo.keySet()) {
            if (!visitados.contains(vertice)) {
                visitar(grafo, vertice, visitados, fechamento);
            }
        }

        return fechamento;

    }

    private void visitar(
        Map<String, List<String>> grafo,
        String vertice,
        Set<String> visitado,
        Map<String, Integer> fechamento
    ) {
        visitados.add(vertice);
        tempo++;

        for (String vizinho: grafo.get(vertice)) {
            if (!visitados.contains(vizinho)) {
                visitar(grafo, vizinho, visitados, fechamento);
            }
        }

        tempo++;
        fechamento.put(vertice, tempo);

    }

    private Map<String, Integer> dfsTransposto(Map<String, List<String>> transposto) {
        tempoTransposto = 0;
        Map<String, Integer> achamento = new HashMap<>();
        
        tempos = new ArrayList<>(fechamento.values());
        Collections.sort(tempos, Collections.reverseOrder());

        for (int i = 0; i < tempos.size(); i++) {
            for (String vertice: fechamento.keySet()) {
                if (!visitadosTransposto.contains(vertice) && fechamento.get(vertice) == tempos.get(i)) {
                    visitarTransposto(transposto, vertice, achamento);
                    tempoTransposto += acrescimo;
                }
            }

        }
        

        System.out.println(achamento.toString()); 
            
        return achamento;

    }

    private void visitarTransposto(
        Map<String, List<String>> transposto,
        String vertice,
        Map<String, Integer> achamento
    ) {
        visitadosTransposto.add(vertice);
        tempoTransposto++;
        achamento.put(vertice, tempoTransposto);
       

        for (int i = 0; i < tempos.size(); i++) {
            for (String vizinho: fechamento.keySet()) {
                if (!visitadosTransposto.contains(vizinho) && fechamento.get(vizinho) == tempos.get(i)) {
                    visitarTransposto(transposto, vizinho, achamento);
                    tempoTransposto += acrescimo;
                }
            }

        }
        
        acrescimo++;

    }

}
