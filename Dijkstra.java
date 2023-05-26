// João Marcelo Schneider da Silva e Souza

public class Dijkstra {
    int tamanho = 7;
    String[][] matriz = new String[7][7];

    String vertice1 = "F";
    String vertice2 = "A";

    int vertice1Int = letrasParaNumeros(vertice1);
    int vertice2Int = letrasParaNumeros(vertice2);

    int custo = Integer.MAX_VALUE;
    String retorno = "";

    String[][] matrizDeIncidencia = {
        {"0", "I", "I", "I", "I", "I", "I"}, 
        {"I", "0", "1", "I", "I", "I", "I"},
        {"4", "I", "0", "I", "I", "I", "I"},
        {"I", "3", "I", "0", "1", "I", "I"},
        {"I", "I", "2", "I", "0", "I", "I"},
        {"I", "I", "I", "3", "I", "0", "2"},
        {"I", "I", "I", "I", "5", "I", "0"}
    };

    int[][] grafo = converterParaInteiro(matrizDeIncidencia);

    public void dijkstra() {

        String caminho = "";
        int custo;

        for (int i = 0; i < tamanho; i++) {
            if (grafo[vertice1Int][i] > 0 && grafo[vertice1Int][i] < Integer.MAX_VALUE) {
                custo = 0;

                caminho = vertice1 + "->";
                custo += grafo[vertice1Int][i];

                dijkstra(i, caminho, custo);

            }
        }

        System.out.println("-----QUESTÃO 1-----");
        System.out.println(obterRetorno());

    }

    private void dijkstra(int vertice, String caminho, int custo) {
        int contador = 0;

        for (int i = 0; i < tamanho; i++) {

            if (grafo[vertice][i] > 0 && grafo[vertice][i] < Integer.MAX_VALUE) {

                if (contador < 1) {
                    caminho += numerosParaLetras(vertice) + "->";
                }
                
                custo += grafo[vertice][i];

                if (i == vertice2Int) {
                    if (custo < obterCusto()) {
                        gravarRetorno("Caminho: " + caminho + numerosParaLetras(i) + "\n" +
                        "Custo: " + custo);

                        gravarCusto(custo); 

                    }

                }

                dijkstra(i, caminho, custo);

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
        switch (vertice) {
            case "A":
            return 0;
            case "B":
            return 1;
            case "C":
            return 2;
            case "D":
            return 3;
            case "E":
            return 4;
            case "F":
            return 5;
            case "G":
            return 6;
            default:
            return 7;
        }
    }

    private String numerosParaLetras(int vertice) {
        switch (vertice) {
            case 0:
            return "A";
            case 1:
            return "B";
            case 2:
            return "C";
            case 3:
            return "D";
            case 4:
            return "E";
            case 5:
            return "F";
            case 6:
            return "G";
            default:
            return "Vértice inválido.";
        }
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