package DesafioDevTechlead;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuLogado {
	
	static Scanner input = new Scanner(System.in);
	
	public static void menuLogado(int idClientePerfil) throws SQLException {

        if (idClientePerfil == 2) {
        
        System.out.println(" ");
        System.out.println("Seja bem-vindo, leitor!");
        System.out.println(" ");
        System.out.println("Por favor selecione a operacao desejada");
        System.out.println("1 - Listar livros");
        System.out.println("2 - Cadastrar livros");
        System.out.println("3 - Editar livros");
        System.out.println("4 - Excluir livros");
        System.out.println("5 - Sair");
        

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
            	ListaLivros.listarLivros(idClientePerfil);
                break;
            
            case 2:
            	CadastroLivros.cadastrarLivros(idClientePerfil);
                break;

            case 3:
                EdicaoLivros.editarLivros(idClientePerfil);
                break;
                
            case 4:
                ExclusaoLivros.excluirLivros(idClientePerfil);
                break;
                
            case 5:
                System.out.println("Volte sempre!");
                DesafioDevTechlead.menu();

            default:
                System.out.println("Operação invalida!");
                menuLogado(idClientePerfil);
                break;
        }
            
        }if (idClientePerfil == 23) {
            
        System.out.println(" ");
        System.out.println("Seja bem-vindo, leitor!");
        System.out.println(" ");
        System.out.println("Por favor selecione a operacao desejada");
        System.out.println("1 - Listar livros");
        System.out.println("2 - Cadastrar livros");
        System.out.println("3 - Editar livros");
        System.out.println("4 - Excluir livros");
        System.out.println("5 - Detalhar livros");
        System.out.println("6 - Sair");
        

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                ListaLivros.listarLivros(idClientePerfil);
                break;
            
            case 2:
                CadastroLivros.cadastrarLivros(idClientePerfil);
                break;

            case 3:
            	EdicaoLivros.editarLivros(idClientePerfil);
                break;
                
            case 4:
            	ExclusaoLivros.excluirLivros(idClientePerfil);
                break;
                
            case 5:
                DetalhesLivros.detalharLivros(idClientePerfil);
                break;
                
            case 6:
                System.out.println("Volte sempre!");
                DesafioDevTechlead.menu();   

            default:
                System.out.println("Operação invalida!");
                menuLogado(idClientePerfil);
                break;
            }
        }
          
    }

}
