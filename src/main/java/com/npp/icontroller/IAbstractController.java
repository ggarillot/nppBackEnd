package com.npp.icontroller;

import org.springframework.http.ResponseEntity;

//SHIT for the moment
public interface IAbstractController<G,I> {
	
	public ResponseEntity<G> add(G g);
	
	

}
