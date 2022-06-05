package enumerated;

import net.mindview.util.Generator;

//For a basic sanity check
public class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randomSelection();
    }
}
