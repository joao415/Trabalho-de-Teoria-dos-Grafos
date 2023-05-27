// João Marcelo Schneider da Silva e Souza

/**
 * Este arquivo contém uma solução alternativa para a questão 1, 
 * que eu implementei por curiosidade apenas.
 */

public class AlternativaAoDijkstra {
    int tamanho = 7;
    String[][] matriz = new String[7][7];

    String vertice1 = "F";
    String vertice2 = "A";

    int vertice1Int = letrasParaNumeros(vertice1);
    int vertice2Int = letrasParaNumeros(vertice2);

    int custo = Integer.MAX_VALUE;
    String retorno = "";

    String[][] matrizDeCusto = {
        {"0", "I", "I", "I", "I", "I", "I"}, 
        {"I", "0", "1", "I", "I", "I", "I"},
        {"4", "I", "0", "I", "I", "I", "I"},
        {"I", "3", "I", "0", "1", "I", "I"},
        {"I", "I", "2", "I", "0", "I", "I"},
        {"I", "I", "I", "3", "I", "0", "2"},
        {"I", "I", "I", "I", "5", "I", "0"}
    };

    int[][] grafo = converterParaInteiro(matrizDeCusto);

    public void alternativaAoDijkstra() {

        String caminho = "";
        int custo;

        for (int i = 0; i < tamanho; i++) {
            if (grafo[vertice1Int][i] > 0 && grafo[vertice1Int][i] < Integer.MAX_VALUE) {
                custo = 0;

                caminho = vertice1 + "->";
                custo += grafo[vertice1Int][i];

                alternativaAoDijkstra(i, caminho, custo);

            }
        }

        System.out.println("-----QUESTÃO 1-----");
        System.out.println(obterRetorno());

    }

    private void alternativaAoDijkstra(int vertice, String caminho, int custo) {
        int contador = 0;

        for (int i = 0; i < tamanho; i++) {

            if (grafo[vertice][i] > 0 && grafo[vertice][i] < Integer.MAX_VALUE) {

                if (contador < 1) {
                    caminho += numerosParaLetras(vertice + 1) + "->";
                }
                
                custo += grafo[vertice][i];

                if (i == vertice2Int) {
                    if (custo < obterCusto()) {
                        gravarRetorno("Caminho: " + caminho + numerosParaLetras(i + 1) + "\n" +
                        "Custo: " + custo);

                        gravarCusto(custo); 

                    }

                }

                alternativaAoDijkstra(i, caminho, custo);

                custo -= grafo[vertice][i];

                contador++;
            
            }
            
        }
        
    }

    private int[][] converterParaInteiro(String[][] matriz) {
        int[][] retorno = new int[matriz.length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j].equals("I")) {
                    retorno[i][j] = Integer.MAX_VALUE;
                }
                else {
                    retorno[i][j] = Integer.parseInt(matriz[i][j]);
                }
            }
        }

        return retorno;

    }

    private int letrasParaNumeros(String vertice) {
        char letra = Character.toUpperCase(vertice.charAt(0));
        return letra - 'A';
    }

    private String numerosParaLetras(int vertice) {
        char letra = (char) ('A' + vertice - 1);
        return String.valueOf(letra);
    }

    private void gravarCusto(int custo) {
        this.custo = custo;
    }

    private int obterCusto() {
        return custo;
    }

    private void gravarRetorno(String retorno) {
        this.retorno = retorno;
    }

    private String obterRetorno() {
        return retorno;
    }

}
