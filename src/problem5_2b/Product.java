package problem5_2b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name = "order_product",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
	)
	private List<Order> order;
	
	public Product() {
		
	}
	
	public Product(String name)
	{
		this.name = name;
	}
	public void addOrder(Order o) {
		if(order == null) 
			order = new ArrayList<>();
		
		order.add(o);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setOrder(List<Order> order)
	{
		this.order = order;
	}
	
}