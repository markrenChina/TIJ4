package ex14;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


class Part {
    static List<Class<? extends Part>> partFactories = new ArrayList<>();
    private static Random rand = new Random(47);

    static {
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class);
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(powerSteeringBelt.class);
        partFactories.add(GeneratorBelt.class);
    }

    public static Part createRandom() throws InstantiationException, IllegalAccessException {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).newInstance();
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {

}
class AirFilter extends Filter {

}
class CabinAirFilter extends Filter {

}
class OilFilter extends Filter {
}

class Belt extends Part{}

class FanBelt extends Belt{
}

class GeneratorBelt extends Belt{
}

class powerSteeringBelt extends Belt{
}

public class Ex14 {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i->{
            try {
                System.out.println(Part.createRandom());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
