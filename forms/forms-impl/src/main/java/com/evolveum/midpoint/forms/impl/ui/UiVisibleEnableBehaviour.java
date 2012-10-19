package com.evolveum.midpoint.forms.impl.ui;

import com.evolveum.midpoint.forms.impl.token.EnabledToken;
import com.evolveum.midpoint.forms.impl.token.VisibleToken;
import com.evolveum.midpoint.gui.common.VisibleEnableBehaviour;

/**
 * @author lazyman
 */
public class UiVisibleEnableBehaviour extends VisibleEnableBehaviour {

    private VisibleToken visible;
    private EnabledToken enabled;

    public UiVisibleEnableBehaviour(EnabledToken enabled) {
        this(enabled, null);
    }

    public UiVisibleEnableBehaviour(VisibleToken visible) {
        this(null, visible);
    }

    public UiVisibleEnableBehaviour(EnabledToken enabled, VisibleToken visible) {
        this.enabled = enabled;
        this.visible = visible;
    }

    @Override
    public boolean isEnabled() {
        if (enabled == null) {
            return true;
        }

        //todo implement
        return super.isEnabled();
    }

    @Override
    public boolean isVisible() {
        if (visible == null) {
            return true;
        }

        //todo implement
        return super.isVisible();
    }
}
