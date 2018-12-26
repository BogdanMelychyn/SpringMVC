package homeProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import homeProject.Driver;
import homeProject.dao.BasicDao;
import homeProject.dao.DriverDao;
import homeProject.service.DriverService;


@Service
public class DriverServiceImpl extends BasicServiceImpl<Driver>implements DriverService {
	@Autowired
	private DriverDao dDao;

	@Override
	public BasicDao<Driver> getMainDao() {
		return dDao;
	}

}
