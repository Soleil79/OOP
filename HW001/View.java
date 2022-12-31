package HW001;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class View {

    private StaffController staffController;    
    ChangeData changeData = new ChangeData();

    public StaffController getStaffController() {
        return staffController;
    }

    public View(StaffController staffController) {
        this.staffController = staffController;
    }

    public void choices() throws FileNotFoundException, UnsupportedEncodingException {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println(
                "\nВыберите действие:\n1 - Показать все записи;\n2 - Найти сотрудника по ФИО;\n3 - Добавить нового сотрудника; \n4 - Изменить запись; \n5 - Удалить запись;");
        System.out.println("\nВведите число:");
        int choice = in.nextInt();
        switch (choice) {
            case (1):
                staffController.printEmployers();
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
                System.out.println(
                        "\nВыберите должность из списка: \n1 - директор;\n2 - бухгалтер;\n3 - стилист;\n4 - парикмахер; \n5 - ресепшионист \n");
                System.out.println("\nВведите число:");
                int newposition = newEmp.nextInt();
                System.out.println("\nВведите год рождения **** ");
                int newdate = newEmp.nextInt();
                System.out.println("\nВведите зарплату в тыс.руб: ");
                int newsalary = newEmp.nextInt();
                System.out.println("\nВведите телефон без пробелов и тире: ");
                int newphone = newEmp.nextInt();
                System.out.println(
                        "\nВведите город проживания из списка: \n1 - Москва;\n2 - Санкт-Петербург;\n3 - Екатеринбург;\n4 - Саратов\n");
                System.out.println("\nВведите число:");
                int newresidence = newEmp.nextInt();
                Employee newem = new Employee(newname, newposition, newdate, newsalary, newphone, newresidence);
                staffController.addEmployee(newem);
                newEmp.close();
                break;
            case(4):
                Scanner change = new Scanner(System.in, "Cp866");
                staffController.printEmployers();
                System.out.println("\nВведите ID сотрудника, чьи данные вы хотите изменить:");                                
                int changeID = change.nextInt();
                System.out.println(
                        "\nЧто вы хотите поменять: \n1 - ФИО;\n2 - должность;\n3 - год рождения;\n4 - зарплату;\n5 - телефон;\n6 - город проживания\n");
                System.out.println("\nВведите число:");
                int changeParam = change.nextInt();

                if (changeParam == 1){
                    Scanner changename = new Scanner(System.in, "Cp866");
                    System.out.println("\nВведите новые Фамилию Имя и Отчество:");
                    String changeName = changename.nextLine();
                    staffController.nameChange(changeID, changeName);
                    changename.close();
                }
                if (changeParam == 2){
                    System.out.println(
                        "\nВыберите должность из списка: \n1 - директор;\n2 - бухгалтер;\n3 - стилист;\n4 - парикмахер; \n5 - ресепшионист \n");
                    System.out.println("\nВведите число:");
                    int changePost = change.nextInt();
                    staffController.positionChange(changeID, changePost);
                }
                if (changeParam == 3){
                    System.out.println("\nВведите новый год рождения:");
                    int changeDate = change.nextInt();
                    staffController.dateChange(changeID, changeDate);
                }
                if (changeParam == 4){
                    System.out.println("\nВведите новую зарплату (тыс.руб):");
                    int changeSalary = change.nextInt();
                    staffController.salaryChange(changeID, changeSalary);
                }
                if (changeParam == 5){
                    System.out.println("\nВведите новый телефон:");
                    int changePhone = change.nextInt();
                    staffController.phoneChange(changeID, changePhone);
                }
                if (changeParam == 6){                    
                    System.out.println(
                        "\nВыберите город проживания из списка: \n1 - Москва;\n2 - Санкт-Петербург;\n3 - Екатеринбург;\n4 - Саратов\n");
                    System.out.println("\nВведите число:");
                    int changeResidence = change.nextInt();
                    staffController.residenceChange(changeID, changeResidence);
                }
                change.close();
                break;
            
            case (5):
                Scanner delEmpl = new Scanner(System.in, "Cp866");
                staffController.printEmployers();
                System.out.println("\nВведите id сотрудника, которого вы хотите удалить: ");
                int delEmployee = in.nextInt();
                staffController.deleteEmployee(delEmployee);
                staffController.printEmployers();
                delEmpl.close();
                break;

        }
        in.close();
    }

}
