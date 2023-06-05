// Guilherme Soares
// João Marcelo Schneider da Silva e Souza

public class Principal {
    public static void main(String[] args) {

		System.out.println("----------QUESTÃO 1----------");

		Dijkstra dj = new Dijkstra('F','A',new int[][] 
						  { {0, 'I', 'I', 'I', 'I', 'I', 'I'}, 
							{'I', 0, 'I', 'I', 'I', 'I', 'I'},	
							{4, 'I', 0, 'I', 'I', 'I','I'}, 
						   	{'I', 3, 'I', 0, 1, 'I', 'I'},
						   	{'I', 'I', 2, 'I', 0, 'I', 'I'}, 	
						   	{'I', 'I','I', 3, 'I', 0, 2},
						   	{'I', 'I', 'I', 'I', 5, 'I', 0} });


							   for(int i= 0; i<dj.getW().length;i++) {
								for(int j = 0;j<dj.getW()[0].length;j++) {
									if(dj.getW()[i][j]=='I') {
										System.out.print("|I");
									}else {
									System.out.print("|"+dj.getW()[i][j]);
									}			}
								System.out.println("| \n");
							}

		System.out.println("----\n" + dj.dijkstra());

		System.out.println("----------QUESTÃO 2----------");
        
		ComponentesFortementeConexas componentesFortementeConexas = new ComponentesFortementeConexas();

		componentesFortementeConexas.componentesFortementeConexas();

    }
}
