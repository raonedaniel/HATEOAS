package br.senaigo.mobile.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlSeeAlso(People.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class People extends ResourceSupport {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	@XmlAttribute(name = "id")
	private Long idPeople;
	@XmlElement
	private String name;
	@XmlElement
	private String surName;
	@XmlElement
	private String email;
	
	@XmlElementRef(name="order",type=Order.class)
	@OneToMany(fetch=FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();
}
