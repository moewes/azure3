package net.moewes.odata.people;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataService;
import org.apache.olingo.server.api.ODataApplicationException;

@ODataService(value = "Employees", entityType = "Employee")
public class EmployeesService implements EntityCollectionProvider<Employee>, EntityProvider<Employee> {

    public List<Employee> getEmployees() {

        List<Employee> result = new ArrayList<>();

        Employee e1 = new Employee();
        e1.setName("Test");
        e1.setSurname("Hans");
        e1.setId("k1");
        result.add(e1);

        Employee e2 = new Employee();
        e2.setId("k2");
        e2.setName("Palme");
        e2.setSurname("Olov");
        result.add(e2);

        return result;
    }

    @Override
    public List<Employee> getCollection() {
        return getEmployees();
    }

   /* @Override
    public Optional<Employee> find(String key) {

        Employee e2 = new Employee();
        e2.setId(key);
        e2.setName("Palme");
        e2.setSurname("Olov");

        return Optional.ofNullable(e2);
    }

    */

    @Override
    public Optional<Employee> find(Map<String, String> keys) {
        return Optional.empty();
    }

    @Override
    public Employee create(Object entity) throws ODataApplicationException {
        return null;
    }

    @Override
    public void update(Map<String, String> keys, Object entity) {

    }

    @Override
    public void delete(Map<String, String> keys) {

    }
}
