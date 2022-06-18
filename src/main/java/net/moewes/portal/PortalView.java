package net.moewes.portal;

import javax.annotation.PostConstruct;

import net.moewes.cloudui.UiComponent;
import net.moewes.cloudui.annotations.CloudUiView;
import net.moewes.cloudui.annotations.JavaScript;
import net.moewes.cloudui.annotations.StyleSheet;
import net.moewes.cloudui.html.Div;
import net.moewes.cloudui.ui5.Ui5Title;

@CloudUiView("/portal")
@JavaScript( value = "https://ui5.sap.com/resources/sap-ui-integration.js", id = "sap-ui-bootstrap")
//@StyleSheet("meine/styles.css")
//@StyleSheet("noch/ein.sttyle.css")
public class PortalView extends Div {

    @PostConstruct
    public void createView() {

        add(new Ui5Title("Hello World"));
/*
        UiComponent script = new UiComponent("script");
        script.getElement().setAttribute("id","sap-ui-bootstrap");
        script.getElement().setAttribute("src","https://ui5.sap.com/resources/sap-ui-integration.js");
        add(script);
*/
        UiComponent card = new UiComponent("ui-integration-card");
        card.getElement().setAttribute("manifest","./manifest.json");
  //      card.getElement().setAttribute("base-url","./portal");

        add(card);
    }
}
