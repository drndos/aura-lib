package sk.drndos.aura.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface VGAInterface1 extends Library {
    VGAInterface1 INSTANCE = Native.loadLibrary("LED_DLL_forMB", VGAInterface1.class);
}
