package kr.co.mocha.eatgo.interfaces;

import kr.co.mocha.eatgo.application.MenuItemService;
import kr.co.mocha.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable ("restaurantId") Long restaurantId, @RequestBody List<MenuItem> menuItems) {

        menuItemService.bulkUpdate(restaurantId, menuItems);

        return "";
    }

    @DeleteMapping("/restaurants/{restaurantId}/menuitems")
    public String DeleteAllMenuItem(@PathVariable ("restaurantId") Long restaurantId) {
        menuItemService.deleteAllMenuItems(restaurantId);
        return "";
    }
}
