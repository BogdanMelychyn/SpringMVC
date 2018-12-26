package homeProject;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String name;

	@Column
	private int age;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "driver")
	private List<Car> listCars = new ArrayList<Car>();

	@Column
	private String email;

	public Driver() {
	}

	public Driver(String name, int age, String email) {
	
		this.name = name;
		this.age = age;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Car> getCars() {
		return new ArrayList<Car>(listCars);
	}
	
	public void setListCars(List<Car> cars) {
		this.listCars = cars;
	}

	public void addCar(Car car) {
		if (listCars.contains(car))
			return;
		listCars.add(car);
		car.setDriver(this);
			
	}
	
	public void removeCar(Car car) {
		if (!listCars.contains(car))
			return;
		listCars.remove(car);
		car.setDriver(null);
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((listCars == null) ? 0 : listCars.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (age != other.age)
			return false;
		if (listCars == null) {
			if (other.listCars != null)
				return false;
		} else if (!listCars.equals(other.listCars))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
