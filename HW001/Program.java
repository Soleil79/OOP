package HW001;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Infrastructure infrastructure = new Infrastructure();

        System.out.println(infrastructure.getAllInfo(1));
        System.out.println(infrastructure.getAllInfo(2));
        System.out.println(infrastructure.getAllInfo(3));
        System.out.println(infrastructure.getAllInfo(4));
        System.out.println(infrastructure.getAllInfo(5));
        System.out.println(infrastructure.getAllInfo(6));
        System.out.println(infrastructure.getAllInfo(7));
   
        Scanner in = new Scanner(System.in, "Cp866"); 
        System.out.println("\nДля поиска по базе сотрудников введите Фамилию, Имя или их часть: ");
        String findName = in.nextLine();
        in.close();
        infrastructure.findAll(findName);

    }
}
