package sk.drndos.aura.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VGAInterface3 extends Library {
    VGAInterface3 INSTANCE = Native.loadLibrary("VGA_Extra", VGAInterface3.class);
}
