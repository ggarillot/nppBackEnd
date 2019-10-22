package com.npp.iService;

import java.util.List;
import java.util.Optional;

public interface IGenericService<G, I> {
	public G add(G g);

	public G update(G g);

	public void delete(I id);

	public Optional<G> getById(I id);

	public List<G> findAll();

}
