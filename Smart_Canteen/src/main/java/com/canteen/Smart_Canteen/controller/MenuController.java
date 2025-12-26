package com.canteen.Smart_Canteen.controller;

import com.canteen.Smart_Canteen.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final MenuService menuService;

    // Spring Boot automatically injects MenuService via constructor
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * Maps requests to the root URL (http://localhost:8080/) and /index.
     * It loads all available menu items and passes them to the index.html template.
     */
    @GetMapping({"/", "/index"})
    public String viewMenu(Model model) {
        // Adds a list of Menu objects to the model under the name "menuItems"
        model.addAttribute("menuItems", menuService.findAllAvailable());

        // Tells Spring to render src/main/resources/templates/index.html
        return "index";
    }
}