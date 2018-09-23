package org.dominokit.domino.animation.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.animation.client.presenters.AnimationPresenter;
import org.dominokit.domino.animation.client.views.AnimationView;
import org.dominokit.domino.animation.client.views.CodeResource;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = AnimationPresenter.class)
public class AnimationViewImpl extends ComponentView<HTMLDivElement> implements AnimationView {

    private HTMLDivElement element = div().asElement();

    public AnimationViewImpl() {

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create("animation", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("CSS ANIMATIONS")
                .appendText("Pure css animations - ")
                .appendChild(a().attr("href", "https://daneden.github.io/animate.css/")
                        .attr("target", "_blank").textContent("daneden.github.io/animate.css"))
                .asElement()
        );


        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLASH)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.PULSE)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.RUBBER_BAND)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SHAKE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SWING)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.TADA)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.WOBBLE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.JELLO)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_LEFT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_RIGHT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.BOUNCE_OUT_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_DOWN_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_LEFT_BIG)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_RIGHT_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_IN_UP_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_DOWN_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_LEFT_BIG)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_RIGHT_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FADE_OUT_UP_BIG)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_X)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_IN_Y)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_X)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.FLIP_OUT_Y)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.LIGHT_SPEED_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_DOWN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_LEFT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_IN_UP_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_LEFT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_DOWN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROTATE_OUT_UP_RIGHT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_LEFT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_IN_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_DOWN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.SLIDE_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_DOWN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_RIGHT)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_IN_UP)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_DOWN)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_LEFT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_RIGHT)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ZOOM_OUT_UP)
                        ))
                .asElement()
        );
        element.appendChild(Row.create()
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.HINGE)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROLL_IN)
                        ))
                .addColumn(Column.span4()
                        .appendChild(createCard(Transition.ROLL_OUT)
                        ))
                .asElement()
        );

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.animation()).asElement());
    }

    private Card createCard(Transition transition) {

        Card animationCard = Card.create().setBackground(Color.BLUE_GREY)
                .appendChild(img(GWT.getModuleBaseURL() + "/images/animation-bg.jpg").css(Styles.img_responsive));

        Card card = Card.create(transition.getName(), transition.getStyle() + " animation.")
                .setBodyBackground(Color.LIGHT_BLUE)
                .setHeaderBackground(Color.BLUE);

        Button animate = Button.createDefault(transition.getName())
                .large();
        animate.getClickableElement().addEventListener("click", e ->
                Animation.create(animationCard)
                        .beforeStart(element -> {/*do something here*/})
                        .transition(transition)
                        .duration(1000)
                        .animate());

        Button infiniteAnimate = Button.createDefault("INFINITE")
                .large();
        infiniteAnimate.getClickableElement().addEventListener("click", e -> {

            Animation animation = Animation.create(animationCard)
                    .transition(transition)
                    .infinite()
                    .duration(1000);
            if (Style.of(animationCard).contains("animated")) {
                animation.stop();
                Style.of(animate).setDisplay("inline-block");
                infiniteAnimate.setContent("INFINITE");
            } else {
                animation.animate();
                Style.of(animate).setDisplay("none");
                infiniteAnimate.setContent("STOP");
            }
        });


        card.appendChild(animationCard)
                .appendChild(Elements.div().css("button-demo").attr("style", "text-align: center")
                        .add(animate)
                        .add(infiniteAnimate)
                );

        return card;
    }
}