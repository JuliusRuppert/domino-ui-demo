package com.progressoft.brix.domino.buttons.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.buttons.client.presenters.ButtonsPresenter;
import com.progressoft.brix.domino.buttons.client.views.ButtonsView;
import com.progressoft.brix.domino.ui.button.*;
import com.progressoft.brix.domino.ui.button.group.ButtonsGroup;
import com.progressoft.brix.domino.ui.button.group.JustifiedGroup;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

import static com.progressoft.brix.domino.ui.button.IconButton.CircleSize;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ButtonsPresenter.class)
public class DefaultButtonsView implements ButtonsView {

    private HTMLDivElement element = div().asElement();

    public DefaultButtonsView() {
        element.appendChild(BlockHeader.create("BUTTONS").asElement());
        initBootstrapButtons();
        initMaterialDesignButtons();
        initButtonSizes();
        initBlockButtons();
        initDisabledButtons();
        initIconButtons();
        initTextIconButtons();
        element.appendChild(BlockHeader.create("BUTTON GROUPS", "Group a series of buttons together on a single line with the button group").asElement());
        initButtonsBasicGroup();
        initButtonsToolbar();
        initSizingGroup();
        initNestingGroup();
        initVerticalGroup();
        initJustifyGroup();
        element.appendChild(BlockHeader.create("BUTTON DROPDOWNS", "Use any button to trigger a dropdown menu by placing it within a .btn-group and providing the proper menu markup.").asElement());
        initSingleDropdownButtons();
        initSplitButton();
        initDropUp();
    }

    private void initDropUp() {
        Card card = Card.create("DROPUP VARIATION", "Trigger dropdown menus above elements.");

        HTMLElement element = DropdownButton.createDefault("DEFAULT")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .dropup().asElement();

        HTMLElement primary = DropdownButton.createPrimary("PRIMARY")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .dropup().asElement();

        HTMLElement success = DropdownButton.createSuccess("SUCCESS")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .dropup().asElement();

        HTMLElement info = DropdownButton.createInfo("INFO")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .dropup().asElement();

        DropdownButton danger = DropdownButton.createDanger("Dropdown")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .dropup();


        HTMLElement group = ButtonsGroup.create()
                .addButton(Button.createDanger("DANGER"))
                .addDropDown(danger).asElement();

        element.style.margin = CSSProperties.MarginUnionType.of("5px");
        primary.style.margin = CSSProperties.MarginUnionType.of("5px");
        success.style.margin = CSSProperties.MarginUnionType.of("5px");
        info.style.margin = CSSProperties.MarginUnionType.of("5px");
        group.style.margin = CSSProperties.MarginUnionType.of("5px");

        card.appendContent(element);
        card.appendContent(primary);
        card.appendContent(success);
        card.appendContent(info);
        card.appendContent(group);

        this.element.appendChild(card.asElement());

        this.element.appendChild(Card.createCodeCard("element.appendChild(DropdownButton.createDanger(\"Dropdown\")\n" +
                "                .addAction(DropdownAction.create(\"Action\"))\n" +
                "                .addAction(DropdownAction.create(\"Another action\"))\n" +
                "                .dropup());\n" +
                "                \n" +
                "// in group\n" +
                "DropdownButton danger = DropdownButton.createDanger(\"Dropdown\")\n" +
                "                .addAction(DropdownAction.create(\"Action\"))\n" +
                "                .addAction(DropdownAction.create(\"Another action\"))\n" +
                "                .dropup();\n" +
                "\n" +
                "\n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDanger(\"DANGER\"))\n" +
                "                .addDropDown(danger).asElement());").asElement());
    }

