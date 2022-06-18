package net.moewes.odata.todo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import lombok.SneakyThrows;
import net.moewes.Dao;
import net.moewes.app.todo.Todo;
import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataService;

@ODataService(value = "Todos", entityType = "Todo")
public class TodoService implements EntityProvider<TodoOdataEntity, String>, EntityCollectionProvider<TodoOdataEntity> {

    @Inject
    Dao<Todo> dao;

    @Inject
    TodoMapper mapper;

    @SneakyThrows
    @Override
    public List<TodoOdataEntity> getCollection() {

        return dao.getAll().stream().map(item -> mapper.toOdata(item)).collect(Collectors.toList());
    }

    @Override
    public Optional<TodoOdataEntity> find(String key) {
        return Optional.empty();
    }
}
