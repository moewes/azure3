package net.moewes.odata.products;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataService;

@ODataService(value = "Products", entityType = "Product")
public class ProductService implements EntityCollectionProvider<Product>, EntityProvider<Product, Integer> {

    @Override
    public List<Product> getCollection() {

        Product p = new Product();
        p.setId(1);
        p.setName("Test Product");
        p.setDescription("Super duper Product");
        return Arrays.asList(p);
    }

    @Override
    public Optional<Product> find(String key) {

        Product p = new Product();
        p.setId(1);
        p.setName("Test Product");
        p.setDescription("Super duper Product");
        return Optional.ofNullable(p);
    }
}
