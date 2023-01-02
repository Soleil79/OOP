package HW001;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class View {
    Scanner userIn = new Scanner(System.in, "Cp866");
    Scanner strIn = new Scanner(System.in, "Cp866");
    private StaffController staffController;

    public StaffController getStaffController() {
        return staffController;
    }

    public View(StaffController staffController) {
        this.staffController = staffController;
    }

    public void choices() throws IOException {
       
        System.out.println("Программа для работы с базой данных сотрудников салона красоты");
        int choice = 0;
        while (choice != 6) {
            System.out.println(
                    "\nВыберите действие:\n1 - Показать все записи;\n2 - Найти сотрудника по ФИО;\n3 - Добавить нового сотрудника; \n4 - Изменить запись; \n5 - Удалить запись; \n6 - Выход");
            System.out.println("\nВведите число:");
            choice = inputInt();
            
            switch (choice) {
                case (1):
                    printEmployers(staffController.getAllEmployees());
                    break;
                case (2):                    
                    System.out.println("\nВведите Фамилию, Имя или Отчество сотрудника");
                    String searchName = inputString();
                    List<Employee> findPerson = staffController.findAll(searchName); 
                    if (!findPerson.isEmpty()){
                        printEmployers(findPerson);
                    }
                    else {
                        System.out.println("\nСотрудники не найдены!");
                    }                   
                    break;
                case (3):                    
                    System.out.println("\nВведите Фамилию, Имя и Отчество сотрудника: ");
                    String newname = inputString();
                    System.out.println(
                            "\nВыберите должность из списка: \n1 - директор;\n2 - бухгалтер;\n3 - стилист;\n4 - парикмахер; \n5 - ресепшионист \n");
                    System.out.println("\nВведите число:");
                    int newposition = inputInt();
                    System.out.println("\nВведите год рождения **** ");
                    int newdate = inputInt();
                    System.out.println("\nВведите зарплату в тыс.руб: ");
                    int newsalary = inputInt();
                    System.out.println("\nВведите телефон без пробелов и тире: ");
                    int newphone = inputInt();
                    System.out.println(
                            "\nВведите город проживания из списка: \n1 - Москва;\n2 - Санкт-Петербург;\n3 - Екатеринбург;\n4 - Саратов\n");
                    System.out.println("\nВведите число:");
                    int newresidence = inputInt();
                    Employee newem = new Employee(newname, newposition, newdate, newsalary, newphone, newresidence);
                    staffController.addEmployee(newem); 
                    System.out.printf("\nСотрудник %s успешно добавлен в базу данных", newname);                
                    break;
                case (4):                    
                    printEmployers(staffController.getAllEmployees());
                    System.out.println("\nВведите ID сотрудника, чьи данные вы хотите изменить:");
                    int changeID = inputInt();
                    System.out.println(
                            "\nЧто вы хотите поменять: \n1 - ФИО;\n2 - должность;\n3 - год рождения;\n4 - зарплату;\n5 - телефон;\n6 - город проживания\n");
                    System.out.println("\nВведите число:");
                    int changeParam = inputInt();

                    if (changeParam == 1) {                      
                        System.out.println("\nВведите новые Фамилию Имя и Отчество:");
                        String changeName = inputString();
                        staffController.stringChange(changeParam, changeID, changeName);
                    }
                    if (changeParam == 2) {                       
                        System.out.println(
                                "\nВыберите должность из списка: \n1 - директор;\n2 - бухгалтер;\n3 - стилист;\n4 - парикмахер; \n5 - ресепшионист \n");
                        System.out.println("\nВведите число:");
                        int changePost = inputInt();
                        staffController.dataChange(changeParam, changeID, changePost);                        
                    }
                    if (changeParam == 3) {
                        System.out.println("\nВведите новый год рождения:");
                        int changeDate = inputInt();
                        staffController.dataChange(changeParam, changeID, changeDate);
                    }
                    if (changeParam == 4) {
                        System.out.println("\nВведите новую зарплату (тыс.руб):");
                        int changeSalary = inputInt();
                        staffController.dataChange(changeParam, changeID, changeSalary);
                    }
                    if (changeParam == 5) {
                        System.out.println("\nВведите новый телефон:");
                        int changePhone = inputInt();
                        staffController.dataChange(changeParam, changeID, changePhone);
                    }
                    if (changeParam == 6) {
                        System.out.println(
                                "\nВыберите город проживания из списка: \n1 - Москва;\n2 - Санкт-Петербург;\n3 - Екатеринбург;\n4 - Саратов\n");
                        System.out.println("\nВведите число:");
                        int changeResidence = inputInt();
                        staffController.dataChange(changeParam, changeID, changeResidence);
                    }                    
                    break;

                case (5):                   
                    printEmployers(staffController.getAllEmployees());
                    System.out.println("\nВведите id сотрудника, которого вы хотите удалить: ");
                    int delEmployee = inputInt();
                    staffController.deleteEmployee(delEmployee);
                    System.out.printf("\nСотрудник с ID:%d успешно удален из базы данных", delEmployee);    
                    printEmployers(staffController.getAllEmployees());                   
                    break;

            }

        }
        
    }
    
    private int inputInt(){        
        int inputInt = userIn.nextInt();
        return inputInt;
    }

    private String inputString(){        
        String inputStr = strIn.nextLine();        
        return inputStr;
    }

    public void printEmployers(List <Employee> employees) {
        
        for (Employee line : employees) {
            System.out.println(staffController.getInfo(line));
        }
    }

    public void intScanClose(){
        userIn.close();
    }
    
    public void strScanClose(){
        strIn.close();
    }
}
