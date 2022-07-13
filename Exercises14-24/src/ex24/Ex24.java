package ex24;

import net.mindview.util.Null;

import java.util.stream.IntStream;

class NullPart extends Part implements Null{
    private Part proxied;

    public NullPart(Part proxied) {
        this.proxied = proxied;
    }
    public static class Factory implements ex24.factory.Factory<NullPart> {

        @Override
        public NullPart create() {
            return new NullPart(null);
        }
    }

}
class Filter extends Part {}

class FuelFilter extends Filter {
    //Create a Class Factory for each specific type:
    public static class Factory implements ex24.factory.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {

    public static class Factory implements ex24.factory.Factory<AirFilter> {

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class CabinAirFilter extends Filter {

    public static class Factory implements ex24.factory.Factory<CabinAirFilter> {

        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    //Create a Class Factory for each specific type:
    public static class Factory implements ex24.factory.Factory<OilFilter> {

        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements ex24.factory.Factory<FanBelt> {

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements ex24.factory.Factory<GeneratorBelt> {

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class powerSteeringBelt extends Belt{
    public static class Factory implements ex24.factory.Factory<powerSteeringBelt> {

        @Override
        public powerSteeringBelt create() {
            return new powerSteeringBelt();
        }
    }
}

public class Ex24 {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i->{
            System.out.println(Part.createRandom());
        });
    }
}
