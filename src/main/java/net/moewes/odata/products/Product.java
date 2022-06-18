package net.moewes.odata.products;

import lombok.Data;
import net.moewes.quarkus.odata.annotations.EntityKey;
import net.moewes.quarkus.odata.annotations.ODataEntity;

@ODataEntity("Product")
@Data
public class Product {

    @EntityKey
    private int id;
    private String name;
    private String Description;
}
