package br.senaigo.mobile.controlller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.senaigo.mobile.entities.Order;
import br.senaigo.mobile.interfaces.GenericOperationsController;
import br.senaigo.mobile.service.OrderService;
/**
 * 
 * @author bruno
 *
 */
@RestController
@RequestMapping("/orders")
public class OrderController implements GenericOperationsController<Order> {
	
	/**
	 * @see http://appsdeveloperblog.com/spring-boot-logging-with-loggerfactory/
	 */
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	public OrderService orderService;
	
	@Override
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
				 produces = {MediaType.APPLICATION_JSON_VALUE,
						 	 MediaType.APPLICATION_XML_VALUE,
						 	 MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public Resource<Order> post(@RequestBody Order order) {
		try {
			orderService.post(order);
			logger.info("Registro inserido");
			
			Link link = linkTo(OrderController.class).slash(order.getIdOrder()).withSelfRel();
			Resource<Order> result = new Resource<Order>(order,link);
			return result;
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método POST.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}

	@Override
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void put(@RequestBody Order order) {
		try {
			orderService.put(order);
			logger.info(String.format("Registro atualizado: %s",order.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método PUT.\nMensagem: %s",e.getMessage()));
		}
	}

	@Override
	@DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody Order orders) {
		try {
			orderService.delete(orders);
			logger.info(String.format("Registro(s) deletado(s): %s",orders.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método PUT.\nMensagem: %s",e.getMessage()));
		}

	}

	@Override
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, 
							 MediaType.APPLICATION_XML_VALUE,
							 MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Resources<Order> get() {
		try {
			List<Order> orders = orderService.get();
			
			logger.info(String.format("Registro(s) recuperados(s): %s",orders.toString()));
			
			for (final Order order : orders) {
		        Link selfLink = linkTo(OrderController.class)
		        		.slash(order.getIdOrder())
		        		.withSelfRel();
		        
		        Link selfLinkPeople = linkTo(PeopleController.class)
		        		.slash(order.getPeople().getIdPeople())
		        		.withSelfRel();
		        
		        order.getPeople().add(selfLinkPeople);
		        order.add(selfLink);
		    }
			 Link link = linkTo(OrderController.class).withSelfRel();
			 Resources<Order> result = new Resources<Order>(orders, link);
			 return result;
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}

	@Override
	@GetMapping(value="/{id}",
				consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
	 			produces = {MediaType.APPLICATION_JSON_VALUE,
	 						MediaType.APPLICATION_XML_VALUE,
	 						MediaTypes.HAL_JSON_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public Resource<Order> get(@PathVariable("id") Long id) {
		try {
			Order order = orderService.get(Order.builder().idOrder(id).build());
			logger.info(String.format("Registro recuperado: %s",order.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método GET.\nMensagem: %s",e.getMessage()));
		}
		return null;
	}

	@Override
	@PatchMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void patch(@RequestBody Order order) {
		try {
			orderService.patch(order);
			logger.info(String.format("Registro atualizado: %s",order.toString()));
		} catch (Exception e) {
			logger.error(String.format("Erro ao executar o método PATCH.\nMensagem: %s",e.getMessage()));
		}

	}

}
