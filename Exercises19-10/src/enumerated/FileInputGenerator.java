package enumerated;

import net.mindview.util.Generator;
import net.mindview.util.TextFile;

import java.util.Iterator;

//Create Inputs from a file of ':'-separated strings
public class FileInputGenerator implements Generator<Input> {

    private Iterator<String> input;

    public FileInputGenerator(String fileName) {
        this.input = new TextFile(fileName,":").iterator();
    }

    @Override
    public Input next() {
        if (!input.hasNext()){
            return null;
        }
        return Enum.valueOf(Input.class,input.next().trim());
    }
}
