package com.npp.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.npp.exception.EntityDoesNotExistForUpdateException;
import com.npp.exception.GenericNotFoundInDatabaseException;
import com.npp.ientity.IHasID;
import com.npp.iservice.IAbstractService;

public abstract class AbstractService<G extends IHasID<I>, I> implements IAbstractService<G, I> {

	protected JpaRepository<G, I> repository;

	/**
	 * Add the object in the database
	 * 
	 * @param g : object to persist
	 * @return the saved objet
	 */
	@Override
	public G add(G g) {
		return repository.save(g);
	}

	/**
	 * Update the object without verifying that it exists or not. If it does not
	 * exist it will create it
	 * 
	 * @param g : Object to persist
	 * @return the altered Object
	 */
	@Override
	public G update(G g) {

		return repository.save(g);
	}

	/**
	 * Update an object in the database, but before, it checks if the objects exists
	 * 
	 * @param g  : object to persist
	 * @param id : the identifier of the object
	 * @return the altered Object
	 * @throws EntityDoesNotExistForUpdateException
	 */
	@Override
	public G update(G g, I id) throws EntityDoesNotExistForUpdateException {
		if (this.getById(id) == null) {
			String serviceName = this.getClass().getName();
			throw new EntityDoesNotExistForUpdateException(serviceName + ".update(" + id + ") : not exist in database");
		}
		return this.update(g);
	}

	/**
	 * Delete the object in the database
	 * 
	 * @param id : the identifier of the object
	 */
	@Override
	public void delete(I id) {
		repository.deleteById(id);
	}

	/**
	 * Recuperation of the object with the specified id in the database
	 * 
	 * @param id : the identifier of the object
	 * @return the object which correspond to the id
	 */
	@Override
	public G getById(I id) {
		G g = null;
		try {
			String serviceName = this.getClass().getName();
			g = repository.findById(id).orElseThrow(() -> new GenericNotFoundInDatabaseException(
					serviceName + ".getById(" + id + ") : not found in database"));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return g;
	}

	/**
	 * Recuperation of the list of object in the database
	 * 
	 * @return all the list of object
	 */
	@Override
	public List<G> findAll() {
		return repository.findAll();
	}

}
