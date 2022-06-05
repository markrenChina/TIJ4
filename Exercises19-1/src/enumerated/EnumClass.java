package enumerated;

enum Shrubbery { GROUND, CRAWLING, HANGING }

public class EnumClass {
    public static void main(String[] args) {
        //values返回enum实例数组
        for (Shrubbery s : Shrubbery.values()){
            //ordinal 返回一个int值，声明时的次序
            System.out.println(s + " ordinal: " + s.ordinal());
            //实现了Comparable接口，同时还实现了Serializable接口
            System.out.println(s.compareTo(Shrubbery.CRAWLING) + " ");
            //编译器自动生成 equals和hashcode方法
            System.out.println(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("------------------------");
        }
        //Produce an enum value from a string name;
        for (String s : "GROUND CRAWLING HANGING".split(" ")) {
            //valueOf是Enum中的static方法
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrub);
        }
    }
}
