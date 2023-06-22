package org.dominokit.domino.spin.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.spin.client.presenters.SpinSelectProxy;
import org.dominokit.domino.spin.client.views.SpinSelectView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.spin.VSpinSelect;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = SpinSelectProxy.class)
@SampleClass
public class SpinSelectViewImpl extends BaseDemoView<HTMLDivElement> implements SpinSelectView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(BlockHeader.create("SPIN"));

        horizontalSpin();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalSpin()));

        verticalSpin();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalSpin()));

        return element.element();
    }

    @SampleMethod
    private void horizontalSpin() {
        element
                .appendChild(Card.create("HORIZONTAL SPIN")
                        .appendChild(Row.create()
                                .appendChild(Column.span2()
                                        .appendChild(HSpinSelect.<String>create()
                                                .addCss(dui_gap_4, dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_blue)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_red)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_blue_grey)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_orange)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_brown)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 6")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_green)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 7")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_pink)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 8")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_teal)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 9")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_cyan)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 10")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_purple)
                                                        )
                                                )
                                        )
                                )
                                .appendChild(Column.span2()
                                        .appendChild(HSpinSelect.<String>create()
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.battery_charging_100())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.bluetooth())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.database())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.brightness_4())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.devices())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.crosshairs_gps())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.graph())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.search_web())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.alarm())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.cast_variant())
                                                        )
                                                )
                                        ))
                                .appendChild(Column.span2()
                                        .appendChild(HSpinSelect.<String>create()
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/jordan.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2").appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/oman.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/palestine.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/brazil.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/european-union.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(HSpinSelect.<String>create(Icons.menu_left(), Icons.menu_right())
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Cras justo odio"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Dapibus ac facilisis in"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Morbi leo risus"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Porta ac consectetur ac"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Vestibulum at eros"))
                                                        )
                                                )
                                        )
                                )
                        )
                );
    }

    @SampleMethod
    private void verticalSpin() {
        element
                .appendChild(Card.create("VERTICAL SPIN", "For vertical spins to work the height should be fixed.")
                        .appendChild(Row.create()
                                .appendChild(Column.span2()
                                        .appendChild(VSpinSelect.<String>create()
                                                .addCss(dui_gap_4, dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_blue)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_red)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_blue_grey)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_orange)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_brown)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 6")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_green)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 7")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_pink)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 8")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_teal)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 9")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_cyan)
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 10")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_purple)
                                                        )
                                                )
                                        )
                                )
                                .appendChild(Column.span2()
                                        .appendChild(VSpinSelect.<String>create()
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.battery_charging_100())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.bluetooth())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.database())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.brightness_4())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.devices())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.crosshairs_gps())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.graph())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.search_web())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.alarm())
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(Icons.cast_variant())
                                                        )
                                                )
                                        ))
                                .appendChild(Column.span2()
                                        .appendChild(VSpinSelect.<String>create()
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/jordan.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2").appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/oman.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/palestine.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/brazil.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .appendChild(img("/images/flags/european-union.png")
                                                                        .addCss(dui_h_12, dui_w_12)
                                                                )
                                                        )
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(VSpinSelect.<String>create(Icons.menu_up(), Icons.menu_down())
                                                .addCss(dui_min_h_12)
                                                .appendChild(SpinItem.create("item 1")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Cras justo odio"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 2")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Dapibus ac facilisis in"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 3")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Morbi leo risus"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 4")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Porta ac consectetur ac"))
                                                        )
                                                )
                                                .appendChild(SpinItem.create("item 5")
                                                        .appendChild(div()
                                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                                .setCssProperty("line-height", "3rem")
                                                                .appendChild(text("Vestibulum at eros"))
                                                        )
                                                )
                                        )
                                )
                        )
                );


    }
}