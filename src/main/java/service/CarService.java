/*
 * (c) КАЦИТ, 2013. Все права защищены.
 */
package service;

import model.Car;

import java.util.Collection;

/**
 * @author Константин Тагинцев
 * @created 09.07.13 17:58
 */

public interface CarService {

    Boolean add(Car car);

    void update(Car car);

    Collection<Car> getCars(String search);

    void delete(Car car);

}
