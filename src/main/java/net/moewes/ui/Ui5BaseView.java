package net.moewes.ui;

import javax.inject.Inject;

import net.moewes.cloudui.UiComponent;
import net.moewes.cloudui.html.Div;
import net.moewes.cloudui.quarkus.runtime.CloudUi;
import net.moewes.cloudui.ui5.Ui5Bar;
import net.moewes.cloudui.ui5.Ui5Label;
import net.moewes.cloudui.ui5.Ui5Page;

public abstract class Ui5BaseView extends Div {

    @Inject
    CloudUi ui;

    protected Ui5Page page = new Ui5Page();
    protected Div content = new Div();
    protected Ui5Bar bar = new Ui5Bar();

    public Ui5BaseView(String componentName) {

        super.add(page);
        getElement().setAttribute("style", "height: 100vh;");
        page.getElement().setAttribute("background-design", "Solid"); // FIXME

        page.add(content);
        content.getElement().setAttribute("style", "margin: 0.5rem;");

        bar.addMiddleContent(new Ui5Label(componentName));
        bar.getElement().setAttribute("slot", "header"); // FIXME
        page.add(bar);
    }

    @Override
    public void add(UiComponent component) {
        content.add(component);
    }
}
