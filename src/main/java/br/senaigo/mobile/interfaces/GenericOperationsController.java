package br.senaigo.mobile.interfaces;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public interface GenericOperationsController<E> {
	
	Resource<E> post(E entity); //POST 201
	void put(E entity); //PUT 204 - no content
	void delete(E entity); //DELETE 204
	Resources<E> get(); // GET 200
	Resource<E> get(Long id); //GET 200
	void patch(E entity); //PATCH 204

}
