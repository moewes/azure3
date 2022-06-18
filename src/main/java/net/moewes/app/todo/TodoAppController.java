package net.moewes.app.todo;

import javax.enterprise.context.RequestScoped;

import lombok.Getter;
import lombok.Setter;

@RequestScoped
public class TodoAppController {

    @Getter
    @Setter
    private Todo item = new Todo();
}
