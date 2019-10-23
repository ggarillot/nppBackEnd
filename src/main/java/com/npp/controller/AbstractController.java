package com.npp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.npp.ientity.IHasID;
import com.npp.iservice.IAbstractService;

public abstract class AbstractController<G extends IHasID<I>, I> {

	protected IAbstractService<G, I> service;

	/**
	 * Add the object
	 * 
	 * @param g
	 * @return the object and the status 200 when it is ok
	 */
	@PostMapping("/add")
	public ResponseEntity<G> add(@RequestBody G g) {

		g = service.add(g);
		return new ResponseEntity<G>(g, HttpStatus.OK);
	}

	/**
	 * update the object with the verified update service
	 * 
	 * @param g
	 * @return the status 404 when the object is not found
	 * @return the object and the status 200 when it is ok
	 */
	@PutMapping("/update")
	public ResponseEntity<G> update(@RequestBody G g) {

		try {
			g = service.update(g, g.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<G>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<G>(g, HttpStatus.OK);
	}

	/**
	 * Delete the object
	 * 
	 * @param id
	 * @return the status 200 when it is ok
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<G> delete(@PathVariable("id") I id) {

		service.delete(id);
		return new ResponseEntity<G>(HttpStatus.OK);

	}

	/**
	 * Recuperation of the object which corresponds to the id
	 * 
	 * @param id
	 * @return the status 404 when the object is not found
	 * @return the object and the status when the object is found
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<G> getById(@PathVariable("id") I id) {
		G g = service.getById(id);

		if (g != null)
			return new ResponseEntity<G>(g, HttpStatus.OK);

		return new ResponseEntity<G>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Recuperation of the list of object
	 * 
	 * @return the list of object and the status 200 when it is ok
	 */
	@GetMapping("/get")
	public ResponseEntity<List<G>> findAll() {

		List<G> gList = service.findAll();
		return new ResponseEntity<List<G>>(gList, HttpStatus.OK);
	}

}
