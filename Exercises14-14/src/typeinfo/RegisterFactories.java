package typeinfo;

import java.util.stream.IntStream;



class Filter extends Part {}

class FuelFilter extends Filter {
    //静态初始化器只有在类首先被加载的情况下才能被调用
    //IOC 依赖注入才能解决这个问题。
    static {
        partFactories.add(new FuelFilter.Factory());
    }
    //Create a Class Factory for each specific type:
    public static class Factory implements typeinfo.factory.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
class AirFilter extends Filter {

    public static class Factory implements typeinfo.factory.Factory<AirFilter> {

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
class CabinAirFilter extends Filter {

    public static class Factory implements typeinfo.factory.Factory<CabinAirFilter> {

        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    //Create a Class Factory for each specific type:
    public static class Factory implements typeinfo.factory.Factory<OilFilter> {

        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt{
    public static class Factory implements typeinfo.factory.Factory<FanBelt> {

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt{
    public static class Factory implements typeinfo.factory.Factory<GeneratorBelt> {

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class powerSteeringBelt extends Belt{
    public static class Factory implements typeinfo.factory.Factory<powerSteeringBelt> {

        @Override
        public powerSteeringBelt create() {
            return new powerSteeringBelt();
        }
    }
}

public class RegisterFactories {
    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i->{
            System.out.println(Part.createRandom());
        });
    }
}
