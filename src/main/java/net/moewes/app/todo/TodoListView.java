package net.moewes.app.todo;

import java.net.URISyntaxException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.microsoft.azure.storage.StorageException;
import lombok.SneakyThrows;
import net.moewes.Dao;
import net.moewes.cloudui.annotations.CloudUiView;
import net.moewes.cloudui.quarkus.runtime.CloudUi;
import net.moewes.cloudui.ui5.Ui5Button;
import net.moewes.cloudui.ui5.table.Ui5Table;
import net.moewes.ui.MyView;
import net.moewes.ui.Ui5BaseView;

@CloudUiView("/todos")
public class TodoListView extends Ui5BaseView {

    @Inject
    Dao<Todo> dao;

    @Inject
    CloudUi ui;

    @Inject
    TodoAppController appController;

    public TodoListView() {
        super("All Todos");
    }

    private static String getItemId(Todo item) {
        return item.getPartitionKey() + "_" + item.getRowKey();
    }

    @SneakyThrows
    @PostConstruct
    public void createContent() {

        page.getElement().setAttribute("background", "List"); // FIXME

        Ui5Table<Todo> table = new Ui5Table<>();

        add(table);

        table.addColumn("Description", Todo::getDescription);
        table.setItems(dao.getAll());
        table.setIdGetter(TodoListView::getItemId);
        table.addEventListener("row-click", uiEvent -> {
            uiEvent.getParameter("row").ifPresent(parameter -> {
                String[] strings = parameter.toString().split("_");
                try {
                    Todo todo = dao.get(strings[0], strings[1]);
                    appController.setItem(todo);
                    ui.navigate(TodoEditView.class);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (StorageException e) {
                    e.printStackTrace();
                }
            });
        });

        Ui5Button newButton = new Ui5Button();
        newButton.setIcon("add-document");
        newButton.setDesign(Ui5Button.Design.DEFAULT);
        newButton.addEventListener("click", event -> {
            ui.navigate(TodoEditView.class);
        });
        bar.addEndContent(newButton);

        Ui5Button homeButton = new Ui5Button();
        homeButton.setIcon("home");
        homeButton.setDesign(Ui5Button.Design.TRANSPARENT);
        homeButton.addEventListener("click", event -> {
            appController.setItem(new Todo());
            ui.navigate(MyView.class);
        });
        bar.addStartContent(homeButton);
    }
}
