package com.npp.iservice;

import java.util.List;

import com.npp.exception.EntityDoesNotExistForUpdateException;

public interface IAbstractService<G, I> {
	public G add(G g);

	public G update(G g);

	public G update(G g, I id) throws EntityDoesNotExistForUpdateException;

	public void delete(I id);

	public G getById(I id);

	public List<G> findAll();

}
