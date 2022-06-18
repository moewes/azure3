package net.moewes.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import lombok.SneakyThrows;
import net.moewes.app.todo.TodoListView;
import net.moewes.cloudui.annotations.CloudUiView;
import net.moewes.cloudui.html.Div;
import net.moewes.cloudui.quarkus.runtime.CloudUi;
import net.moewes.cloudui.ui5.Ui5Title;

@CloudUiView("/")
public class MyView extends Ui5BaseView {

    private static final String FC_ROW_STYLE = "   font-size: .875rem;\n" +
            "    font-size: var(--sapFontSize, .875rem);\n" +
            "    line-height: 1.4;\n" +
            "    line-height: var(--sapContent_LineHeight, 1.4);\n" +
            "    color: #32363a;\n" +
            "    color: var(--sapTextColor, #32363a);\n" +
            "    font-family: \"72\", \"72full\", Arial, Helvetica, sans-serif;\n" +
            "    font-family: var(--sapFontFamily, \"72\", \"72full\", Arial, Helvetica, sans-serif);\n" +
            "    font-weight: 400;\n" +
            "    -webkit-box-sizing: border-box;\n" +
            "    box-sizing: border-box;\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "    border: 0;\n" +
            "    display: -webkit-box;\n" +
            "    display: -ms-flexbox;\n" +
            "    display: flex;\n" +
            "    -ms-flex-wrap: wrap;\n" +
            "    flex-wrap: wrap;\n" +
            "    -webkit-box-flex: 0;\n" +
            "    -ms-flex: 0 0 100%;\n" +
            "    flex: 0 0 100%;\n" +
            "    position: relative;\n" +
            "    margin: 0 -.25rem;\n" +
            "    min-width: 100%";

    private static final String FD_CONTAINER_STYLE = "  font-size: .875rem;\n" +
            "    font-size: var(--sapFontSize, .875rem);\n" +
            "    line-height: 1.4;\n" +
            "    line-height: var(--sapContent_LineHeight, 1.4);\n" +
            "    color: #32363a;\n" +
            "    color: var(--sapTextColor, #32363a);\n" +
            "    font-family: \"72\", \"72full\", Arial, Helvetica, sans-serif;\n" +
            "    font-family: var(--sapFontFamily, \"72\", \"72full\", Arial, Helvetica, sans-serif);\n" +
            "    font-weight: 400;\n" +
            "    -webkit-box-sizing: border-box;\n" +
            "    box-sizing: border-box;\n" +
            "    padding: 0;\n" +
            "    margin: 0;\n" +
            "    border: 0;\n" +
            "    display: -webkit-box;\n" +
            "    display: -ms-flexbox;\n" +
            "    display: flex;\n" +
            "    -ms-flex-wrap: wrap;\n" +
            "    flex-wrap: wrap;\n" +
            "    -webkit-box-flex: 0;\n" +
            "    -ms-flex: 0 0 100%;\n" +
            "    flex: 0 0 100%;\n" +
            "    position: relative;\n" +
            "    margin: 0 -.25rem 0 -.25rem";

    @Inject
    CloudUi ui;

    public MyView() {
        super("Home");
    }

    @SneakyThrows
    @PostConstruct
    public void createView() {
        add(new Ui5Title("Hello Ui5 web components"));

        content.getElement().setAttribute("style", FD_CONTAINER_STYLE);

        Div row = new Div();
        row.getElement().setAttribute("style", FC_ROW_STYLE);
        add(row);

        /*
        Ui5Table<MyEntity> table = new Ui5Table<>();
        add(table);

        table.addColumn("Name", MyEntity::getName);
        table.addColumn("Surname", MyEntity::getSurname);

        table.setItems(
                newDao.getAll());

         */
        Tile aTile = new Tile();
        aTile.addEventListener("click", event -> {
            ui.navigate(TodoListView.class);
        });
        row.add(aTile);
        row.add(aTile);
        row.add(aTile);
    }
}
