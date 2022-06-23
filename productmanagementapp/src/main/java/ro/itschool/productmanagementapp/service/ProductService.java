package ro.itschool.productmanagementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.itschool.productmanagementapp.entity.ProductModel;
import ro.itschool.productmanagementapp.repository.ProductRepository;
import ro.itschool.productmanagementapp.service.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getProducts() {
        List<ProductModel> productModels = productRepository.findAll();
        return productModels;
    }

    public void addProduct(ProductModel product) {
        productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public ProductModel getProduct(int id) throws ProductNotFoundException {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isEmpty()) {
            throw new ProductNotFoundException("There is no warehouse with the ID: " + id);
        }
        ProductModel product = productModel.get();
        return product;
    }

    public void updateProduct(ProductModel oldProductModel) throws ProductNotFoundException {
        ProductModel newProductModel = getProduct(oldProductModel.getLabelNumber());
        newProductModel.setName(oldProductModel.getName());
        newProductModel.setProducer(oldProductModel.getProducer());
        newProductModel.setDescription(oldProductModel.getDescription());
        newProductModel.setQuantity(oldProductModel.getQuantity());
        newProductModel.setWarehouse(oldProductModel.getWarehouse());
        productRepository.save(newProductModel);
    }

    public List<ProductModel> searchProductByName(String name) throws ProductNotFoundException {
        List<ProductModel> productModels = productRepository.findAll();
        List<ProductModel> productFound = new ArrayList<>();
        for (ProductModel product : productModels) {
            if (product.getName().equals(name)) {
                productFound.add(product);
            }
        }
        if (productFound.isEmpty()) {
            throw new ProductNotFoundException("Product with this name " + name + " cannot be found");
        }
        return productFound;
    }

}