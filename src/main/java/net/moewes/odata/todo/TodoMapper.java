package net.moewes.odata.todo;

import net.moewes.app.todo.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface TodoMapper {

    TodoOdataEntity toOdata(Todo entity);
}
