package ro.itschool.productmanagementapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.productmanagementapp.entity.WarehouseModel;
import ro.itschool.productmanagementapp.repository.WarehouseRepository;
import ro.itschool.productmanagementapp.service.exception.WarehouseNotFoundException;

import java.util.List;
import java.util.Optional;

@Component
public class WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<WarehouseModel> getWarehouses() {
        List<WarehouseModel> warehouseModels = warehouseRepository.findAll();
        return warehouseModels;
    }

    public void addWarehouse(WarehouseModel warehouseModel) {
        warehouseRepository.save(warehouseModel);
    }

    public void deleteWarehouse(int id) {
        warehouseRepository.deleteById(id);
    }

    public WarehouseModel getWarehouse(int id) throws WarehouseNotFoundException {
        Optional<WarehouseModel> warehouseModel = warehouseRepository.findById(id);
        if (warehouseModel.isEmpty()) {
            throw new WarehouseNotFoundException("There is no warehouse with the ID: " + id);
        }
        WarehouseModel warehouse = warehouseModel.get();
        return warehouse;
    }

    public void updateWarehouse(WarehouseModel oldWarehouseModel) throws WarehouseNotFoundException {
        WarehouseModel newWarehouseModel = getWarehouse(oldWarehouseModel.getRegistryNumber());
        newWarehouseModel.setCity(oldWarehouseModel.getCity());
        newWarehouseModel.setStreet(oldWarehouseModel.getStreet());
        warehouseRepository.save(newWarehouseModel);
    }
}
