package com.github.manolo8.darkbot.gui.tree.components;

import com.github.manolo8.darkbot.config.tree.ConfigField;
import com.github.manolo8.darkbot.gui.tree.OptionEditor;

import javax.swing.*;
import java.awt.*;

public class JTimeField extends JSpinner implements OptionEditor {

    private ConfigField field;

    public JTimeField() {
        super(new SpinnerNumberModel(0, 0, 1, 0.05));
        putClientProperty("ConfigTree", true);
        setEditor(new DateEditor(this, "HH:mm:ss"));
        setPreferredSize(new Dimension(50, 16));

        addChangeListener(e -> {
            if (field != null) field.set(getValue());
        });
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public void edit(ConfigField field) {
        this.field = null;
        setValue(field.get());
        this.field = field;
    }
}
