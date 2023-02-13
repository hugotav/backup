package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CriacaoConta {
	
	static Scanner input = new Scanner(System.in);
	
public static void criarConta() throws SQLException{
        
		//String nome = ValidacaoEntradas.confirmaNome();
		System.out.println("Favor insira o nome do seu usuario: ");
		String nome = input.nextLine();
	
		int id = ValidacaoEntradas.confirmaRg();
        
        int senha = ValidacaoEntradas.confirmaSenha();
        
        int tipoConta = 2; //id que identifica o tipo de conta cliente 
        
        ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);
		
		try {
			PreparedStatement stm = connection.prepareStatement ("INSERT INTO CLIENTE (nome, tipoConta, id, senha) VALUES (?, ?, ?, ?)"
					, Statement.RETURN_GENERATED_KEYS);
			
			adicionarVariavelCliente(nome, tipoConta, id, senha,  stm);
						
			connection.commit();
			
			System.out.println("Cadastro efetuado com sucesso!");
			DesafioDevTechlead.menu();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
              
    
    }
    
    private static void adicionarVariavelCliente(String nome, int id, int senha, int tipoConta, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setInt(2, id);
		stm.setInt(3, senha);
		stm.setInt(4, tipoConta);
		
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer idd = rst.getInt(1);			
		}
		rst.close();
	}
    
}
