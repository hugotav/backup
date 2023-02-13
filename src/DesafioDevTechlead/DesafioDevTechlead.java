package DesafioDevTechlead;

import java.sql.SQLException;
import java.util.Scanner;

public class DesafioDevTechlead {
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) throws SQLException {
        
    	
        menu();
        
        
    }
    
    public static void menu() throws SQLException {

        System.out.println(" ");
        System.out.println("Seja bem-vindo ao sistema da Biblioteca TECHLEAD");
        System.out.println(" ");
        System.out.println("Por favor selecione a operacao desejada");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Logar");
        System.out.println("3 - Esqueci minha senha");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                CriacaoConta.criarConta();
                break;

            case 2:
                LoginUsuario.logar();
                break;

            case 3:
                RecuperacaoSenha.recuperarSenha();
                break;
                
            default:
                System.out.println("Operacao invalida!");
                menu();
                break;
        }
    }
    
    
}