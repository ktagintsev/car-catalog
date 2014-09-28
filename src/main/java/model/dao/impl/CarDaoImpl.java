package model.dao.impl;

import model.Car;
import model.dao.CarDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
public class CarDaoImpl implements CarDao {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public void add(Car car) {
        emf.persist(car);
    }

    @Override
    public void update(Car car) {
        emf.merge(car);
    }

    @Override
    public void delete(Car car) {
        emf.remove(emf.getReference(Car.class, car.getId()));
    }

    @Override
    public Collection<Car> getCars(String search) {
        if (null == search || search.trim().isEmpty()) {
            return emf.createQuery(
                    "select c from Car c")
                    .getResultList();
        }
        return emf.createQuery(
                "select c from Car c where c.name like :search")
                .setParameter("search", search.trim() + "%")
                .getResultList();
    }

    public List<Car> findByCar(String name, Long price) {
        return emf.createQuery(
                "select c from Car c where c.name = :name and c.price = :price")
                .setParameter("name", name)
                .setParameter("price", price)
                .getResultList();
    }
}
