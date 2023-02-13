package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CadastroLivros {
	
	static Scanner input = new Scanner(System.in);
	
	public static void cadastrarLivros(int idClientePerfil) throws SQLException{ 
	    
        //String nome = ValidacaoEntradas.confirmaNomeLivro();
		System.out.println("Favor insira o nome do livro: ");
		String nome = input.next();

        int ano = ValidacaoEntradas.confirmaAnoLivro();

        //String editora = ValidacaoEntradas.confirmaNomeEditora();
        System.out.println("Favor insira o nome da editora: ");
		String editora = input.next();
        
        int codigoCadastro = ValidacaoEntradas.confirmaRg();       
        
        ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement stm = connection.prepareStatement ("INSERT INTO LIVRO (nome, ano, editora, codigoCadastro) VALUES (?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			adicionarVariavelLivro(nome, ano, editora, codigoCadastro,  stm);
						
			connection.commit();
			
			System.out.println("Cadastro efetuado com sucesso!");
			MenuLogado.menuLogado(idClientePerfil);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
              
    
    }
    
    private static void adicionarVariavelLivro(String nome, int ano, 
    		String editora, int codigoCadastro, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setInt(2, ano);
		stm.setString(3, editora);
		stm.setInt(4, codigoCadastro);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer idd = rst.getInt(1);			
		}
		rst.close();
	}

}
