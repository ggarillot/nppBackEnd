package com.npp.iService;

import java.util.List;
import java.util.Optional;

public interface IGenericService <G> {
	public G add(G g);
	public G update(G g);
	public void delete(Long id);
	public Optional<G> getById(Long id);
	public List<G> findAll();

}
