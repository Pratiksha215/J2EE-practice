package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity  //cls level annotations : Mandatory
@Table(name = "my_users")
public class User {

	private Integer userId; //int works(autoboxing) : As per Gavin King MUST be Serializable
	private String name,email,password;
	private double regAmount;
	private Date regDate;
	private Role userRole;
	private byte[] image;
	//MUST supply def arg-less constr.
	public User() {
		System.out.println("in user constr");
	}
	//add parameterized constr : optional
	public User(String name, String email, String password, double regAmount, Date regDate, Role userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.regDate = regDate;
		this.userRole = userRole;
	}
    //all setters & getters : MUST
	@Id //Mandatory : field level OR getter (property level) :PK constraint
	//for automatic ID generation
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //auto increment constraint
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length = 20,unique = true)//unique constraint 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="reg_amt")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Temporal(TemporalType.DATE)//DB col type=date
	@Column(name="reg_date")
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Enumerated(EnumType.STRING) //col type varchar (enum constant name)
	@Column(name="role",length = 20)
	public Role getUserRole() {
		return userRole;
	}
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	@Lob //large object , col type : blob(bin large obj)
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	//optional override toString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + ", userRole=" + userRole + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
