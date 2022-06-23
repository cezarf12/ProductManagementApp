package ro.itschool.productmanagementapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.itschool.productmanagementapp.entity.WarehouseModel;
import ro.itschool.productmanagementapp.service.WarehouseService;
import ro.itschool.productmanagementapp.service.exception.WarehouseNotFoundException;

import java.util.List;

@Controller
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("view-warehouses")
    public String viewWarehouses(Model model) {
        List<WarehouseModel> warehouseList = warehouseService.getWarehouses();
        model.addAttribute("warehouses", warehouseList);
        return "index";
    }

    @GetMapping("addWarehouses")
    public String addWarehouses(Model model) {
        model.addAttribute("warehouse", new WarehouseModel());
        return "add-warehouses";
    }

    @PostMapping("add-new-warehouse")
    public String addNewWarehouse(WarehouseModel warehouseModel) {
        warehouseService.addWarehouse(warehouseModel);
        return "redirect:/view-warehouses";
    }

    @GetMapping("delete-warehouse/{id}")
    public String deleteWarehouse(@PathVariable("id") int id) {
        warehouseService.deleteWarehouse(id);
        return "redirect:/view-warehouses";
    }

    @GetMapping("edit-warehouse-page/{id}")
    public String editWarehousePage(@PathVariable("id") int id, Model model) throws WarehouseNotFoundException {
        WarehouseModel warehouseModel = warehouseService.getWarehouse(id);
        model.addAttribute("warehouse", warehouseModel);
        return "edit-warehouses";
    }

    @PostMapping("edit-warehouse")
    public String editWarehouse(WarehouseModel warehouseModel) throws WarehouseNotFoundException {
        warehouseService.updateWarehouse(warehouseModel);
        return "redirect:/view-warehouses";
    }


}