package kr.co.mocha.eatgo.application;

import kr.co.mocha.eatgo.domain.MenuItem;
import kr.co.mocha.eatgo.domain.MenuItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuItemServiceTests {

    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    public void bulkUpdate() {
        List<MenuItem> menuitems = new ArrayList<>();

        menuitems.add(MenuItem.builder().name("Kimchi").build());
        menuitems.add(MenuItem.builder().name("Gukbob").build());

        menuItemService.bulkUpdate(1L, menuitems);

        verify(menuItemRepository, times(2)).save(any());
    }
}