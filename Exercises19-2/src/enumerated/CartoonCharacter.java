package enumerated;

import net.mindview.util.Generator;

import java.util.Random;

public enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random rand = new Random(47);

    @Override
    public enumerated.CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}
