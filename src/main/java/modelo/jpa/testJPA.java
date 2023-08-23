package modelo.jpa;

import modelo.dao.DAOFactory;
import modelo.entidades.Usuario;

public class testJPA {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setUsername("juan23");
		usuario.setPassword("juan23415");
		DAOFactory.getFactory().getUsuarioDAO().create(usuario);
		
		System.out.println("Persona Creada");
		
	}
	
}
