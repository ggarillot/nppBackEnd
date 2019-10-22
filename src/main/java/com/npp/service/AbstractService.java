package com.npp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import com.npp.exception.EntityDoesNotExistForUpdateException;
import com.npp.exception.GenericNotFoundInDatabaseException;
import com.npp.ientity.IHasID;
import com.npp.iservice.IAbstractService;

public abstract class AbstractService<G extends IHasID<I>, I> implements IAbstractService<G, I> {

	@Autowired
	protected JpaRepository<G, I> repository;

	/**
	 * Add the object in the database
	 * 
	 * @param g : object to persist return the saved objet
	 */
	@Override
	public G add(G g) {
		g.getId();
		return repository.save(g);
	}

	/**
	 * Verify that the object already exists in the database before the update
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
	 * Update the object without verifying that it exists or Not. If it does not
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
