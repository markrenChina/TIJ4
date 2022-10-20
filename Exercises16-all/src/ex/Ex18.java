package ex;

public class Ex18 {

    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres1 = new BerylliumSphere[10];
        for (int i = 0; i < 10; i++) {
            berylliumSpheres1[i] = new BerylliumSphere();
        }
        BerylliumSphere[] berylliumSpheres2 = new BerylliumSphere[10];
        System.arraycopy(berylliumSpheres1,0,berylliumSpheres2,0,10);
        System.out.println(berylliumSpheres1[0]+ "'s == 0");
        System.out.println(berylliumSpheres2[0]+ "'s == 0");
        berylliumSpheres1[0] = new BerylliumSphere();
        System.out.println(berylliumSpheres1[0]+ "'s == 10");
        System.out.println(berylliumSpheres2[0] + "'s == 0");
    }
}
