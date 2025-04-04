package com.calvinnordstrom.cnboard.view.control;

import javafx.beans.property.BooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class ToggleControl {
    private final BooleanProperty value;
    private final HBox view = new HBox();
    private final CheckBox checkBox;

    public ToggleControl(String text, BooleanProperty value) {
        this.value = Objects.requireNonNull(value);
        checkBox = new CheckBox(text);
        checkBox.setSelected(value.get());

        init();
        initEventHandlers();
    }

    private void init() {
        view.getChildren().add(checkBox);

        view.getStyleClass().add("control_label-pane");
        checkBox.getStyleClass().add("title");
    }

    private void initEventHandlers() {
        checkBox.selectedProperty().addListener((_, _, newValue) -> value.set(newValue));
    }

    public Node asNode() {
        return view;
    }
}
