package sk.drndos.aura.lib.leds;

import sk.drndos.aura.lib.LedColor;

import java.util.List;

public interface Component {
    int getLedCount();
    void setColors(List<LedColor> colors);
}
