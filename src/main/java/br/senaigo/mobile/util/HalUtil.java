package br.senaigo.mobile.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * T is meant to be a Type
 * E is meant to be an Element (List<E>: a list of Elements)
 * K is Key (in a Map<K,V>)
 * V is Value (as a return value or mapped value)
 * 
 * @param controller
 * @return
 */
public class HalUtil<T,E> {

	Logger logger = LoggerFactory.getLogger(HalUtil.class);
	
//	public Link linkTo(T controller, E entity) {
//		return linkTo(controller.class).slash(entity.getIdOrder()).withSelfRel();
//		
//	}
}
