package br.senaigo.mobile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senaigo.mobile.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
