package net.moewes.odata.products;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataService;
import org.apache.olingo.server.api.ODataApplicationException;

@ODataService(value = "Products", entityType = "Product")
public class ProductService implements EntityCollectionProvider<Product>, EntityProvider<Product> {

    @Override
    public List<Product> getCollection() {

        Product p = new Product();
        p.setId(1);
        p.setName("Test Product");
        p.setDescription("Super duper Product");
        return Arrays.asList(p);
    }

    /*@Override
    public Optional<Product> find(String key) {

        Product p = new Product();
        p.setId(1);
        p.setName("Test Product");
        p.setDescription("Super duper Product");
        return Optional.ofNullable(p);
    }

     */

    @Override
    public Optional<Product> find(Map<String, String> keys) {
        return Optional.empty();
    }

    @Override
    public Product create(Object entity) throws ODataApplicationException {
        return null;
    }

    @Override
    public void update(Map<String, String> keys, Object entity) {

    }

    @Override
    public void delete(Map<String, String> keys) {

    }
}
