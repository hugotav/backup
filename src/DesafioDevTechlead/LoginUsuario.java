package DesafioDevTechlead;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginUsuario {
	
	static Scanner input = new Scanner(System.in);
	
	public static void logar() throws SQLException {
    	
		int IdRG = ValidacaoEntradas.confirmaRg();
        
		int senha = ValidacaoEntradas.confirmaSenha();
        
        ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
    
		PreparedStatement stm = 
				connection.prepareStatement
					("SELECT TIPOCONTA, ID, SENHA FROM CLIENTE WHERE ID = ? AND SENHA = ?");
		stm.setInt(1, IdRG);
		stm.setInt(2, senha);
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer tipoConta1 = rst.getInt("TIPOCONTA");
			Integer codigo1 = rst.getInt("ID");
			Integer senha1 = rst.getInt("SENHA");
			
			if (IdRG == codigo1 && senha == senha1){
                System.out.println("Logado com sucesso!");
                
                int idClientePerfil = tipoConta1;
                
                MenuLogado.menuLogado(idClientePerfil);
                
			}
			
			
		}
		
		System.out.println("Credenciais incorretas!");
		DesafioDevTechlead.menu();
        
    }
    
    
    
    
 

}
