package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.ColumnResizePluginProxy;
import org.dominokit.domino.datatable.client.presenters.MarkerPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.ResizeColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.ResizeColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

@UiView(presentable = ColumnResizePluginProxy.class)
@SampleClass(includeClassName = true)
public class ColumnResizePluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        resizableColumns();
        element.appendChild(CodeCard.createLazyCodeCard(ColumnResizePluginViewImpl_CodeResource.INSTANCE.resizableColumns()).element());

        return element;
    }

    @SampleMethod
    private void resizableColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .applyMeta(ResizeColumnMeta.create())
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px")
                        .minWidth("100px")
                        .maxWidth("300")
                )

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        .minWidth("50px")
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> DominoElement.of(span().css("ellipsis-text")
                                        .textContent(cell.getTableRow().getRecord().getPhone()))
                                .setDisplay("inline-block")
                                .element())
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new ResizeColumnsPlugin<Contact>()
                        .configure(config -> config.setClipContent(true)));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("RESIZABLE COLUMNS", "Allow the user to change the size of the table columns.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList(50));
    }

}
