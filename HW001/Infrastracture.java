package HW001;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

class Infrastructure {


    public Infrastructure() {
        init();
    }

    Db db;

    public Db getDb() {
        return db;
    }

  

    Db init() {
        db = new Db();
        
        Employee e1 = new Employee(1, "Иванов Иван Иванович", 1, 1980, 100, 123, 1);
        Employee e2 = new Employee(2, "Самойлова Анна Ильинична", 2, 1976, 90, 456, 3);
        Employee e3 = new Employee(3, "Забывайло Виктор Семенович", 3, 1980, 100, 677, 2);
        Employee e4 = new Employee(4, "Раскольников Иван Геннадьевич", 3, 1980, 100, 322, 1);
        Employee e5 = new Employee(5, "Смирнова Антонина Семеновна", 4, 1980, 100, 888, 4);
        Employee e6 = new Employee(6, "Иванова Алла Александровна", 5, 1990, 100, 963, 2);
        Employee e7 = new Employee(7, "Разумейко Петр Иванович", 4, 1980, 100, 152, 1);



        db.employees.add(e1);
        db.employees.add(e2);
        db.employees.add(e3);
        db.employees.add(e4);
        db.employees.add(e5);
        db.employees.add(e6);
        db.employees.add(e7);


        db.residences.add(new Residence(1, "Москва"));
        db.residences.add(new Residence(2, "Санкт-Петербург"));
        db.residences.add(new Residence(3, "Екатеринбург"));
        db.residences.add(new Residence(4, "Саратов"));

        db.positions.add(new Position(1, "Директор"));
        db.positions.add(new Position(2, "Бухгалтер"));
        db.positions.add(new Position(3, "Стилист"));
        db.positions.add(new Position(4, "Парикмахер"));
        db.positions.add(new Position(5, "Ресепшионист"));

        return db;
    }
    

   
    public void writeF() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("staff.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Employee employee : db.employees){
                pw.println(getAllInfo(employee.id));
            }
        }                                                                                                  
        
    }
   
    // public void readF() throws FileNotFoundException, UnsupportedEncodingException {
    //     File file = new File("staff.txt");
    //     try (FileReader fr = new FileReader(file)) {
    //         Scanner scan = new Scanner(fr);
    //         while (scan.hasNext()){
    //             db.employees.add(scan.next());
    //         }
    //         scan.close();
    //     }
        
    // }


    



    public void printall(){
        for (Employee employee: db.employees){                
            System.out.println(getAllInfo(employee.id));
        }
    }
  

}