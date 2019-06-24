package br.senaigo.mobile.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
@XmlSeeAlso(Product.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Product extends ResourceSupport {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	@XmlAttribute(name = "id")
	private Integer idProduct;
	@XmlElement
	private String name;
	@XmlElement
	private String description;
	@XmlElement
	private BigDecimal value;
}
