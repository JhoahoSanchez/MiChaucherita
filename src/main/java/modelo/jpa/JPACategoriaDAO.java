package modelo.jpa;

import modelo.dao.CategoriaDAO;
import modelo.entidades.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> implements CategoriaDAO{

	public JPACategoriaDAO() {
		super(Categoria.class);
	}

}
