package kr.co.mocha.eatgo.interfaces;

import kr.co.mocha.eatgo.domain.Restaurant;
import kr.co.mocha.eatgo.domain.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantRepository restaurantRepository = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    @GetMapping("restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        return restaurant;
    }
}
