package net.moewes.ui.util;

import net.moewes.cloudui.UiComponent;
import net.moewes.cloudui.html.Div;

public class FormLayout extends Div {

    static private final String FORM_PAGE_STYLE =
            "display: flex;" +
                    "justify-content: center;";

    static private final String FORM_CONTAINER_STYLE =
            "width: 1000px";

    static private final String FORMITEM_CONTAINER_STYLE = "" +
            "display: flex; " +
            "flex-wrap: wrap; " +
            "align-items: center; " +
            "overflow: hidden;" +
            "margin: 0.5rem;";
    static private final String LABEL_CONTAINER_STYLE = "" +
            "padding-right: 2rem;" +
            "min-width: 25%;" +
            "width: calc((25em - 100%) * 1000);" +
            "max-width: 50%;";
    static private final String FIELD_CONTAINER_STYLE = "" +
            "padding-right: 1rem;" +
            "padding-left: 0rem;" +
            "width: 65%;" +
            "min-width: 290px;" +
            "max-width: 100%;" +
            "";

    private Div formContainer = new Div();
    private Div container = new Div();

    public FormLayout() {
        super();
        init();
    }

    private void init() {
        super.add(container);
        container.add(formContainer);
        container.getElement().setAttribute("style", FORM_PAGE_STYLE);
        formContainer.getElement().setAttribute("style", FORM_CONTAINER_STYLE);
    }

    @Override
    public void add(UiComponent component) {
        formContainer.add(component);
    }

    public void addFormItem(UiComponent label, UiComponent field) {
        Div formItem = new Div();
        formItem.getElement().setAttribute("style", FORMITEM_CONTAINER_STYLE);
        Div labelContainer = new Div();
        labelContainer.getElement().setAttribute("style", LABEL_CONTAINER_STYLE);
        Div fieldContainer = new Div();
        fieldContainer.getElement().setAttribute("style", FIELD_CONTAINER_STYLE);

        labelContainer.add(label);
        fieldContainer.add(field);

        add(formItem);
        formItem.add(labelContainer);
        formItem.add(fieldContainer);
    }
}
