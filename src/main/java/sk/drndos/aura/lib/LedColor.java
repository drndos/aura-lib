package sk.drndos.aura.lib;

public class LedColor {
    private final byte r;
    private final byte g;
    private final byte b;

    public LedColor(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public byte getB() {
        return b;
    }

    public byte getG() {
        return g;
    }

    public byte getR() {
        return r;
    }
}
