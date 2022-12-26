package HW01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

class Infrastructure {

    public void findAll(String word) {
        ArrayList<Employee> employees = new ArrayList<>();
        int count = 0;
        for (Employee employee : db.employees) {
            if (employee.name.toLowerCase().indexOf(word.toLowerCase()) != -1) {
                employees.add(employee);
                System.out.println(getAllInfo(employee.id));
                count++;
            }
        }
        if (count < 1) {
            System.out.println("Совпадения не найдены");
        }
    }

    public Infrastructure() {
        init();
    }

    Db db;

    public Db getDb() {
        return db;
    }

    public String getAllInfo(int idEmployee) {
        Employee em = db.employees.get(idEmployee - 1);

        return String.format("id:%d, ФИО: %s, Должность: %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
            em.id,
            em.name,
            db.positions.get(em.position - 1).post,
            em.birthdate,
            em.salary,
            em.phone,
            db.residences.get(em.residence - 1).city);
            
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

    public void  choices() {
        Scanner in = new Scanner(System.in, "Cp866"); 
        System.out.println("\nВыберите действие:\n1 - Показать все записи;\n2 - Найти сотрудника по ФИО;\n3 - Добавить нового сотрудника; \n4 - Изменить запись; \n5 - Удалить запись;");
        System.out.println("\nВведите число:");
        int choice = in.nextInt();
        switch (choice){
            case (1):
                printall();
                break;
            case (2):
                Scanner name = new Scanner(System.in, "Cp866"); 
                System.out.println("\nВведите Фамилию, Имя или Отчество сотрудника");
                String searchName = name.nextLine();
                findAll(searchName);
                name.close();
                break;
            case (3):
                Scanner newEmp = new Scanner(System.in, "Cp866"); 
                System.out.println("\nВведите Фамилию, Имя и Отчество сотрудника: ");
                String newname = newEmp.nextLine();
                System.out.println("\nВыберите должность из списка: \n1 - директор;\n2 - бухгалтер;\n3 - стилист;\n4 - парикмахер; \n5 - ресепшионист \n");               
                int newposition = newEmp.nextInt();                
                System.out.println("\nВведите год рождения **** ");
                int newdate = newEmp.nextInt();
                System.out.println("\nВведите зарплату в тыс.руб: ");
                int newsalary = newEmp.nextInt();
                System.out.println("\nВведите телефон без пробелов и тире: ");
                int newphone = newEmp.nextInt();
                System.out.println("\nВведите город проживания из списка: \n1 - Москва;\n2 - Санкт-Петербург;\n3 - Екатеринбург;\n4 - Саратов\n");
                int newresidence = newEmp.nextInt();
                
                int newid = lastIndex()+1;
                Employee newem = new Employee(newid, newname, newposition, newdate, newsalary, newphone, newresidence);
                db.employees.add(newem);
                printall();
                try {
                    writeF();
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                newEmp.close();
                break;
            case(5):
            Scanner delEmpl = new Scanner(System.in, "Cp866");
            printall();
            System.out.println("\nВведите id сотрудника, которого вы хотите удалить: ");
            int delEmployee = in.nextInt();
            
            for (Employee employee: db.employees){
                if (employee.id == delEmployee){
                    db.employees.remove(employee);
                    break;
                }
            }                       
            printall();
                try {
                    writeF();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            delEmpl.close();
            break;

        }
        in.close();
    }
    
    public int lastIndex() {        
        int maxId = 0;
        for (Employee employee : db.employees){                         
           if (employee.id > maxId){
            maxId = employee.id;
           }           
        }        
        return maxId;
    }


    public void printall(){
        for (Employee employee: db.employees){                
            System.out.println(getAllInfo(employee.id));
        }
    }
  

}