package HW001;

import java.util.Scanner;

public class View {
    private StaffController staffController;
    
    public StaffController getStaffController() {
        return staffController;
    }
    public View  (StaffController staffController){
        this.staffController = staffController;
    }

    public void  choices() {
        Scanner in = new Scanner(System.in, "Cp866"); 
        System.out.println("\nВыберите действие:\n1 - Показать все записи;\n2 - Найти сотрудника по ФИО;\n3 - Добавить нового сотрудника; \n4 - Изменить запись; \n5 - Удалить запись;");
        System.out.println("\nВведите число:");
        int choice = in.nextInt();
        switch (choice){
            case (1):
                staffController.printall();
                break;
            case (2):
                Scanner name = new Scanner(System.in, "Cp866"); 
                System.out.println("\nВведите Фамилию, Имя или Отчество сотрудника");
                String searchName = name.nextLine();
                staffController.findAll(searchName);
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
               
                Employee newem = new Employee(newname, newposition, newdate, newsalary, newphone, newresidence); 
                staffController.addEmployee(newem);
                newEmp.close();
                break;
            case(5):
            Scanner delEmpl = new Scanner(System.in, "Cp866");
            staffController.printall();
            System.out.println("\nВведите id сотрудника, которого вы хотите удалить: ");
            int delEmployee = in.nextInt();
            staffController.deleteEmployee(delEmployee);
                            
            staffController.printall();
               
            delEmpl.close();
            break;

        }
        in.close();
    }


}
