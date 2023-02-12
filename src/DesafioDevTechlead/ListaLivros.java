package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ListaLivros {
	
	static Scanner input = new Scanner(System.in);
	
	public static void listarLivros(int idClientePerfil) throws SQLException {
	       
    	ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
    
		PreparedStatement stm = connection.prepareStatement("SELECT NOME, ANO FROM LIVRO");
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			String nome = rst.getString("NOME");
			System.out.println(nome);
			Integer ano = rst.getInt("ANO");
			System.out.println(ano);
			
		}
		
		connection.close();
		
		MenuLogado.menuLogado(idClientePerfil);
    	
    	
    }
	
	

}
