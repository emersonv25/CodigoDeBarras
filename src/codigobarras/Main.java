/* Atividade de Programa��o, Verificador de c�digo de barras.
 * Faculdade UNINASSAU
 * 09/12/2019
 * Alunoss:
 * Emerson de Jesus Santos - M�tricula: 16017157
 * Matheus Felipe Vieira Santiago - M�tricula: 
 */

package codigobarras;

import java.util.Scanner;

/**
 * 09/12/2019
 * @author emersonv25 and matheus55391 - Faculdade Maur�cio de Nassau
 */

public class Main {
	
	private static Scanner input; 

	public static void main(String[] args) {
		input = new Scanner(System.in); // cria o "teclado"

		while (true) { 
			printMenu (); // imprime o Menu
			String opcao = input.next(); // Pede a entrada da op��o
			
			// Switch chamando as fun��es das op��es
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
					System.out.println("Op��o Invalida! Tente novamente.");
					break;
		
			}
		}	

	}
	
	
	
	static void printMenu () { // Imprime o MENU principal
		System.out.println("----------------------------");
		System.out.println("        VAREJO S/A          ");
		System.out.println("C�digo GTIN-13/UPC/EAN-13");
		System.out.println("----------------------------");
		System.out.print("1) Validar c�digo GTIN-13\n2) Identificar Pa�s\n3) Sair\n");
		
	}
	
	
	
	static void Validar_Codigo() { // Primeira op��o do menu.
		long codigo;
		System.out.print("Digite o c�digo de 13 d�gitos: ");
		codigo = input.nextLong();
		String codTxt = ""+codigo;
		
		
		//Utiliza a classe com a fun��o que verifica o tamanho.
		if (Gtin.Tamanho(codTxt) == true) { // se == True, continua.
			if (Gtin.Validar(codigo) == true) { // Chama a fun��o que verifica com um algoritimo se o c�digo � v�lido
				System.out.println("DIGITO VERIFICADOR: "+ Gtin.ultimo_digito(codigo)); // Imprime o digito verificador "N�o faz sentido pedi o digito se � o ultimo digito do c�digo"
				System.out.println("NUMERO GTIN-13 V�LIDO!");
								
			}else{
				System.out.println("NUMERO GTIN-13 INV�LIDO!");
			}
			
		}else { // se o N�mero n�o possuir 13 digitos imprime:
			System.out.println("N�mero GTIN n�o possui 13 d�gitos");
		}
		System.out.println("----------------------------");
		System.out.println("Pressione Enter para Continuar");
		input.nextLine(); input.nextLine();
	}
	
	
	static void Identificar_Pais (){ // Segunda op��o do menu
		long codigo;
		System.out.println("Digite o c�digo de 13 d�gitos: "); 
		codigo = input.nextLong();
		System.out.println(Gtin.Local(codigo)); // Chama a classe com o verificador de origem.
		System.out.println("----------------------------");
		System.out.println("Pressione Enter para Continuar");
		input.nextLine(); input.nextLine();
	}
	
	
	static void Sair () { // Terceira op��o do menu
		System.out.println("Programa Encerrado.");
		System.exit(0);
	}
}
