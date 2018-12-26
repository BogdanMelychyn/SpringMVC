package homeProject;

import javax.persistence.*;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carId;
	@Column
	private String carNumber;
	@Column
	private String carBrand;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id")
	private Driver driver;

	public Car() {
	}

	public Car(String carNumber, String carBrand) {
		
		this.carNumber = carNumber;
		this.carBrand = carBrand;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	
	public Driver getDriver() {
		return driver;
	}
	/**
	   * Set new driver for car. 
	   * The method keeps relationships consistency:
	   * * this car is removed from the previous driver
	   * * this car is added to next driver
	   * 
	   * @param driver
	   */
	public void setDriver(Driver newDriver) {
		if (checkDriver(newDriver)) 
			return;
		Driver oldDriver = this.driver;
		this.driver = newDriver;
		
		if (oldDriver!=null) 
			oldDriver.removeCar(this);
		
		if (newDriver!=null)
			newDriver.addCar(this);
	}
	
	
	private boolean checkDriver(Driver newDriver){
	return driver == null ? newDriver == null : driver.equals(newDriver);
	
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carNumber=" + carNumber + ", carBrand=" + carBrand + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
		result = prime * result + ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result + ((driver == null) ? 0 : driver.hashCode());
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
		Car other = (Car) obj;
		if (carBrand == null) {
			if (other.carBrand != null)
				return false;
		} else if (!carBrand.equals(other.carBrand))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (driver == null) {
			if (other.driver != null)
				return false;
		} else if (!driver.equals(other.driver))
			return false;
		return true;
	}

	

}
