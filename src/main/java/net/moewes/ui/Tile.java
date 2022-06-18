package net.moewes.ui;

import net.moewes.cloudui.UiElement;
import net.moewes.cloudui.html.Div;

public class Tile extends Div {

    private static String FD_TILE_STYLE = " font-size: .875rem;\n" +
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
            "    margin: .5rem .25rem 0 .25rem;\n" +
            "    border: 0;\n" +
            "    height: 11rem;\n" +
            "    min-height: 11rem;\n" +
            "    max-height: 11rem;\n" +
            "    width: 11rem;\n" +
            "    min-width: 11rem;\n" +
            "    max-width: 11rem;\n" +
            "    position: relative;\n" +
            "    padding: .9375rem;\n" +
            "    background: #fff;\n" +
            "    background: var(--sapTile_Background, #fff);\n" +
            "    -webkit-box-shadow: 0 0 0 .0625rem rgba(0, 0, 0, .1), 0 .125rem .5rem 0 rgba(0, 0, 0, .1);\n" +
            "    -webkit-box-shadow: var(--sapContent_Shadow0, 0 0 0 .0625rem rgba(0, 0, 0, .1), 0 .125rem .5rem 0 rgba(0, 0, 0, .1));\n" +
            "    box-shadow: 0 0 0 .0625rem rgba(0, 0, 0, .1), 0 .125rem .5rem 0 rgba(0, 0, 0, .1);\n" +
            "    box-shadow: var(--sapContent_Shadow0, 0 0 0 .0625rem rgba(0, 0, 0, .1), 0 .125rem .5rem 0 rgba(0, 0, 0, .1));\n" +
            "    border-radius: .25rem;\n" +
            "    border-radius: var(--sapElement_BorderCornerRadius, .25rem);\n" +
            "    border: .0625rem solid transparent;\n" +
            "    border: .0625rem solid var(--sapTile_BorderColor, transparent);\n" +
            "    cursor: pointer";

    private static String FD_TILE_ITEM_STYLE = " font-size: .875rem;\n" +
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
            "    overflow: hidden;";

    private static String FD_TILE_HEADER_STYLE = FD_TILE_ITEM_STYLE + "    height: 3.625rem;\n" +
            "    min-height: 3.625rem;\n" +
            "    max-height: 3.625rem;\n" +
            "    margin-bottom: .25rem";

    private static String FD_TILE_CONTENT_STYLE = FD_TILE_ITEM_STYLE + "  height: 3.875rem;\n" +
            "    min-height: 3.875rem;\n" +
            "    max-height: 3.875rem;\n" +
            "    margin-bottom: .25rem";

    private static String FD_TILE_FOOTER_STYLE = FD_TILE_ITEM_STYLE + " height: 1rem;\n" +
            "    min-height: 1rem;\n" +
            "    max-height: 1rem;\n" +
            "    display: -webkit-box;\n" +
            "    display: -ms-flexbox;\n" +
            "    display: flex";

    private Div header = new Div();
    private Div content = new Div();
    private Div footer = new Div();

    public Tile() {

        getElement().setAttribute("role", "button");
        getElement().setAttribute("style", FD_TILE_STYLE);

        header.getElement().setAttribute("style", FD_TILE_HEADER_STYLE);
        content.getElement().setAttribute("style", FD_TILE_CONTENT_STYLE);
        footer.getElement().setAttribute("style", FD_TILE_FOOTER_STYLE);

        add(header);
        add(content);
        add(footer);
    }

    @Override
    public UiElement render() {

        header.setInnerHtml("Header");
        content.setInnerHtml("Content");
        footer.setInnerHtml("Footer");

        return super.render();
    }
}
