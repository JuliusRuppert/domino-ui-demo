package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.MarkerPluginProxy;
import org.dominokit.domino.datatable.client.presenters.TreeGridEagerPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.SelectionPlugin;
import org.dominokit.domino.ui.datatable.plugins.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.store.LocalTreeDataStore;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.td;

@UiView(presentable = TreeGridEagerPluginProxy.class)
@SampleClass(includeClassName = true)
public class TreeGridEagerPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();


        element.appendChild(LinkToSourceCode.create("datatable", this.getClass()).element());
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a().attr("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .attr("target", "_blank")
                        .textContent("Data table demo source code").element())
                .element());

        treeGridFullParentSpan();
        element.appendChild(CodeCard.createLazyCodeCard(TreeGridEagerPluginViewImpl_CodeResource.INSTANCE.treeGridFullParentSpan()).element());

        treeGridParentColumns();
        element.appendChild(CodeCard.createLazyCodeCard(TreeGridEagerPluginViewImpl_CodeResource.INSTANCE.treeGridParentColumns()).element());

        return element;
    }

    @SampleMethod
    private void treeGridFullParentSpan() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setTitle("First name")
                            .setSortable(true, "id");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config
                                    .setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                    .setParentRowCellsSupplier((dataTable, tableRow) -> {
                                        HTMLTableCellElement cellElement = DominoElement.of(td())
                                                .setAttribute("colspan", "8")
                                                .element();
                                        RowCell<Contact> rowCell =
                                                new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), dataTable.getTableConfig().getColumnByName("id"));
                                        return Collections.singletonList(rowCell);
                                    })
                                    .setIndent(60)
                                    .setLazy(false);
                        })
                );

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            ContactsProvider.instance.addFriends(parent, 2, 1, 2);
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        });
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("TREE GRID PLUGIN - Full PARENT SPAN", "Render records in tree style with expand and collapse features")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList(10));
    }

    @SampleMethod
    private void treeGridParentColumns() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setSortable(true, "id")
                            .setTitle("First name");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config.setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                    .setIndent(60);
                        })
                );

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            ContactsProvider.instance.addFriends(parent, 2, 1, 2);
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        });
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("TREE GRID PLUGIN - PARENT WITH COLUMNS", "Render records in tree style with expand and collapse features")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList(10));
    }

}
