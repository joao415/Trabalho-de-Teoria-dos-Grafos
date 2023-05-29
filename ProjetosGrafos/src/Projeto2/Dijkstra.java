package Projeto2;

public class Dijkstra {

	private int inicio;
	private int destino;

	private int[] pai;
	private int[] distancia;
	private int[][] w;
	
	private String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


	private void initializeSingleSource(int inicio) {
		for(int i = 0;i<w.length;i++) {
			distancia[i] = 'I';
			pai[i] = 'π'; // π
		}
		distancia[inicio] = 0;
	}
	
	private void relax(int u, int v, int[][] w) {
			if(getDistancia()[v] > getDistancia()[u] + w[u][v]) {
				distancia[v] = distancia[u] + w[u][v];
				pai[v] = u;
		}		
	}
	
	public String dijkstra() { 
		initializeSingleSource(this.getInicio());

		int tamanho = w.length;
		
		do {
			for(int i = 0; i<this.getW().length; i++) {
				for(int j = 0; j < this.getW()[0].length;j++) {
					relax(i,j,this.getW());
				}
			}
			tamanho--;
			
		}while(tamanho != 0);
		
		return "Caminho mínimo: "+ caminhoMin() + "\nCusto: "+getCusto();
		
	}
	
	public String caminhoMin() {
		int ancor = destino;
		String caminhante = "";
		String out = "";
		
		while(ancor != 960) {

		caminhante += getAlfa().charAt(ancor);
		
		ancor = getPai()[ancor];
		}
		
		for(int i = caminhante.length()-1; i>=0;i--) {
			
			out += i == 0? caminhante.charAt(i): caminhante.charAt(i) + " -> ";
		}
		
		return out;
	}
	
	public int getCusto() {
		return getDistancia()[destino];
	}
	
	public Dijkstra(char inicio, char destino,int[][] w) {
		this.setDistancia(new int[w.length]);
		this.setPai(new int[w.length]);							   	
		this.setW(w);
		this.setInicio(inicio);
	}
	
	public int getInicio() {
		return inicio;
	}

	public void setInicio(char inicio) {
		
		this.inicio = getAlfa().indexOf(inicio);
	}
	
	public int[] getDistancia() {
		return distancia;
	}

	public void setDistancia(int[] distancia) {
		this.distancia = distancia;
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
	
	public String getAlfa() {
		return alfa;
	}
	
	public int getDestino() {
		return destino;
	}

	public void setDestino(char destino) {
		this.destino = getAlfa().indexOf(destino);
	}
}
