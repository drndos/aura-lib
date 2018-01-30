package sk.drndos.aura.lib;

public enum MBMode {
    EC(0),
    SOFTWARE(1);

    private int modeInt;

    MBMode(int modeInt) {
        this.modeInt = modeInt;
    }

    public int getModeInt() {
        return modeInt;
    }
}
