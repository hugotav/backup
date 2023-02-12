package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DetalhesLivros {
	
	static Scanner input = new Scanner(System.in);
	
	public static void detalharLivros(int idClientePerfil) throws SQLException {
    	ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
    
		PreparedStatement stm = connection.prepareStatement("SELECT NOME, ANO, "
				+ "EDITORA, CODIGOCADASTRO FROM LIVRO");
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			String nome = rst.getString("NOME");
			System.out.println(nome);
			Integer ano = rst.getInt("ANO");
			System.out.println(ano);
			String editora = rst.getString("EDITORA");
			System.out.println(editora);
			Integer cod = rst.getInt("CODIGOCADASTRO");
			System.out.println(cod);
			
		}
		
		connection.close();
		
		MenuLogado.menuLogado(idClientePerfil);
    }

}
