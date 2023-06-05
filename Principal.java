// João Marcelo Schneider da Silva e Souza
// Guilherme Soares

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

		System.out.println(dj.dijkstra());

		System.out.println("----------QUESTÃO 2----------");
        
		ComponentesFortementeConexas componentesFortementeConexas = new ComponentesFortementeConexas();

		componentesFortementeConexas.componentesFortementeConexas();

    }
}
