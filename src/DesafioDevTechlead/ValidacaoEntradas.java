package DesafioDevTechlead;

import java.util.Scanner;

public class ValidacaoEntradas {
	
	static Scanner input = new Scanner(System.in);
	
	public static String confirmaNome() {
		
		String digitacao2;
    	String nome = "";
    	do {
    	    System.out.println("Favor insira o seu nome: ");
    	    digitacao2 = input.next();
    	    if (digitacao2.matches("^[a-zA-Z0-9\s]+$")) {
    	        nome = digitacao2;
    	        return nome;
    	    } else {
    	        System.out.println("Nome invalido!");
    	    }
    	} while (!digitacao2.matches("^[a-zA-Z0-9\s]+$"));
		return nome;
	}
	
	public static int confirmaRg() {
	
		String digitacao;
    	int rg = 0;
    	do {
    	    System.out.println("Favor insira o seu RG: ");
    	    digitacao = input.next();
    	    if (digitacao.matches("^\\d{6}[0-9]+$")) {
    	        rg = Integer.parseInt(digitacao);
    	        return rg;
    	    } else {
    	        System.out.println("RG invalido");
    	    }
    	} while (!digitacao.matches("^\\d{6}[0-9]+$"));
		return 0;
	}
	
	public static int confirmaSenha() {
		
		String digitacao3;
    	int senha = 0;
    	do {
    	    System.out.println("Favor insira uma senha numerica contendo 6 digitos: ");
    	    digitacao3 = input.next();
    	    if (digitacao3.matches("^\\d{5}[0-9]+$")) {
    	        senha = Integer.parseInt(digitacao3);
    	        return senha;
    	    } else {
    	        System.out.println("Senha invalida!");
    	    }
    	} while (!digitacao3.matches("^\\d{5}[0-9]+$"));
		return 0;
	}
	
	public static int confirmaAnoLivro() {
		
		String digitacao4;
    	int ano = 0;
    	do {
    	    System.out.println("Favor insira o ano de lancamento do livro: ");
    	    digitacao4 = input.next();
    	    if (digitacao4.matches("^\\d{3}[0-9]+$")) {
    	        ano = Integer.parseInt(digitacao4);
    	        return ano;
    	    } else {
    	        System.out.println("Ano invalido!");
    	    }
    	} while (!digitacao4.matches("^\\d{3}[0-9]+$"));
    	//"^\\d{6}[0-9]+$"
		return 0;
	}
	
	public static String confirmaNomeLivro() {
		
		String digitacao5;
    	String nome = "";
    	do {
    	    System.out.println("Favor insira o nome do livro: ");
    	    digitacao5 = input.next();
    	    if (digitacao5.matches("[a-zA-Z0-9\s]+")) {
    	        nome = digitacao5;
    	        return nome;
    	    } else {
    	        System.out.println("Nome invalido!");
    	    }
    	} while (!digitacao5.matches("[a-zA-Z0-9\s]+"));
		return nome;
	}
	
	public static String confirmaNomeEditora() {
		
		String digitacao6;
    	String nome = "";
    	do {
    	    System.out.println("Favor insira o nome da editora: ");
    	    digitacao6 = input.next();
    	    if (digitacao6.matches("[a-zA-Z0-9\s]+")) {
    	        nome = digitacao6;
    	        return nome;
    	    } else {
    	        System.out.println("Nome invalido!");
    	    }
    	} while (!digitacao6.matches("[a-zA-Z0-9\s]+"));
		return nome;
	}
	
}
