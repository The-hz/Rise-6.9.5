package com.alan.clients.ui.theme;

import com.alan.clients.ui.theme.Themes;
import lombok.Generated;

public final class ThemeManager {
    private Themes aCW = Themes.BLEND;

    public ThemeManager() {
    }

    @Generated
    public void a(Themes themes) {
        this.aCW = themes;
    }

    @Generated
    public Themes rz() {
        return this.aCW;
    }
}
