package net.moewes.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import lombok.SneakyThrows;
import net.moewes.cloudui.annotations.CloudUiView;
import net.moewes.cloudui.html.Div;
import net.moewes.cloudui.quarkus.runtime.CloudUi;
import net.moewes.cloudui.ui5.Ui5Input;
import net.moewes.cloudui.ui5.Ui5Label;

@CloudUiView("/form")
public class FormView extends Ui5BaseView {

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
            "    min-width: 100%;";

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

    static private final String FORM_PAGE_STYLE = "" +
            "display: flex;\n" +
            "  justify-content: center;" +
            //"position: absolute;\n" +
            // "    top: 50%;\n" +
            //"    left: 50%;\n" +
            //"    margin-top: -50px;\n" +
            //"    margin-left: -50px;\n" +
            //   "    max-width: 1000px;\n" +
            "   ";

    static private final String FORM_CONTAINER_STYLE = "" +
            // "display: flex;\n" +
            //  "  align-items: center;" +
            //"position: absolute;\n" +
            // "    top: 50%;\n" +
            //"    left: 50%;\n" +
            //"    margin-top: -50px;\n" +
            //"    margin-left: -50px;\n" +
            "    width: 1000px;\n" +
            "   ";

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
            //"width: 60%;" +
            // "transform: translateX(-1rem)";
            "min-width: 290px;" +
            //"width: calc((25em - 100%) * 1000);" +
            "max-width: 100%;" +
            "";
    @Inject
    CloudUi ui;

    public FormView() {
        super("Form Playground");
    }

    @SneakyThrows
    @PostConstruct
    public void createView() {

        Div container = new Div();
        container.getElement().setAttribute("style", FORM_PAGE_STYLE);

        Div formContainer = new Div();
        formContainer.getElement().setAttribute("style", FORM_CONTAINER_STYLE);
        Div formItem = new Div();
        formItem.getElement().setAttribute("style", FORMITEM_CONTAINER_STYLE);
        Div labelContainer = new Div();
        labelContainer.getElement().setAttribute("style", LABEL_CONTAINER_STYLE);
        Div fieldContainer = new Div();
        fieldContainer.getElement().setAttribute("style", FIELD_CONTAINER_STYLE);
        Div formItem2 = new Div();
        formItem2.getElement().setAttribute("style", FORMITEM_CONTAINER_STYLE);
        Div labelContainer2 = new Div();
        labelContainer2.getElement().setAttribute("style", LABEL_CONTAINER_STYLE);
        Div fieldContainer2 = new Div();
        fieldContainer2.getElement().setAttribute("style", FIELD_CONTAINER_STYLE);

        add(container);
        container.add(formContainer);
        formContainer.add(formItem);
        formItem.add(labelContainer);
        formItem.add(fieldContainer);
        Ui5Label label = new Ui5Label("Label");
        //label.getElement().setAttribute("style", "float: right;");
        labelContainer.add(label);
        Ui5Input i1 = new Ui5Input();
        i1.getElement().setAttribute("style", "width: 75%;");
        Ui5Input i2 = new Ui5Input();
        i2.getElement().setAttribute("style", "width: 25%;");
        fieldContainer.add(i1);

        formContainer.add(formItem2);
        formItem2.add(labelContainer2);
        formItem2.add(fieldContainer2);
        labelContainer2.add(new Ui5Label("Other Label"));
        Ui5Input input2 = new Ui5Input();
        input2.getElement().setAttribute("style", "width: 100%;");
        fieldContainer2.add(input2);
    }
}
