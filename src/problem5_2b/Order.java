package problem5_2b;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name = "order_product",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
	)
	private List<Product> product;
	
	public Order() {
		
	}
	public void addProduct(Product p) {
		if(product == null) 
			product= new ArrayList<>();
		
		product.add(p);
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
	
	public void setProduct(List<Product> product)
	{
		this.product = product;
	}
	
	
}
