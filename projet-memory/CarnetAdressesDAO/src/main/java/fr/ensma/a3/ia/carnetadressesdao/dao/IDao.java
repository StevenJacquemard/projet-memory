package fr.ensma.a3.ia.carnetadressesdao.dao;

import java.util.List;
import java.util.Optional;

import fr.ensma.a3.ia.carnetadressesdao.dao.exceptions.MissingElementException;

/**
 * Interface DAO générique.
 * @author michaelrichard
 *
 * @param <T> Type manipulé par le DAO
 */
public interface IDao<T> {

	public Optional<T> getById(int id);
	public Optional<T> getByValue(T elem);
	List<T> getAll();
	void create(T elem);
	void update(T elem);
	void delete(T elem);
	
}
