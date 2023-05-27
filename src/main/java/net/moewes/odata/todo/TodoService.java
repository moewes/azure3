package net.moewes.odata.todo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import jakarta.inject.Inject;
import lombok.SneakyThrows;
import net.moewes.Dao;
import net.moewes.app.todo.Todo;
import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataEntitySet;
import org.apache.olingo.server.api.ODataApplicationException;

@ODataEntitySet(value = "Todos", entityType = "Todo")
public class TodoService implements EntityProvider<TodoOdataEntity>, EntityCollectionProvider<TodoOdataEntity> {

    @Inject
    Dao<Todo> dao;

    @Inject
    TodoMapper mapper;

    @SneakyThrows
    @Override
    public List<TodoOdataEntity> getCollection() {

        return dao.getAll().stream().map(item -> mapper.toOdata(item)).collect(Collectors.toList());
    }

    /*
    @Override
    public Optional<TodoOdataEntity> find(String key) {
        return Optional.empty();
    }
*/
    @Override
    public Optional<TodoOdataEntity> find(Map<String, String> keys) {
        return Optional.empty();
    }

    @Override
    public TodoOdataEntity create(Object entity) throws ODataApplicationException {
        return null;
    }

    @Override
    public void update(Map<String, String> keys, Object entity) {

    }

    @Override
    public void delete(Map<String, String> keys) {

    }
}
