

public class Dijkstra {

	private int tamanho;
	private int[] pai;
	private int[] distancia;
	private int[][] w;
	
	public void initializeSingleSource(int inicio) {
		for(int i = 0;i<w.length;i++) {
			distancia[i] = 'I';
			pai[i] = 'π'; // π
		}
		distancia[inicio] = 0;
	}
	
	public void relax(int u, int v, int[][] w) {//?????
		
		for(int i = 0; i<w.length;i++) {
			if(w[v][i] > w[i][u] + w[u][v]) {
				distancia[v] = distancia[u] + w[u][v];
				pai[v] = u;
		}
		}
		
	}
	
	public void dijkstra(int[][] w, int inicio) { //todo
		initializeSingleSource(inicio);
		
	}

	public Dijkstra(int tamanho, int[][] w) {
		this.distancia = new int[tamanho];
		this.pai = new int[tamanho];							   	
		setW(w);
							   	
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int[] getPai() {
		return pai;
	}

	public void setPai(int[] pai) {
		this.pai = pai;
	}

	public int[][] getW() {
		return w;
	}

	public void setW(int[][] w) {
		this.w = w;
	}

	
}
