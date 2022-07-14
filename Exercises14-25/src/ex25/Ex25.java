package ex25;

import ex25.d.D;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ex25 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object obj = D.makeD();

        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName() +" "+ method.invoke(obj));
        }
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field:fields){
            field.setAccessible(true);
            System.out.println("before " + field.getName() +"=" + field.get(obj));
            if (int.class.equals(field.getType())) {
                field.setInt(obj,field.getInt(obj)+1);
            } else if (float.class.equals(field.getType())) {
                field.setFloat(obj,field.getFloat(obj)+1);
            }else {
                field.setDouble(obj,field.getDouble(obj)+1);
            }
            System.out.println("after " + field.getName() +"=" + field.get(obj));
        }
    }
}
