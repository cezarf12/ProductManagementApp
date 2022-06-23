package ro.itschool.productmanagementapp.service.exception;

public class WarehouseNotFoundException extends Exception {
    public WarehouseNotFoundException(String message) {
        super(message);
    }
}