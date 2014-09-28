package controllers;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.CarService;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: k.tagintsev
 * Date: 05.10.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Car> getCars(String search) {
        return carService.getCars(search);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ExtResult setCar(@RequestBody Car car) {
        return new ExtResult(carService.add(car), car);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCar(@RequestBody Car car) {
        carService.delete(car);
        return "delete";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateCar(@RequestBody Car car) {
        carService.update(car);
        return "update";
    }
}