    private void initSplitButton() {
        Card card = Card.create("SPLITE BUTTON DROPDOWNS", "Similarly, create split button dropdowns with the same markup changes, only with a separate button.");

        DropdownButton defaultDropdown = DropdownButton.createDefault("Toggle Dropdown")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        HTMLElement defaultSplit = SplitButton.createDefault("DEFAULT")
                .addDropdown(defaultDropdown).asElement();

        card.appendContent(defaultSplit);

        DropdownButton primaryDropdown = DropdownButton.createPrimary("Toggle Dropdown")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        HTMLElement primarySplit = SplitButton.createPrimary("PRIMARY")
                .addDropdown(primaryDropdown).asElement();

        card.appendContent(primarySplit);

        DropdownButton warningDropdown = DropdownButton.createWarning("Toggle Dropdown")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        HTMLElement warningSplit = SplitButton.createWarning("WARNING")
                .addDropdown(warningDropdown).asElement();

        card.appendContent(warningSplit);

        DropdownButton infoDropdown = DropdownButton.createInfo("Toggle Dropdown")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        HTMLElement infoSplit = SplitButton.createInfo("INFO")
                .addDropdown(infoDropdown).asElement();

        card.appendContent(infoSplit);

        defaultSplit.style.margin = CSSProperties.MarginUnionType.of("10px");
        primarySplit.style.margin = CSSProperties.MarginUnionType.of("10px");
        warningSplit.style.margin = CSSProperties.MarginUnionType.of("10px");
        infoSplit.style.margin = CSSProperties.MarginUnionType.of("10px");

        this.element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("DropdownButton infoDropdown = DropdownButton.createInfo(\"Toggle Dropdown\")\n" +
                "                .addAction(DropdownAction.create(\"Action\"))\n" +
                "                .addAction(DropdownAction.create(\"Another action\"))\n" +
                "                .addAction(DropdownAction.create(\"Something else here\"))\n" +
                "                .separator()\n" +
                "                .addAction(DropdownAction.create(\"Separated link\"));\n" +
                "\n" +
                "element.appendChild(SplitButton.createInfo(\"INFO\")\n" +
                "                .addDropdown(infoDropdown).asElement());").asElement());
    }

    private void initSingleDropdownButtons() {
        Card card = Card.create("SINGLE BUTTON DROPDOWNS", "Turn a button into a dropdown toggle with some basic markup changes.");

        DropdownButton defaultDropdown = DropdownButton.createDefault("DEFAULT")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        DropdownButton primaryDropdown = DropdownButton.createPrimary("PRIMARY")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        DropdownButton infoDropdown = DropdownButton.createInfo("INFO")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        DropdownButton dangerButton = DropdownButton.createDanger("DANGER")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        DropdownButton warningDropdown = DropdownButton.createWarning("WARNING")
                .addAction(DropdownAction.create("Action"))
                .addAction(DropdownAction.create("Another action"))
                .addAction(DropdownAction.create("Something else here"))
                .separator()
                .addAction(DropdownAction.create("Separated link"));

        defaultDropdown.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryDropdown.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        infoDropdown.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        warningDropdown.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerButton.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        card.appendContent(defaultDropdown.asElement());
        card.appendContent(primaryDropdown.asElement());
        card.appendContent(infoDropdown.asElement());
        card.appendContent(warningDropdown.asElement());
        card.appendContent(dangerButton.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(DropdownButton.createWarning(\"WARNING\")\n" +
                "                .addAction(DropdownAction.create(\"Action\"))\n" +
                "                .addAction(DropdownAction.create(\"Another action\"))\n" +
                "                .addAction(DropdownAction.create(\"Something else here\"))\n" +
                "                .separator()\n" +
                "                .addAction(DropdownAction.create(\"Separated link\")));").asElement());
    }

    private void initJustifyGroup() {
        Card justifiedGroupCard = Card.create("JUSTIFIED BUTTON GROUPS", "Make a group of buttons stretch at equal sizes to span the entire width of its parent. Also works with button dropdowns within the button group.");

        DropdownButton dropDown = DropdownButton.createDefault("Drop down")
                .addAction(DropdownAction.create("Action"))
                .separator()
                .addAction(DropdownAction.create("Action2"));


        JustifiedGroup justifiedGroup = JustifiedGroup.create();
        justifiedGroup.addButton(Button.createPrimary("LEFT"));
        justifiedGroup.addButton(Button.createInfo("MIDDLE"));
        justifiedGroup.addButton(Button.createDanger("RIGHT"));
        justifiedGroup.addDropDown(dropDown);

        HTMLElement element1 = justifiedGroup.asElement();
        element1.style.margin = CSSProperties.MarginUnionType.of("5px");
        element1.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        justifiedGroupCard.getBody().appendChild(justifiedGroup.asElement());

        element.appendChild(justifiedGroupCard.asElement());

        element.appendChild(Card.createCodeCard("JustifiedGroup justifiedGroup = JustifiedGroup.create();\n" +
                "justifiedGroup.addButton(Button.createPrimary(\"LEFT\"));\n" +
                "justifiedGroup.addButton(Button.createInfo(\"MIDDLE\"));\n" +
                "justifiedGroup.addButton(Button.createDanger(\"RIGHT\"));\n" +
                "justifiedGroup.addDropDown(dropDown);\n" +
                "element.appendChild(justifiedGroup.asElement());").asElement());
    }

    private void initVerticalGroup() {
        Card verticalGroupCard = Card.create("VERTICAL VARIATION", "Make a set of buttons appear vertically stacked rather than horizontally.");

        ButtonsGroup group = ButtonsGroup.create()
                .addButton(Button.createDefault("Button"))
                .addButton(Button.createPrimary("Button"))
                .addDropDown(DropdownButton.createInfo("Dropdown")
                        .addAction(DropdownAction.create("Dropdown link"))
                        .addAction(DropdownAction.create("Dropdown link")))
                .addButton(Button.createDanger("Button"))
                .verticalAlign();
        group.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        verticalGroupCard.getBody().appendChild(group.asElement());

        element.appendChild(verticalGroupCard.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"Button\"))\n" +
                "                .addButton(Button.createPrimary(\"Button\"))\n" +
                "                .addDropDown(DropdownButton.createInfo(\"Dropdown\")\n" +
                "                        .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "                        .addAction(DropdownAction.create(\"Dropdown link\")))\n" +
                "                .addButton(Button.createDanger(\"Button\"))\n" +
                "                .verticalAlign());").asElement());
    }

    private void initNestingGroup() {
        Card card = Card.create("SIZING", "Dropdown can be used inside a group of buttons.");

        HTMLElement defaultGroup = numbersNestedGroup(ButtonType.DEFAULT);
        defaultGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        HTMLElement primaryGroup = numbersNestedGroup(ButtonType.PRIMARY);
        primaryGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        HTMLElement infoGroup = numbersNestedGroup(ButtonType.INFO);
        infoGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        infoGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        HTMLElement successGroup = numbersNestedGroup(ButtonType.SUCCESS);
        successGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        successGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        HTMLElement dangerGroup = numbersNestedGroup(ButtonType.DANGER);
        dangerGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        HTMLElement warningGroup = numbersNestedGroup(ButtonType.WARNING);
        warningGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        warningGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(defaultGroup);
        card.appendContent(primaryGroup);
        card.appendContent(infoGroup);
        card.appendContent(successGroup);
        card.appendContent(dangerGroup);
        card.appendContent(warningGroup);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("DropdownButton defaultDropDown = DropdownButton.createDefault(\"Dropdown\")\n" +
                "                .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "                .addAction(DropdownAction.create(\"Dropdown link\"));\n" +
                "\n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"1\"))\n" +
                "                .addButton(Button.createDefault(\"2\"))\n" +
                "                .addDropDown(defaultDropDown).asElement());").asElement());
    }

    private HTMLElement numbersNestedGroup(ButtonType type) {
        DropdownButton primaryDropDown = DropdownButton.create("Dropdown")
                .setButtonType(type)
                .addAction(DropdownAction.create("Dropdown link"))
                .addAction(DropdownAction.create("Dropdown link"));

        return ButtonsGroup.create()
                .addButton(Button.create("1").setButtonType(type))
                .addButton(Button.create("2").setButtonType(type))
                .addDropDown(primaryDropDown).asElement();
    }

    private void initSizingGroup() {
        Card card = Card.create("SIZING", "Instead of applying button sizing classes to every button in a group, size can be applied to the group and will be applied to every button.");

        Row row = Row.create();

        Column column1 = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.nine)
                .onXSmall(Column.OnXSmall.twelve);

        HTMLElement largeGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.LARGE)
                .asElement();

        largeGroup.style.margin = CSSProperties.MarginUnionType.of("15px");

        column1.asElement().appendChild(heading("Large Button Group"));
        column1.asElement().appendChild(largeGroup);


        Column column2 = column1.copy();
        HTMLElement defaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .asElement();

        defaultGroup.style.margin = CSSProperties.MarginUnionType.of("15px");

        column2.asElement().appendChild(heading("Default Button Group"));
        column2.asElement().appendChild(defaultGroup);

        Column column3 = column1.copy();
        HTMLElement smallGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.SMALL)
                .asElement();

        smallGroup.style.margin = CSSProperties.MarginUnionType.of("15px");

        column3.asElement().appendChild(heading("Small Button Group"));
        column3.asElement().appendChild(smallGroup);

        Column column4 = column1.copy();
        HTMLElement xsmallGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.XSMALL)
                .asElement();

        xsmallGroup.style.margin = CSSProperties.MarginUnionType.of("15px");

        column4.asElement().appendChild(heading("Extra-Small Button Group"));
        column4.asElement().appendChild(xsmallGroup);


        column1.asElement().classList.add("align-center");
        column2.asElement().classList.add("align-center");
        column3.asElement().classList.add("align-center");
        column4.asElement().classList.add("align-center");

        row.addColumn(column1).addColumn(column2).addColumn(column3).addColumn(column4);

        card.appendContent(row.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.LARGE)\n" +
                "                .asElement());\n" +
                "\n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .asElement());\n" +
                "                \n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.SMALL)\n" +
                "                .asElement());\n" +
                "                \n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.XSMALL)\n" +
                "                .asElement());").asElement());
    }

    private void initButtonsToolbar() {
        Card card = Card.create("BUTTON TOOLBAR", "Create buttons toolbar");

        Row row = Row.create();

        ButtonsGroup firstDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("1"))
                .addButton(Button.createDefault("2"))
                .addButton(Button.createDefault("3"));

        ButtonsGroup secondDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("4"))
                .addButton(Button.createDefault("5"))
                .addButton(Button.createDefault("6"));

        ButtonsGroup thirdDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("7"));

        ButtonsToolbar defaultButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstDefaultGroup)
                .addGroup(secondDefaultGroup)
                .addGroup(thirdDefaultGroup);

        defaultButtonsToolbar.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        row.asElement().appendChild(defaultButtonsToolbar.asElement());

        ButtonsGroup firstPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("1"))
                .addButton(Button.createPrimary("2"))
                .addButton(Button.createPrimary("3"));

        ButtonsGroup secondPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("4"))
                .addButton(Button.createPrimary("5"))
                .addButton(Button.createPrimary("6"));

        ButtonsGroup thirdPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("7"));

        ButtonsToolbar primaryButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstPrimaryGroup)
                .addGroup(secondPrimaryGroup)
                .addGroup(thirdPrimaryGroup);

        primaryButtonsToolbar.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        row.asElement().appendChild(primaryButtonsToolbar.asElement());

        ButtonsGroup firstInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("1"))
                .addButton(Button.createInfo("2"))
                .addButton(Button.createInfo("3"));

        ButtonsGroup secondInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("4"))
                .addButton(Button.createInfo("5"))
                .addButton(Button.createInfo("6"));

        ButtonsGroup thirdInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("7"));

        ButtonsToolbar infoButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstInfoGroup)
                .addGroup(secondInfoGroup)
                .addGroup(thirdInfoGroup);

        infoButtonsToolbar.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        row.asElement().appendChild(infoButtonsToolbar.asElement());

        ButtonsGroup firstColorGroup = ButtonsGroup.create()
                .addButton(Button.create("1").setBackground(Background.PURPLE))
                .addButton(Button.create("2").setBackground(Background.PURPLE))
                .addButton(Button.create("3").setBackground(Background.PURPLE));

        ButtonsGroup secondColorGroup = ButtonsGroup.create()
                .addButton(Button.create("4").setBackground(Background.PURPLE))
                .addButton(Button.create("5").setBackground(Background.PURPLE))
                .addButton(Button.create("6").setBackground(Background.PURPLE));

        ButtonsGroup thirdColorGroup = ButtonsGroup.create()
                .addButton(Button.create("7").setBackground(Background.PURPLE));

        ButtonsToolbar colorButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstColorGroup)
                .addGroup(secondColorGroup)
                .addGroup(thirdColorGroup);

        colorButtonsToolbar.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        row.asElement().appendChild(colorButtonsToolbar.asElement());

        infoButtonsToolbar.asElement().style.cssFloat = "left";
        defaultButtonsToolbar.asElement().style.cssFloat = "left";
        primaryButtonsToolbar.asElement().style.cssFloat = "left";
        colorButtonsToolbar.asElement().style.cssFloat = "left";
        card.appendContent(row.asElement());
        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("ButtonsGroup firstGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"1\"))\n" +
                "                .addButton(Button.createDefault(\"2\"))\n" +
                "                .addButton(Button.createDefault(\"3\"));\n" +
                "\n" +
                "ButtonsGroup secondGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"4\"))\n" +
                "                .addButton(Button.createDefault(\"5\"))\n" +
                "                .addButton(Button.createDefault(\"6\"));\n" +
                "\n" +
                "ButtonsGroup thirdGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"7\"));\n" +
                "\n" +
                "ButtonsToolbar buttonsToolbar = ButtonsToolbar.create()\n" +
                "                .addGroup(firstGroup)\n" +
                "                .addGroup(secondGroup)\n" +
                "                .addGroup(thirdGroup);\n" +
                "                \n" +
                "element.appendChild(buttonsToolbar.asElement());").asElement());
    }

    private void initButtonsBasicGroup() {
        Card card = Card.create("BASIC EXAMPLE", "Create group of buttons");

        HTMLElement defaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .asElement();

        defaultGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(defaultGroup);

        HTMLElement primaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("LEFT"))
                .addButton(Button.createPrimary("MIDDLE"))
                .addButton(Button.createPrimary("RIGHT"))
                .asElement();

        primaryGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(primaryGroup);

        HTMLElement successGroup = ButtonsGroup.create()
                .addButton(Button.createSuccess("LEFT"))
                .addButton(Button.createSuccess("MIDDLE"))
                .addButton(Button.createSuccess("RIGHT"))
                .asElement();

        successGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        successGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(successGroup);

        HTMLElement infoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("LEFT"))
                .addButton(Button.createInfo("MIDDLE"))
                .addButton(Button.createInfo("RIGHT"))
                .asElement();

        infoGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        infoGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(infoGroup);

        HTMLElement dangerGroup = ButtonsGroup.create()
                .addButton(Button.createDanger("LEFT"))
                .addButton(Button.createDanger("MIDDLE"))
                .addButton(Button.createDanger("RIGHT"))
                .asElement();

        dangerGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(dangerGroup);

        HTMLElement purpleGroup = ButtonsGroup.create()
                .addButton(Button.create("LEFT").setBackground(Background.PURPLE))
                .addButton(Button.create("MIDDLE").setBackground(Background.PURPLE))
                .addButton(Button.create("RIGHT").setBackground(Background.PURPLE))
                .asElement();

        purpleGroup.style.margin = CSSProperties.MarginUnionType.of("5px");
        purpleGroup.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(purpleGroup);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("ButtonsGroup group = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"));\n" +
                "\n" +
                "element.appendChild(group.asElement());").asElement());
    }

    private void initTextIconButtons() {
        Card card = Card.create("ICON & TEXT BUTTONS", "Make icon & text buttons");

        HTMLElement extension = IconButton.createDefault(Icons.ALL.extension()).setContent("EXTENSION").asElement();
        HTMLElement home = IconButton.createPrimary(Icons.ALL.home()).setContent("HOME").asElement();
        HTMLElement lock = IconButton.createSuccess(Icons.ALL.lock()).setContent("LOCK").asElement();
        HTMLElement scanWifi = IconButton.createInfo(Icons.ALL.perm_scan_wifi()).setContent("SCAN WIFI").asElement();
        HTMLElement takeOff = IconButton.createWarning(Icons.ALL.flight_takeoff()).setContent("TAKE OFF").asElement();
        HTMLElement print = IconButton.createDanger(Icons.ALL.print()).setContent("PRINT").asElement();

        extension.style.margin = CSSProperties.MarginUnionType.of("5px");
        extension.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        home.style.margin = CSSProperties.MarginUnionType.of("5px");
        home.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        lock.style.margin = CSSProperties.MarginUnionType.of("5px");
        lock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        scanWifi.style.margin = CSSProperties.MarginUnionType.of("5px");
        scanWifi.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        takeOff.style.margin = CSSProperties.MarginUnionType.of("5px");
        takeOff.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        print.style.margin = CSSProperties.MarginUnionType.of("5px");
        print.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(extension);
        card.appendContent(home);
        card.appendContent(lock);
        card.appendContent(scanWifi);
        card.appendContent(takeOff);
        card.appendContent(print);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Button.createDefault(\"EXTENSION\").setIcon(Icons.ALL.extension()).asElement());\n" +
                "element.appendChild(Button.createPrimary(\"HOME\").setIcon(Icons.ALL.home()).asElement());\n" +
                "element.appendChild(Button.createSuccess(\"LOCK\").setIcon(Icons.ALL.lock()).asElement());\n" +
                "element.appendChild(Button.createInfo(\"SCAN WIFI\").setIcon(Icons.ALL.perm_scan_wifi()).asElement());\n" +
                "element.appendChild(Button.createWarning(\"TAKE OFF\").setIcon(Icons.ALL.flight_takeoff()).asElement());\n" +
                "element.appendChild(Button.createDanger(\"PRINT\").setIcon(Icons.ALL.print()).asElement());").asElement());
    }

    private void initIconButtons() {
        Card card = Card.create("ICON BUTTONS", "Make icon buttons");

        Row normal = Row.create();
        HTMLHeadingElement normal_circle = heading("Normal Icon Button");
        normal.asElement().appendChild(normal_circle);
        card.appendContent(normal.asElement());

        Row row = Row.create();

        HTMLElement homeIcon = IconButton.createDefault(Icons.ALL.home()).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement micIcon = IconButton.createPrimary(Icons.ALL.mic()).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement moreIcon = IconButton.createInfo(Icons.ALL.more()).setButtonType(ButtonType.INFO).asElement();
        HTMLElement keyboardIcon = IconButton.createSuccess(Icons.ALL.keyboard()).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement acUnitIcon = IconButton.createWarning(Icons.ALL.ac_unit()).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement accessAlarmIcon = IconButton.createDanger(Icons.ALL.access_alarm()).setButtonType(ButtonType.DANGER).asElement();

        homeIcon.style.margin = CSSProperties.MarginUnionType.of("5px");
        micIcon.style.margin = CSSProperties.MarginUnionType.of("5px");
        moreIcon.style.margin = CSSProperties.MarginUnionType.of("5px");
        keyboardIcon.style.margin = CSSProperties.MarginUnionType.of("5px");
        acUnitIcon.style.margin = CSSProperties.MarginUnionType.of("5px");
        accessAlarmIcon.style.margin = CSSProperties.MarginUnionType.of("5px");

        row.asElement().appendChild(homeIcon);
        row.asElement().appendChild(micIcon);
        row.asElement().appendChild(moreIcon);
        row.asElement().appendChild(keyboardIcon);
        row.asElement().appendChild(acUnitIcon);
        row.asElement().appendChild(accessAlarmIcon);

        card.appendContent(row.asElement());

        Row smallCircle = Row.create();
        HTMLHeadingElement small_icon_button = heading("Small Circle Icon Button");
        smallCircle.asElement().appendChild(small_icon_button);
        card.appendContent(smallCircle.asElement());

        Row row1 = Row.create();

        HTMLElement addCircleIconCRL = IconButton.createDefault(Icons.ALL.add_circle()).circle(CircleSize.SMALL).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement placeIconCRL = IconButton.createPrimary(Icons.ALL.place()).circle(CircleSize.SMALL).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement airplaneModeActiveIconCRL = IconButton.createInfo(Icons.ALL.airplanemode_active()).circle(CircleSize.SMALL).setButtonType(ButtonType.INFO).asElement();
        HTMLElement albumIconCRL = IconButton.createSuccess(Icons.ALL.album()).circle(CircleSize.SMALL).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement weekendIconCRL = IconButton.createWarning(Icons.ALL.weekend()).circle(CircleSize.SMALL).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement airplayIconCRL = IconButton.createDanger(Icons.ALL.airplay()).circle(CircleSize.SMALL).setButtonType(ButtonType.DANGER).asElement();

        addCircleIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        placeIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        airplaneModeActiveIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        albumIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        weekendIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        airplayIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");

        row1.asElement().appendChild(addCircleIconCRL);
        row1.asElement().appendChild(placeIconCRL);
        row1.asElement().appendChild(airplaneModeActiveIconCRL);
        row1.asElement().appendChild(albumIconCRL);
        row1.asElement().appendChild(weekendIconCRL);
        row1.asElement().appendChild(airplayIconCRL);

        card.appendContent(row1.asElement());

        Row large = Row.create();
        HTMLHeadingElement large_circle = heading("Large Circle Icon Button");
        large.asElement().appendChild(large_circle);
        card.appendContent(large.asElement());

        Row row2 = Row.create();

        HTMLElement adjustIconCRL = IconButton.createDefault(Icons.ALL.adjust()).circle(CircleSize.LARGE).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement alloutIconCRL = IconButton.createPrimary(Icons.ALL.all_out()).circle(CircleSize.LARGE).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement appsIconCRL = IconButton.createInfo(Icons.ALL.apps()).circle(CircleSize.LARGE).setButtonType(ButtonType.INFO).asElement();
        HTMLElement artTrackIconCRL = IconButton.createSuccess(Icons.ALL.art_track()).circle(CircleSize.LARGE).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement assessmentIconCRL = IconButton.createWarning(Icons.ALL.assessment()).circle(CircleSize.LARGE).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement assistantIconCRL = IconButton.createDanger(Icons.ALL.assistant()).circle(CircleSize.LARGE).setButtonType(ButtonType.DANGER).asElement();

        adjustIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        alloutIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        appsIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        artTrackIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        assessmentIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");
        assistantIconCRL.style.margin = CSSProperties.MarginUnionType.of("5px");

        row2.asElement().appendChild(adjustIconCRL);
        row2.asElement().appendChild(alloutIconCRL);
        row2.asElement().appendChild(appsIconCRL);
        row2.asElement().appendChild(artTrackIconCRL);
        row2.asElement().appendChild(assessmentIconCRL);
        row2.asElement().appendChild(assistantIconCRL);


        card.appendContent(row2.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("// NORMAL\n" +
                "element.appendChild(IconButton.create(Icons.ALL.home()).setButtonType(ButtonType.DEFAULT).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.mic()).setButtonType(ButtonType.PRIMARY).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.more()).setButtonType(ButtonType.INFO).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.keyboard()).setButtonType(ButtonType.SUCCESS).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.ac_unit()).setButtonType(ButtonType.WARNING).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.access_alarm()).setButtonType(ButtonType.DANGER).asElement());\n" +
                "\n" +
                "// SMALL CIRCLE\n" +
                "element.appendChild(IconButton.create(Icons.ALL.add_circle()).setButtonType(ButtonType.DEFAULT).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.place()).setButtonType(ButtonType.PRIMARY).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.airplanemode_active()).setButtonType(ButtonType.INFO).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.album()).setButtonType(ButtonType.SUCCESS).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.weekend()).setButtonType(ButtonType.WARNING).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.airplay()).setButtonType(ButtonType.DANGER).circle(CircleSize.SMALL).asElement());\n" +
                "\n" +
                "// LARGE CIRCLE\n" +
                "element.appendChild(IconButton.create(Icons.ALL.adjust()).setButtonType(ButtonType.DEFAULT).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.all_out()).setButtonType(ButtonType.PRIMARY).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.apps()).setButtonType(ButtonType.INFO).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.art_track()).setButtonType(ButtonType.SUCCESS).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.assessment()).setButtonType(ButtonType.WARNING).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.assistant()).setButtonType(ButtonType.DANGER).circle(CircleSize.LARGE).asElement());\n").asElement());
    }

    private HTMLHeadingElement heading(String content) {
        HTMLHeadingElement headingElement = Elements.h(2, content).asElement();
        headingElement.style.marginTop = CSSProperties.MarginTopUnionType.of("25px");
        headingElement.style.marginBottom = CSSProperties.MarginBottomUnionType.of("15px");
        headingElement.style.fontSize = CSSProperties.FontSizeUnionType.of("15px");
        headingElement.style.color = "#000";
        headingElement.style.display = "block";
        return headingElement;
    }

    private void initDisabledButtons() {
        Card card = Card.create("DISABLED BUTTONS", "Make buttons look unclickable by fading them back with opacity");


        HTMLElement defaultDisabled = Button.createDefault("DEFAULT").disable().asElement();
        HTMLElement primaryDisabled = Button.createPrimary("PRIMARY").disable().asElement();
        HTMLElement infoDisabled = Button.createInfo("INFO").disable().asElement();
        HTMLElement warningDisabled = Button.createWarning("WARNING").disable().asElement();
        HTMLElement dangerDisabled = Button.createDanger("DANGER").disable().asElement();

        defaultDisabled.style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultDisabled.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        primaryDisabled.style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryDisabled.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        infoDisabled.style.margin = CSSProperties.MarginUnionType.of("5px");
        infoDisabled.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        warningDisabled.style.margin = CSSProperties.MarginUnionType.of("5px");
        warningDisabled.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        dangerDisabled.style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerDisabled.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(defaultDisabled);
        card.appendContent(primaryDisabled);
        card.appendContent(infoDisabled);
        card.appendContent(warningDisabled);
        card.appendContent(dangerDisabled);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Button.createDefault(\"DEFAULT\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createPrimary(\"PRIMARY\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createInfo(\"INFO\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createWarning(\"WARNING\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createDanger(\"DANGER\").setBlock(true).disbale().asElment());").asElement());
    }

    private void initBlockButtons() {
        Card card = Card.create("BLOCK BUTTONS", "Create block level buttons");

        HTMLElement defaultBlock = Button.createDefault("DEFAULT").setBlock(true).asElement();
        HTMLElement primaryBlock = Button.createPrimary("PRIMARY").setBlock(true).asElement();
        HTMLElement infoBlock = Button.createInfo("INFO").setBlock(true).asElement();
        HTMLElement warningBlock = Button.createWarning("WARNING").setBlock(true).asElement();
        HTMLElement dangerBlock = Button.createDanger("DANGER").setBlock(true).asElement();

        defaultBlock.style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultBlock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        primaryBlock.style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryBlock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        infoBlock.style.margin = CSSProperties.MarginUnionType.of("5px");
        infoBlock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        warningBlock.style.margin = CSSProperties.MarginUnionType.of("5px");
        warningBlock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        dangerBlock.style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerBlock.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");

        card.appendContent(defaultBlock);
        card.appendContent(primaryBlock);
        card.appendContent(infoBlock);
        card.appendContent(warningBlock);
        card.appendContent(dangerBlock);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Button.createDefault(\"DEFAULT\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createPrimary(\"PRIMARY\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createInfo(\"INFO\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createWarning(\"WARNING\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createDanger(\"DANGER\").setBlock(true).asElment());").asElement());

    }

    private void initButtonSizes() {
        Card card = Card.create("BUTTON SIZES", "You can resize the buttons");

        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);
        // -----------------------------------------------


        Button defaultLarge = Button.createDefault("LARGE").setSize(ButtonSize.LARGE);
        Button defaultBtn = Button.createDefault("DEFAULT");
        Button defaultSmall = Button.createDefault("SMALL").setSize(ButtonSize.SMALL);
        Button defaultXsmall = Button.createDefault("XSMALL").setSize(ButtonSize.XSMALL);

        defaultLarge.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultBtn.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultSmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultXsmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        defaultLarge.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        defaultBtn.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        defaultSmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        defaultXsmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");

        column.addElement(Row.create().appendContent(defaultLarge.asElement()).asElement())
                .addElement(Row.create().appendContent(defaultBtn.asElement()).asElement())
                .addElement(Row.create().appendContent(defaultSmall.asElement()).asElement())
                .addElement(Row.create().appendContent(defaultXsmall.asElement()).asElement());

        card.appendContent(column.asElement());

        // -----------------------------------------------


        Column column2 = column.copy();

        Button primaryLarge = Button.createPrimary("LARGE").setSize(ButtonSize.LARGE);
        Button primaryBtn = Button.createPrimary("DEFAULT");
        Button primarySmall = Button.createPrimary("SMALL").setSize(ButtonSize.SMALL);
        Button primaryXsmall = Button.createPrimary("XSMALL").setSize(ButtonSize.XSMALL);

        primaryLarge.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryBtn.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        primarySmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryXsmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        primaryLarge.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        primaryBtn.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        primarySmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        primaryXsmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");

        column2.addElement(Row.create().appendContent(primaryLarge.asElement()).asElement())
                .addElement(Row.create().appendContent(primaryBtn.asElement()).asElement())
                .addElement(Row.create().appendContent(primarySmall.asElement()).asElement())
                .addElement(Row.create().appendContent(primaryXsmall.asElement()).asElement());

        card.appendContent(column2.asElement());

        // -----------------------------------------------


        Column column3 = column.copy();

        Button warningLarge = Button.createWarning("LARGE").setSize(ButtonSize.LARGE);
        Button warningBtn = Button.createWarning("DEFAULT");
        Button warningSmall = Button.createWarning("SMALL").setSize(ButtonSize.SMALL);
        Button warningXsmall = Button.createWarning("XSMALL").setSize(ButtonSize.XSMALL);

        warningLarge.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        warningBtn.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        warningSmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        warningXsmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        warningLarge.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        warningBtn.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        warningSmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        warningXsmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");

        column3.addElement(Row.create().appendContent(warningLarge.asElement()).asElement())
                .addElement(Row.create().appendContent(warningBtn.asElement()).asElement())
                .addElement(Row.create().appendContent(warningSmall.asElement()).asElement())
                .addElement(Row.create().appendContent(warningXsmall.asElement()).asElement());

        card.appendContent(column3.asElement());

        // -----------------------------------------------


        Column column4 = column.copy();

        Button infoLarge = Button.createInfo("LARGE").setSize(ButtonSize.LARGE);
        Button infoBtn = Button.createInfo("DEFAULT");
        Button infoSmall = Button.createInfo("SMALL").setSize(ButtonSize.SMALL);
        Button infoXsmall = Button.createInfo("XSMALL").setSize(ButtonSize.XSMALL);

        infoLarge.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        infoBtn.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        infoSmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        infoXsmall.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        infoLarge.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        infoBtn.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        infoSmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");
        infoXsmall.asElement().style.minWidth = CSSProperties.MinWidthUnionType.of("200px");

        column4.addElement(Row.create().appendContent(infoLarge.asElement()).asElement())
                .addElement(Row.create().appendContent(infoBtn.asElement()).asElement())
                .addElement(Row.create().appendContent(infoSmall.asElement()).asElement())
                .addElement(Row.create().appendContent(infoXsmall.asElement()).asElement());


        card.appendContent(column4.asElement());

        // -----------------------------------------------
        Row row = Row.create()
                .addColumn(column)
                .addColumn(column2)
                .addColumn(column3)
                .addColumn(column4);

        row.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");

        card.appendContent(row.asElement());
        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Button.create(\"PURPLE LARGE\").setBackground(Background.PURPLE).setSize(ButtonSize.LARGE).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE\").setBackground(Background.PURPLE).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE SMALL\").setBackground(Background.PURPLE).setSize(Buttonize.SMALL).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE XSMALL\").setBackground(Background.PURPLE).setSize(ButtonSize.XSMALL).asElement());").asElement());

    }

    private void initBootstrapButtons() {
        Card card = Card.create("BOOTSTRAP DEFAULT BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement defaultBtn = Button.createDefault("DEFAULT").asElement();
        HTMLElement primaryBtn = Button.createPrimary("PRIMARY").asElement();
        HTMLElement successBtn = Button.createSuccess("SUCCESS").asElement();
        HTMLElement infoBtn = Button.createInfo("INFO").asElement();
        HTMLElement warningBtn = Button.createWarning("WARNING").asElement();
        HTMLElement dangerBtn = Button.createDanger("DANGER").asElement();

        defaultBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        defaultBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(defaultBtn);

        primaryBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        primaryBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(primaryBtn);

        successBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        successBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(successBtn);

        infoBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        infoBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(infoBtn);

        warningBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        warningBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(warningBtn);

        dangerBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        dangerBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(dangerBtn);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("element.appendContent(Button.createDefault(\"DEFAULT\").asElement());\n" +
                "element.appendContent(Button.createPrimary(\"PRIMARY\").asElement());\n" +
                "element.appendContent(Button.createSuccess(\"SUCCESS\").asElement());\n" +
                "element.appendContent(Button.createInfo(\"INFO\").asElement());\n" +
                "element.appendContent(Button.createWarning(\"WARNING\").asElement());\n" +
                "element.appendContent(Button.createDanger(\"DANGER\").asElement());").asElement());
    }

    private void initMaterialDesignButtons() {
        Card card = Card.create("METARIAL DESIGN BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement redBtn = Button.create("RED").setBackground(Background.RED).asElement();
        redBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        redBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(redBtn);

        HTMLElement purpleBtn = Button.create("PURPLE").setBackground(Background.PURPLE).asElement();
        purpleBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        purpleBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(purpleBtn);

        HTMLElement indigoBtn = Button.create("INDIGO").setBackground(Background.INDIGO).asElement();
        indigoBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        indigoBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(indigoBtn);

        HTMLElement lightBlueBtn = Button.create("LIGHT BLUE").setBackground(Background.LIGHT_BLUE).asElement();
        lightBlueBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        lightBlueBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(lightBlueBtn);

        HTMLElement greenBtn = Button.create("GREEN").setBackground(Background.GREEN).asElement();
        greenBtn.style.margin = CSSProperties.MarginUnionType.of("5px");
        greenBtn.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
        card.appendContent(greenBtn);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("card.appendContent(Button.create(\"RED\").setBackground(Background.RED).asElement());\n" +
                "card.appendContent(Button.create(\"PURPLE\").setBackground(Background.PURPLE).asElement());\n" +
                "card.appendContent(Button.create(\"INDIGO\").setBackground(Background.INDIGO).asElement());\n" +
                "card.appendContent(Button.create(\"LIGHT BLUE\").setBackground(Background.LIGHT_BLUE).asElement());\n" +
                "card.appendContent(Button.create(\"GREEN\").setBackground(Background.GREEN).asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }

}