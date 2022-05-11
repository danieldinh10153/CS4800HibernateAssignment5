package problem5_2a;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	public Customer() {
	}
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
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
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	//example had Override to String for the date, but ig not needed?
}	
