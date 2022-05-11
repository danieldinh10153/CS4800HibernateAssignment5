package problem5_2a;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="office_number")
	private String office_number;
	
	@Column(name="research_area")
	private String research_area;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	public Professor() {
	}
	
	public Professor(String office_number, String research_area) {
		this.office_number = office_number;
		this.research_area = research_area;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setOfficeNumber(String office_number) {
		this.office_number = office_number;
	}
	
	public String getOfficeNumber()
	{
		return office_number;
	}
	
	public void setResearchArea(String research_area) {
		this.research_area = research_area;
	}
	
	public String getResearchArea(){
		return research_area;
	}
	
	public void  makeCustomer(Customer customer) {
		this.customer = customer;	
	}
}
