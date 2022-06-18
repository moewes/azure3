package net.moewes.odata.people;

import lombok.Data;
import net.moewes.quarkus.odata.annotations.EntityKey;
import net.moewes.quarkus.odata.annotations.ODataEntity;

@ODataEntity("Employee")
@Data
public class Employee {

    @EntityKey
    private String id;
    private String name;
    private String surname;
}
