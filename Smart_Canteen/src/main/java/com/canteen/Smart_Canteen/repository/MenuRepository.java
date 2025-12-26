package com.canteen.Smart_Canteen.repository;

import com.canteen.Smart_Canteen.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository provides CRUD methods automatically for the Menu entity
public interface MenuRepository extends JpaRepository<Menu, Long> {

    // Custom query method to fetch items where 'available' is true
    List<Menu> findByAvailableTrue();
}