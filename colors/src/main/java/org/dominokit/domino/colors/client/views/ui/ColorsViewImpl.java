package org.dominokit.domino.colors.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.colors.client.presenters.ColorsProxy;
import org.dominokit.domino.colors.client.views.ColorsView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;

@UiView(presentable = ColorsProxy.class)
public class ColorsViewImpl extends BaseDemoView<HTMLDivElement> implements ColorsView {

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("colors", this.getClass()).element());
        element.appendChild(BlockHeader.create("COLORS").element());

        element.appendChild(Card.create("MATERIAL DESIGN COLORS", "Taken by Google's Material Design Color page which link is ")
                .appendDescriptionChild(a()
                        .attr("href", "https://material.google.com/style/color.html#color-color-palette")
                        .textContent("material.google.com/style/color.html#color-color-palette")
                        .title("Google's Material Design Color"))
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.RED.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.RED.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.RED.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.RED.darker_1()))
                                .appendChild(makeColorBox(Color.RED))
                                .appendChild(makeColorBox(ColorScheme.RED.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.RED.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.RED.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.RED.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.RED.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.PINK.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.PINK.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.PINK.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.PINK.darker_1()))
                                .appendChild(makeColorBox(Color.PINK))
                                .appendChild(makeColorBox(ColorScheme.PINK.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.PINK.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.PINK.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.PINK.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.PINK.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.PURPLE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.darker_1()))
                                .appendChild(makeColorBox(Color.PURPLE))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.PURPLE.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.darker_1()))
                                .appendChild(makeColorBox(Color.DEEP_PURPLE))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_PURPLE.lighten_5()))
                        )

                        .element())
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.INDIGO.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.darker_1()))
                                .appendChild(makeColorBox(Color.INDIGO))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.INDIGO.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.BLUE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.darker_1()))
                                .appendChild(makeColorBox(Color.BLUE))
                                .appendChild(makeColorBox(ColorScheme.BLUE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.BLUE.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.darker_1()))
                                .appendChild(makeColorBox(Color.LIGHT_BLUE))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_BLUE.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.CYAN.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.darker_1()))
                                .appendChild(makeColorBox(Color.CYAN))
                                .appendChild(makeColorBox(ColorScheme.CYAN.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.CYAN.lighten_5()))
                        )
                        .element())
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.TEAL.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.darker_1()))
                                .appendChild(makeColorBox(Color.TEAL))
                                .appendChild(makeColorBox(ColorScheme.TEAL.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.TEAL.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.GREEN.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.darker_1()))
                                .appendChild(makeColorBox(Color.GREEN))
                                .appendChild(makeColorBox(ColorScheme.GREEN.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.GREEN.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.darker_1()))
                                .appendChild(makeColorBox(Color.LIGHT_GREEN))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.LIGHT_GREEN.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.LIME.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.LIME.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.LIME.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.LIME.darker_1()))
                                .appendChild(makeColorBox(Color.LIME))
                                .appendChild(makeColorBox(ColorScheme.LIME.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.LIME.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.LIME.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.LIME.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.LIME.lighten_5()))
                        )
                        .element())
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.YELLOW.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.darker_1()))
                                .appendChild(makeColorBox(Color.YELLOW))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.YELLOW.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.AMBER.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.darker_1()))
                                .appendChild(makeColorBox(Color.AMBER))
                                .appendChild(makeColorBox(ColorScheme.AMBER.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.AMBER.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.ORANGE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.darker_1()))
                                .appendChild(makeColorBox(Color.ORANGE))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.ORANGE.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.darker_1()))
                                .appendChild(makeColorBox(Color.DEEP_ORANGE))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.DEEP_ORANGE.lighten_5()))
                        )
                        .element())
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.BROWN.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.darker_1()))
                                .appendChild(makeColorBox(Color.BROWN))
                                .appendChild(makeColorBox(ColorScheme.BROWN.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.BROWN.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.GREY.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.GREY.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.GREY.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.GREY.darker_1()))
                                .appendChild(makeColorBox(Color.GREY))
                                .appendChild(makeColorBox(ColorScheme.GREY.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.GREY.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.GREY.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.GREY.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.GREY.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.darker_1()))
                                .appendChild(makeColorBox(Color.BLUE_GREY))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.BLUE_GREY.lighten_5()))
                        )
                        .addColumn(Column.span3()
                                .appendChild(makeColorBox(ColorScheme.BLACK.darker_4()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.darker_3()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.darker_2()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.darker_1()))
                                .appendChild(makeColorBox(Color.BLACK))
                                .appendChild(makeColorBox(ColorScheme.BLACK.lighten_1()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.lighten_2()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.lighten_3()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.lighten_4()))
                                .appendChild(makeColorBox(ColorScheme.BLACK.lighten_5()))
                        )
                        .element())
                .element());

        return element;
    }

    private HtmlContentBuilder<HTMLDivElement> makeColorBox(Color color) {
        return div().css("demo-color-box", color.getBackground())
                .add(div().css("color-name").textContent(color.getName()))
                .add(div().css("color-code").textContent(color.getHex()))
                .add(div().css("color-class-name").textContent(color.getBackground()))
                .add(div().css("color-class-name").textContent(color.getStyle()));
    }

}