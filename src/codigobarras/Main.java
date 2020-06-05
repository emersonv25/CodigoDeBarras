/* Atividade de Programação, Verificador de código de barras.
 * Faculdade UNINASSAU
 * 09/12/2019
 * Alunoss:
 * Emerson de Jesus Santos - Mátricula: 16017157
 * Matheus Felipe Vieira Santiago - Mátricula: 
 */

package codigobarras;

import java.util.Scanner;

/**
 * 09/12/2019
 * @author emersonv25 and matheus55391 - Faculdade Maurício de Nassau
 */

public class Main {
	
	private static Scanner input; 

	public static void main(String[] args) {
		input = new Scanner(System.in); // cria o "teclado"

		while (true) { 
			printMenu (); // imprime o Menu
			String opcao = input.next(); // Pede a entrada da opção
			
			// Switch chamando as funções das opções
			switch (opcao) {
				case "1":
					Validar_Codigo();
					break;
				case "2":
					Identificar_Pais ();				
					break;
				case "3":
					Sair();
					break;
				default:
					System.out.println("Opção Invalida! Tente novamente.");
					break;
		
			}
		}	

	}
	
	
	
	static void printMenu () { // Imprime o MENU principal
		System.out.println("----------------------------");
		System.out.println("        VAREJO S/A          ");
		System.out.println("Código GTIN-13/UPC/EAN-13");
		System.out.println("----------------------------");
		System.out.print("1) Validar código GTIN-13\n2) Identificar País\n3) Sair\n");
		
	}
	
	
	
	static void Validar_Codigo() { // Primeira opção do menu.
		long codigo;
		System.out.print("Digite o código de 13 dígitos: ");
		codigo = input.nextLong();
		String codTxt = ""+codigo;
		
		
		//Utiliza a classe com a função que verifica o tamanho.
		if (Gtin.Tamanho(codTxt) == true) { // se == True, continua.
			if (Gtin.Validar(codigo) == true) { // Chama a função que verifica com um algoritimo se o código é válido
				System.out.println("DIGITO VERIFICADOR: "+ Gtin.ultimo_digito(codigo)); // Imprime o digito verificador "Não faz sentido pedi o digito se é o ultimo digito do código"
				System.out.println("NUMERO GTIN-13 VÁLIDO!");
								
			}else{
				System.out.println("NUMERO GTIN-13 INVÁLIDO!");
			}
			
		}else { // se o Número não possuir 13 digitos imprime:
			System.out.println("Número GTIN não possui 13 dígitos");
		}
		System.out.println("----------------------------");
		System.out.println("Pressione Enter para Continuar");
		input.nextLine(); input.nextLine();
	}
	
	
	static void Identificar_Pais (){ // Segunda opção do menu
		long codigo;
		System.out.println("Digite o código de 13 dígitos: "); 
		codigo = input.nextLong();
		System.out.println(Gtin.Local(codigo)); // Chama a classe com o verificador de origem.
		System.out.println("----------------------------");
		System.out.println("Pressione Enter para Continuar");
		input.nextLine(); input.nextLine();
	}
	
	
	static void Sair () { // Terceira opção do menu
		System.out.println("Programa Encerrado.");
		System.exit(0);
	}
}
