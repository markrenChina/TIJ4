package ex6;

import generics.RandomList;

import java.util.stream.IntStream;

public class Ex6 {

    public static void main(String[] args) {
        RandomList<Integer> rs = new RandomList<>();
        IntStream.range(1,10).forEach(rs::add);
        IntStream.range(1,10)
                .map(i-> rs.select())
                .forEach(System.out::println);
        RandomList<Object> rs2 = new RandomList<>();
        IntStream.range(1,10).forEach(rs2::add);
        IntStream.range(1,10).mapToObj(Double::new).forEach(rs2::add);
        IntStream.range(1,10)
                .mapToObj(i-> rs2.select())
                .forEach(System.out::println);
    }
}
