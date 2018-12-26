package homeProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import homeProject.Car;
import homeProject.dao.BasicDao;
import homeProject.dao.CarDao;
import homeProject.service.CarService;

@Service
public class CarServiceImpl extends BasicServiceImpl<Car>implements CarService {
	@Autowired
	private CarDao cDao;

	@Override
	public BasicDao<Car> getMainDao() {

		return cDao;
	}

}
