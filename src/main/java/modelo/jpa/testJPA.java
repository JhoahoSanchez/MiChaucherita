package modelo.jpa;

import modelo.dao.DAOFactory;
import modelo.entidades.Categoria;
import modelo.entidades.Cuenta;
import modelo.entidades.Movimiento;
import modelo.entidades.TipoCategoria;
import modelo.entidades.Usuario;

public class testJPA {

	public static void main(String[] args) {
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setUsername("juan");
		usuario.setPassword("juan123");
		DAOFactory.getFactory().getUsuarioDAO().create(usuario);
		
		System.out.println("Persona Creada");
		
		//Categoria
		Categoria categ = new Categoria();
		categ.setNombre("Salario");
		categ.setUsuario(usuario);
		categ.setCategoria(TipoCategoria.INGRESO);
		DAOFactory.getFactory().getCategoriaDAO().create(categ);
		
		System.out.println("Categoria creada");
		
		//Cuenta
		Cuenta cuenta = new Cuenta();
		cuenta.setNombre("Cash");
		cuenta.setSaldo(500);
		cuenta.setDescripcion("SDFG");
		cuenta.setUsuario(DAOFactory.getFactory().getUsuarioDAO().getById(1));
		
		DAOFactory.getFactory().getCuentaDAO().create(cuenta);
		
		System.out.println("Cuenta creada");
		
		
	}
	
}
