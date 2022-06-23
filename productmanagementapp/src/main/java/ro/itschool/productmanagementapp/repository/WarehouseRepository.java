package ro.itschool.productmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.productmanagementapp.entity.WarehouseModel;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseModel, Integer> {

}