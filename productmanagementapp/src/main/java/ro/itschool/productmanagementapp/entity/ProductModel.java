package ro.itschool.productmanagementapp.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProductModel {

    @Id
    private int labelNumber;
    private String name;
    private String producer;
    private String description;
    private int quantity;

    @ManyToOne
    private WarehouseModel warehouse;

    public int getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(int labelNumber) {
        this.labelNumber = labelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public WarehouseModel getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseModel warehouse) {
        this.warehouse = warehouse;
    }
}