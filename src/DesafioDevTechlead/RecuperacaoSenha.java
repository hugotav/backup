package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RecuperacaoSenha {
	
	static Scanner input = new Scanner(System.in);
	
	public static void recuperarSenha() throws SQLException{
	    
		//String nome = ValidacaoEntradas.confirmaNome();
		System.out.println("Favor insira o seu nome: ");
		String nome = input.nextLine();
		
        int id = ValidacaoEntradas.confirmaRg();
        
        ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
    
		PreparedStatement stm = 
				connection.prepareStatement
					("SELECT NOME, ID FROM CLIENTE WHERE NOME = ? AND "
							+ "ID = ?");
		stm.setString(1, nome);
		stm.setInt(2, id);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
			while(rst.next()) {
				String nome1 = rst.getString("NOME");
				Integer id1 = rst.getInt("ID");
				
				if(nome1.equals(nome) && id1 == id) {
                    
					int novaSenha = ValidacaoEntradas.confirmaSenha();
					
					PreparedStatement stm1 = 
							connection.prepareStatement("UPDATE CLIENTE SET SENHA = ? "
									+ "WHERE NOME = ? AND ID = ?");
					stm1.setInt(1, novaSenha);
					stm1.setString (2, nome1);
					stm1.setInt (3, id1);
					stm1.execute();
    		          
					System.out.println("Editado com sucesso!");
					DesafioDevTechlead.menu();
                        
					    }
				}
			System.out.println("Usuario nao encontrado");
			DesafioDevTechlead.menu();
        
    }
	
	

}
