package com.estudoWeb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.estudoWeb.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	private Integer orderSatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User cliente;
	
	public Order() {
	}

	public Order(Long id, Instant moment,OrderStatus orderSatus, User cliente) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderSatus(orderSatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
		
	public OrderStatus getOrderSatus() {
		return OrderStatus.valueOf(orderSatus);
	}

	public void setOrderSatus(OrderStatus ordeStatus) {
		if(ordeStatus != null) {
		this.orderSatus = ordeStatus.getCode();
		}
	}

	public User getCliente() {
		return cliente;
	}

	public void setCliente(User cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
}
