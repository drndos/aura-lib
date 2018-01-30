package sk.drndos.aura.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;

public interface AuraSDKInterface extends Library {

    VGAInterface1 VGA_INTERFACE_1 = VGAInterface1.INSTANCE;
    VGAInterface2 VGA_INTERFACE_2 = VGAInterface2.INSTANCE;
    VGAInterface3 VGA_INTERFACE_3 = VGAInterface3.INSTANCE;

    AuraSDKInterface INSTANCE = (AuraSDKInterface)
            Native.loadLibrary("AURA_SDK", AuraSDKInterface.class);

    WinDef.DWORD EnumerateMbController(Pointer handles[], WinDef.DWORD size);

    WinDef.DWORD SetMbMode(Pointer handle, WinDef.DWORD stg);

    WinDef.DWORD GetMbLedCount(Pointer handle);

    WinDef.DWORD SetMbColor(Pointer handle, Pointer colors, WinDef.DWORD size);

    WinDef.DWORD GetMbColor(Pointer handle, Pointer colors, WinDef.DWORD size);

    WinDef.DWORD EnumerateGPU(Pointer handles[], WinDef.DWORD size);

    WinDef.DWORD GetGPULedCount(Pointer handle);

    WinDef.DWORD SetGPUColor(Pointer handle, Pointer colors, WinDef.DWORD size);

}
