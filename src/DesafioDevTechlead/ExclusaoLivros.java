package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExclusaoLivros {
	
	static Scanner input = new Scanner(System.in);
	
	public static void excluirLivros(int idClientePerfil) throws SQLException{
        
        if (idClientePerfil == 2){
        
        System.out.println("Favor insira o nome do livro: ");
        String nome = input.nextLine();
        
        int ano = ValidacaoEntradas.confirmaAnoLivro();
        
        int codigoCadastro = ValidacaoEntradas.confirmaRg();
        
        ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
    
		PreparedStatement stm = 
				connection.prepareStatement
				("SELECT NOME, ANO, CODIGOCADASTRO FROM LIVRO WHERE NOME = ? AND ANO = ?");
		stm.setString(1, nome);
		stm.setInt(2, ano);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
			while(rst.next()) {
				String nome1 = rst.getString("NOME");
				Integer ano1 = rst.getInt("ANO");
				Integer codigo1 = rst.getInt("CODIGOCADASTRO");
				
				if(nome1.equals(nome) && ano1 == ano && codigo1 == codigoCadastro) {
					
					PreparedStatement stm1 = 
							connection.prepareStatement("DELETE FROM LIVRO WHERE ANO = ?");
					stm1.setInt(1, ano1);
					stm1.execute();
					
					System.out.println("Livro excluido com sucesso!");
					
				}
				
				MenuLogado.menuLogado(idClientePerfil);
			
			}
			
			if (rst.getRow() == 0) {
				System.out.println("Sem permissao para editar este livro!");
				MenuLogado.menuLogado(idClientePerfil);
			}
                   
        }
        
        if (idClientePerfil == 23){
        
        	System.out.println("Favor insira o nome do livro: ");
            String nome = input.nextLine();
            
            int ano = ValidacaoEntradas.confirmaAnoLivro();
            
            ConnectionFactory factory = new ConnectionFactory();
    		Connection connection = factory.recuperarConexao();
        
    		PreparedStatement stm = connection.prepareStatement("SELECT NOME, ANO FROM LIVRO WHERE ANO = ?");
    		stm.setInt(1, ano);
    		stm.execute();
    		
    		ResultSet rst = stm.getResultSet();
    		
    			while(rst.next()) {
    				String nome1 = rst.getString("NOME");
    				Integer ano1 = rst.getInt("ANO");    				
    				
    				if(nome1.equals(nome) && ano1 == ano) {
    					
    					PreparedStatement stm1 = 
    							connection.prepareStatement("DELETE FROM LIVRO WHERE ANO = ?");
    					stm1.setInt(1, ano1);
    					stm1.execute();
    					
    					System.out.println("Livro excluido com sucesso!");
    					
    				}
    			
    				MenuLogado.menuLogado(idClientePerfil);
    			
    			}   
    			
    			if (rst.getRow() == 0) {
					System.out.println("Livro nao encontrado!");
					MenuLogado.menuLogado(idClientePerfil);
				}
        }
      
    }

}
