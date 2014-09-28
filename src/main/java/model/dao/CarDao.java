package model.dao;

import model.Car;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 12:52
 * To change this template use File | Settings | File Templates.
 */
public interface CarDao {

    void add(Car car);

    void update(Car car);

    void delete(Car car);

    Collection<Car> getCars(String search);

    public List findByCar(String name, Long price);

}
