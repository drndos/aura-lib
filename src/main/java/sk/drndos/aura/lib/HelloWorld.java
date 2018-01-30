package sk.drndos.aura.lib;

import sk.drndos.aura.lib.leds.GPU;

import java.util.Arrays;

public class HelloWorld {

    public static void main(String[] args) {
        /*MotherBoard mb = new MotherBoard();
        mb.setColors(Arrays.asList(
                new LedColor((byte)127,(byte)0,(byte)0),
                new LedColor((byte)0,(byte)127,(byte)0),
                new LedColor((byte)0,(byte)0,(byte)127),
                new LedColor((byte)127,(byte)0,(byte)0),
                new LedColor((byte)0,(byte)127,(byte)0)
        ));*/

        GPU gpu = new GPU();
        gpu.setColors(Arrays.asList(new LedColor((byte)127,(byte)0,(byte)0)));
    }
}