package service.impl;

import model.Car;
import model.dao.CarDao;
import org.springframework.transaction.annotation.Transactional;
import service.CarService;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarDao getCarDao() {
        return carDao;
    }

    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public Boolean add(Car car) {
        List<Car> duplicate = carDao.findByCar(car.getName(), car.getPrice());
        if (duplicate.isEmpty()) {
            carDao.add(car);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void update(Car car) {
        carDao.update(car);
    }

    @Transactional
    @Override
    public Collection<Car> getCars(String search) {
        return carDao.getCars(search);
    }

    @Transactional
    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }

}
