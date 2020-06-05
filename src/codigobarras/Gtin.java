package codigobarras;

public class Gtin {
	
	
	//Verificar se o código tem 13 digitos
	static boolean Tamanho(String num) {
	        if (num.length() == 13) { // se o tamanho da string for igual a 13 
	            return true;
	            // Retorna True se o tamanho for == 13
	        } else {
	            return false;
	        }			
	}

	
	static String ultimo_digito(long num) { // Função para retornar o ultimo digito
		long ln =  num % 10; // modulo de 10 == ultimo digito
		return  ""+ln; // por conta de limitações para retornar um long e fazer o calculo com um int "nº de digitos", ficou mais simples calcular com long e retornar uma string.
	
	}
	
	
	
	static boolean Validar(long num) {
		//faz a checagem do digito verificador
		long end_number = num % 10; // ultimo digito = digit verificador
		num = num / 10; // 
		long ln;
		int soma = 0;
		int soma2;
		for (int i = 0; i < 12; i ++) {
			ln =  num %10;
			if (i % 2==0) {
				ln = ln * 3;
			}
			soma = (int)ln + soma;
			num = num / 10;			
		}
		soma2 = soma;
		soma = soma / 10;
		soma = soma+1;
		soma = soma * 10;
		soma = soma - soma2;
		if (soma % 10 == 0) {
			//Se o resultado for um multiplo de 10, o digito verificador será zero (0).
			soma = 0;
		}
		if (end_number == soma) {			
			return true;		
		}
		else {
			return false;	
		}

	}
	
	
	
	static String Local (long num) {
		// Usando lógica matématica para obter apenas os 3 primeiros digitos de um numero com 13 digitos.
		int Codigo_Origem = (int) (num/1000000000); // dividindo por 10**9 == 4 primeiros digitos
		Codigo_Origem = Codigo_Origem/10; // por conta da limitação do tipo int
		
		
		// Switch simples para retornar o país de origem
		switch (Codigo_Origem) {
			case 789:
				return ("GTIN-13 origem Brasil: 789");
			case 790:
				return ("GTIN-13 origem Brasil: 790");
			case 779:
				return ("GTIN-13 origem Argentina: 779");
			case 773:
				return ("GTIN-13 origem Uruguai: 773");
			case 780:
				return ("GTIN-13 origem Chile: 790");
			case 784:
				return ("GTIN-13 origem Paraguai: 784");
			case 786:
				return ("GTIN-13 origem Equador: 786");
			case 770:
				return ("GTIN-13 origem Colômbia: 770");
			case 743:
				return ("GTIN-13 origem Nicarágua: 743");
			case 600:
				return ("GTIN-13 origem Africa do Sul: 600");
			case 601:
				return ("GTIN-13 origem Africa do Sul: 601");
				
				
		}
		return ("VAREJO S/A: Não vendemos para este país: " + Codigo_Origem);
		// caso o Codigo_Origem for diferente das opções.
		
		
	}
}
