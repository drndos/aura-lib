package sk.drndos.aura.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VGAInterface2 extends Library {
    VGAInterface2 INSTANCE = Native.loadLibrary("Vender", VGAInterface2.class);
}
