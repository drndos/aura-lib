package sk.drndos.aura.lib.leds;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import sk.drndos.aura.lib.AuraSDKInterface;
import sk.drndos.aura.lib.HandleIsNullException;
import sk.drndos.aura.lib.LedColor;
import sk.drndos.aura.lib.MBMode;

import java.util.ArrayList;
import java.util.List;

public class MotherBoard implements Component {

    private final Pointer handle;
    private Integer ledCount = null;

    public MotherBoard() {
        Pointer[] temp = new Pointer[1];
        AuraSDKInterface.INSTANCE.EnumerateMbController(temp, new WinDef.DWORD(1));
        handle = temp[0];
    }

    public int getLedCount() {
        if (ledCount == null) {
            ledCount = AuraSDKInterface.INSTANCE.GetMbLedCount(handle).intValue();
        }
        return ledCount;
    }


    public void setMode(MBMode mode) throws HandleIsNullException {
        WinDef.DWORD returnValue = AuraSDKInterface.INSTANCE.SetMbMode(handle, new WinDef.DWORD(mode.getModeInt()));
        if (returnValue.intValue() == 0) {
            throw new HandleIsNullException();
        }
    }

    public List<LedColor> getColors() throws HandleIsNullException {
        int ledCount = getLedCount();
        int size = ledCount * 3;
        Pointer arrPtr = new Memory(size);

        WinDef.DWORD returnValue = AuraSDKInterface.INSTANCE.GetMbColor(handle, arrPtr, new WinDef.DWORD(size));
        if (returnValue.intValue() == 0) {
            throw new HandleIsNullException();
        }
        byte[] arr = new byte[size];
        arrPtr.read(0, arr, 0, arr.length);
        List<LedColor> colors = new ArrayList<>();
        for (int i = 0; i < ledCount; i++) {
            colors.add(new LedColor(arr[i * 3], arr[(i * 3) + 2], arr[(i * 3) + 1]));
        }
        return colors;
    }

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
        AuraSDKInterface.INSTANCE.SetMbColor(handle, arrPtr, new WinDef.DWORD(size));
    }
}
