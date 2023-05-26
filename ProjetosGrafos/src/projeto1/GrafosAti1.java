package projeto1;

/* Aluno Guilherme Soares
	Professor n�o consegui fazer uma interface pra ficar bonito, por falta de tempo,
	e n�o consegui fazer o grafo bipartido, vi exemplos de como faz, mas n�o entendi a l�gica.
*/
public class GrafosAti1 {

	private static String simplesMultigrafo(int[][] matriz) {
		for (int[] i : matriz) {
			for (int j = 0; j < matriz.length; j++) {
				if (i[j] > 1)
					return "Multigrafo";
			}
		}
		return "Simples";
	}

	private static String completo(int[][] matriz) {
		int tamanho = matriz.length;
		int count = 1;
		for (int[] i : matriz) {
			for (int j = 0; j < tamanho; j++) {
				if (j < count) {
					count++;
					continue;
				}
				if (i[j] != 1) {
					return "N�o � completo";
				}
			}
		}
		return "� completo";
	}

	private static String nulo(int[][] matriz) {
		for (int[] i : matriz) {
			for (int j : i) {
				if (j != 0)
					return "N�o � nulo";
			}
		}
		return "Nulo";
	}

	private static String regular(int[][] matriz) {
		int soma = 0;
		int somaAnti = 0;
		int tamanho = matriz.length;

		for (int[] i : matriz) {
			for (int j = 0; j < tamanho; j++) {
				soma += i[j];
			}
			if (somaAnti != 0 && somaAnti != soma)
				return "N�o � Regular";
			somaAnti = soma;
		}
		return "� regular";

	}

	private static String dirigido(int[][] matriz) {
		int tamanho = matriz.length;
		int count = 1;
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = count; coluna < tamanho; coluna++) {
				if (matriz[linha][coluna] != matriz[coluna][linha]) {
					return "Dirigido";
				}
			}
			count++;
		}
		return "N�o Dirigido";
	}

	private static String bipartido(int[][] matriz) {// todo
		
		return "*** ";
	}

	public static String tipoDoGrafo(int[][] matriz) {
		return (dirigido(matriz) + ", " + simplesMultigrafo(matriz) + ", " + regular(matriz) + ", " + completo(matriz)
				+ ", " + nulo(matriz) + ", " + bipartido(matriz) + ".");
	}

	public static String arestasDoGrafo(int[][] matriz) {
		int soma = 0;
		int count = 0;
		for (int[] i : matriz) {
			if (dirigido(matriz).equals("N�o Dirigido")) {
				for (int j = count; j < matriz.length; j++) {
					if (count == j)
						continue;
					soma += i[j];
				}
			} else {
				for (int p = 0; p < matriz.length; p++) {
					soma += i[p];
				}
			}

			count++;
		}
		return ("" + soma);
	}

	public static String grausDasArestas(int[][] matriz) {
		int soma = 0;
		String out = "";

		for (int[] i : matriz) {
			for (int j = 0; j < matriz.length; j++) {
				soma += i[j];
			}
			out += soma + "; ";
		}
		return (out);
	}

	public static void main(String[] args) {
		int[][] matriz = new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } };
		System.out.println("O grafo � " + tipoDoGrafo(matriz));
		System.out.println("Possui " + arestasDoGrafo(matriz) + " Arestas.");
		System.out.println("Graus de cada aresta " + grausDasArestas(matriz));
	}
}
