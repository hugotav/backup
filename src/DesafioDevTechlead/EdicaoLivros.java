package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EdicaoLivros {
	
	static Scanner input = new Scanner(System.in);
	
	public static void editarLivros(int idClientePerfil) throws SQLException{
    	
        if (idClientePerfil == 2){
        	
        	//String nome = ValidacaoEntradas.confirmaNomeLivroEEditora();
        	System.out.println("Favor insira o seu nome: ");
    		String nome = input.nextLine();
        	
            int ano = ValidacaoEntradas.confirmaAnoLivro();
            
            int codigoCadastro = ValidacaoEntradas.confirmaRg();
            
            ConnectionFactory factory = new ConnectionFactory();
    		Connection connection = factory.recuperarConexao();
        
    		PreparedStatement stm4 = 
    				connection.prepareStatement
    					("SELECT NOME, ANO, EDITORA, CODIGOCADASTRO FROM LIVRO WHERE NOME = ? AND "
    							+ "ANO = ? AND CODIGOCADASTRO = ?");
    		stm4.setString(1, nome);
    		stm4.setInt(2, ano);
    		stm4.setInt(3, codigoCadastro);
    		stm4.execute();
    		
    		ResultSet rst = stm4.getResultSet();
    		
    			while(rst.next()) {
    				String nome1 = rst.getString("NOME");
    				Integer ano1 = rst.getInt("ANO");
    				String editora1 = rst.getString("EDITORA");
    				Integer codigo1 = rst.getInt("CODIGOCADASTRO");
    				
    				if(nome1.equals(nome) && ano1 == ano && codigo1 == codigoCadastro) {
    					
    					System.out.println("Por favor selecione a operacao desejada");
                        System.out.println("1 - Editar nome");
                        System.out.println("2 - Editar ano de publicacao");
                        System.out.println("3 - Editar editora");
                        System.out.println("4 - Voltar ao menu principal");
                        
                        int operacao = input.nextInt();
                        
                        switch (operacao) {
                        
                        case 1:
                        	//String nomeNovo = ValidacaoEntradas.confirmaNomeLivroEEditora();
                        	System.out.println("Favor insira o novo nome: ");
                    		String nomeNovo = input.nextLine();
                        	
        		            PreparedStatement stm1 = 
        							connection.prepareStatement("UPDATE LIVRO SET NOME = ? WHERE NOME = ? AND ANO = ?");
        					stm1.setString(1, nomeNovo);
        					stm1.setString (2, nome1);
        					stm1.setInt (3, ano1);
        					stm1.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 2:
                        	int anoNovo = ValidacaoEntradas.confirmaAnoLivro();
        		            
        		            PreparedStatement stm2 = 
        							connection.prepareStatement("UPDATE LIVRO SET ANO = ? WHERE NOME = ? AND ANO = ?");
        					stm2.setInt(1, anoNovo);        					
        					stm2.setString (2, nome1);
        					stm2.setInt (3, ano1);
        					stm2.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 3:
                        	//String nomeEditora = ValidacaoEntradas.confirmaNomeLivroEEditora();
                        	System.out.println("Favor insira o novo nome da editora: ");
                    		String nomeEditora = input.nextLine();
                        	
        		            PreparedStatement stm3 = 
        							connection.prepareStatement("UPDATE LIVRO SET EDITORA = ? "
        									+ "WHERE EDITORA = ? AND NOME = ? AND ANO = ?");
        					stm3.setString(1, nomeEditora);
        					stm3.setString (2, editora1);
        					stm3.setString (3, nome1);
        					stm3.setInt (4, ano1);
        					stm3.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 4:
                        	MenuLogado.menuLogado(idClientePerfil);
                        	break;
                
                        default:
                            System.out.println("Operacao invalida!");
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        }
    			    
    				}
    			
    			}
    			
    			if (rst.getRow() == 0) {
					System.out.println("Sem permissao para editar este livro!");
					MenuLogado.menuLogado(idClientePerfil);
				}
                
    }
        
        	if (idClientePerfil == 23){
        
        	//String nome = ValidacaoEntradas.confirmaNomeLivroEEditora();
        	System.out.println("Favor insira o seu nome: ");
        	String nome = input.nextLine();
        		
            int ano = ValidacaoEntradas.confirmaAnoLivro();
            
            ConnectionFactory factory = new ConnectionFactory();
    		Connection connection = factory.recuperarConexao();
        
    		PreparedStatement stm = 
    				connection.prepareStatement
    					("SELECT NOME, ANO, EDITORA, CODIGOCADASTRO FROM LIVRO WHERE NOME = ? AND "
    							+ "ANO = ? AND CODIGOCADASTRO = ?");
    		stm.setString(1, nome);
    		stm.setInt(2, ano);
    		stm.execute();
    		
    		ResultSet rst = stm.getResultSet();
    		
    			while(rst.next()) {
    				String nome1 = rst.getString("NOME");
    				Integer ano1 = rst.getInt("ANO");
    				String editora1 = rst.getString("EDITORA");
    				Integer codigo1 = rst.getInt("CODIGOCADASTRO");
    				
    				if(nome1.equals(nome) && ano1 == ano) {
    					
    					System.out.println("Por favor selecione a operacao desejada");
                        System.out.println("1 - Editar nome");
                        System.out.println("2 - Editar ano de publicacao");
                        System.out.println("3 - Editar editora");
                        System.out.println("4 - Voltar ao menu principal");
                        
                        int operacao = input.nextInt();
                        
                        switch (operacao) {
                        
                        case 1:
                        	System.out.println("Favor insira o novo nome do livro: ");
        		            String nomeNovo = input.nextLine();
        		            
        		            PreparedStatement stm1 = 
        							connection.prepareStatement("UPDATE LIVRO SET NOME = ? WHERE NOME = ?"
        									+ "AND ANO = ?");
        					stm1.setString(1, nomeNovo);
        					stm1.setString (2, nome1);
        					stm1.setInt (3, ano1);
        					stm1.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 2:
                        	int anoNovo = ValidacaoEntradas.confirmaAnoLivro();
        		            
        		            PreparedStatement stm2 = 
        							connection.prepareStatement("UPDATE LIVRO SET ANO = ? WHERE NOME = ? AND ANO = ?");
        					stm2.setInt(1, anoNovo);        					
        					stm2.setString (2, nome1);
        					stm2.setInt (3, ano1);
        					stm2.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 3:
                        	System.out.println("Favor insira o novo nome da editora: ");
        		            String nomeEditora  = input.nextLine();
        		            
        		            PreparedStatement stm3 = 
        							connection.prepareStatement("UPDATE LIVRO SET EDITORA = ? "
        									+ "WHERE EDITORA = ? AND NOME = ? AND ANO = ?");
        					stm3.setString(1, nomeEditora);
        					stm3.setString (2, editora1);
        					stm3.setString (3, nome1);
        					stm3.setInt (4, ano1);
        					stm3.execute();
        		          
                            System.out.println("Editado com sucesso!");
                            
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        case 4:
                        	MenuLogado.menuLogado(idClientePerfil);
                        	break;
                
                        default:
                            System.out.println("Operação invalida!");
                            MenuLogado.menuLogado(idClientePerfil);
                            break;
                            
                        }
    			    
    				}
    			
    			}   
    			if (rst.getRow() == 0) {
					System.out.println("Livro nao encontrado!");
					MenuLogado.menuLogado(idClientePerfil);
				}
    }
       
}

}
