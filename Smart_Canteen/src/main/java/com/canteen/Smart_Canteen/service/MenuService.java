package com.canteen.Smart_Canteen.service;

import com.canteen.Smart_Canteen.model.Menu;
import com.canteen.Smart_Canteen.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAllAvailable() {
        return menuRepository.findByAvailableTrue();
    }

    // You might want a method to get all menu items
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
}