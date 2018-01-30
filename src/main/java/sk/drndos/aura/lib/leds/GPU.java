package sk.drndos.aura.lib.leds;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import sk.drndos.aura.lib.AuraSDKInterface;
import sk.drndos.aura.lib.LedColor;

import java.util.List;

public class GPU implements Component {
    private final Pointer handle;
    private Integer ledCount = null;

    public GPU() {
        Pointer[] temp = new Pointer[1];
        //TODO: Handle multiple GPUs ?
        WinDef.DWORD test = AuraSDKInterface.INSTANCE.EnumerateGPU(null, new WinDef.DWORD(0));
        System.out.println(test);
        AuraSDKInterface.INSTANCE.EnumerateGPU(temp, new WinDef.DWORD(1));
        handle = temp[0];
    }

    @Override
    public int getLedCount() {
        if (ledCount == null) {
            ledCount = AuraSDKInterface.INSTANCE.GetGPULedCount(handle).intValue();
        }
        return ledCount;
    }

    @Override
    public void setColors(List<LedColor> colors) {
        int ledCount = getLedCount();
        int size = ledCount * 3;
        Pointer arrPtr = new Memory(size);
        byte[] arr = new byte[size];
        int i = 0;
        for (LedColor color : colors) {
            arr[i * 3] = color.getR();
            arr[(i * 3) + 1] = color.getB();
            arr[(i * 3) + 2] = color.getG();
            i++;
        }
        arrPtr.write(0, arr, 0, arr.length);
        AuraSDKInterface.INSTANCE.SetGPUColor(handle, arrPtr, new WinDef.DWORD(size));
    }
}
