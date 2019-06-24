package br.senaigo.mobile.controlller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senaigo.mobile.entities.People;
import br.senaigo.mobile.interfaces.GenericOperationsController;

@RestController
@RequestMapping("/peoples")
public class PeopleController implements GenericOperationsController<People> {
	
	/**
	 * @see http://appsdeveloperblog.com/spring-boot-logging-with-loggerfactory/
	 */
	Logger logger = LoggerFactory.getLogger(PeopleController.class);

	@Override
	public Resource<People> post(People entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, 
							 MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public void put(@RequestBody People people) {
		logger.info("Atulizado registro de pessoa.");
		
	}

	@Override
	public void delete(People entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, 
							 MediaType.APPLICATION_XML_VALUE,
							 MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Resources<People> get() {
		try {
			//List<Order> orders = orderService.get();
			
			//logger.info(String.format("Registro(s) recuperados(s): %s",orders.toString()));
			
//			for (final Order order : orders) {
//		        Link selfLink = linkTo(methodOn(OrderController.class)
//		          .getOrderById(customerId, order.getIdOrder()())).withSelfRel();
//		        order.add(selfLink);
//		    }
//		  
//		    Link link = linkTo(methodOn(CustomerController.class)
//		      .getOrdersForCustomer(customerId)).withSelfRel();
//		    Resources<Order> result = new Resources<Order>(orders, link);
//		    return result;
			
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}

	@Override
	public Resource<People> get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void patch(People entity) {
		// TODO Auto-generated method stub
		
	}

}
