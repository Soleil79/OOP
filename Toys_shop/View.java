package Toys_shop;

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
       
        System.out.println("Программа для работы с базой данных игрушек");
        int choice = 0;
        while (choice != 9) {
            System.out.println(
                    "\nВыберите действие:\n1 - Показать все игрушки в наличии;\n2 - Найти игрушку по названию;\n3 - Добавить новую игрушку; \n4 - Изменить запись; \n5 - Удалить запись; \n6 - Розыгрыш; \n7 - Показать список призов; \n8 - Получить приз; \n9 - Выход");
            System.out.println("\nВведите число:");
            choice = inputInt();
            
            switch (choice) {
                case (1):
                    printToys(staffController.getAllToys());
                    break;
                case (2):                    
                    System.out.println("\nВведите название игрушки");
                    String searchName = inputString();
                    List<Toy> findToy = staffController.findAll(searchName); 
                    if (!findToy.isEmpty()){
                        printToys(findToy);
                    }
                    else {
                        System.out.println("\nИгрушка не найдена!");
                    }                   
                    break;
                case (3):                    
                    System.out.println("\nВведите название игрушки: ");
                    String newname = inputString();
                    System.out.println(
                            "\nВыберите целевое назначение игрушки: \n1 - для школьников;\n2 - для дошкольников \n");
                    System.out.println("\nВведите число:");
                    int newage = inputInt();
                    System.out.println("\nВведите шанс выпадения: ");
                    int newdroprate = inputInt();
                    System.out.println("\nВведите количество штук: ");
                    int newquantity = inputInt();
                    Toy newtoy = new Toy(newname, newage, newdroprate, newquantity);
                    staffController.addToy(newtoy); 
                    System.out.printf("\nСотрудник %s успешно добавлен в базу данных", newname);                
                    break;
                case (4):                    
                    printToys(staffController.getAllToys());
                    System.out.println("\nВведите ID игрушки, которую вы хотите изменить:");
                    int changeID = inputInt();
                    System.out.println(
                            "\nЧто вы хотите поменять: \n1 - название;\n2 - целевой возраст;\n3 - шанс на выигрыш\n");
                    System.out.println("\nВведите число:");
                    int changeParam = inputInt();

                    if (changeParam == 1) {                      
                        System.out.println("\nВведите новое название:");
                        String changeName = inputString();
                        staffController.stringChange(changeParam, changeID, changeName);
                    }
                    if (changeParam == 2) {                       
                        System.out.println(
                                "\nВыберите целевой возраст из списка: \n1 - для школьников;\n2 - для дошкольников \n");
                        System.out.println("\nВведите число:");
                        int changeAge = inputInt();
                        staffController.dataChange(changeParam, changeID, changeAge);                        
                    }
                    if (changeParam == 3) {
                        System.out.println("\nВведите новый коэфициент шанса на выигрыш:");
                        int changeDroprate = inputInt();
                        staffController.dataChange(changeParam, changeID, changeDroprate);
                    }
                                    
                    break;

                case (5):                   
                    printToys(staffController.getAllToys());
                    System.out.println("\nВведите id игрушки, которую вы хотите удалить: ");
                    int delToy = inputInt();
                    staffController.deleteToy(delToy);
                    System.out.printf("\nИгрушка с ID:%d успешно удалена из базы данных\n", delToy);    
                    printToys(staffController.getAllToys());                   
                    break;

                case (6):                   
                    printToys(staffController.getAllToys());
                    System.out.println("\nВведите id игрушки, которую вы хотите выиграть: ");
                    int winToy = inputInt();
                    staffController.lottery(winToy);                 
                    break;  

                case (7): 
                    System.out.println("Список выигранных призов: ");   
                    printWinToys(staffController.ReadPrize());                                             
                    break; 
                
                case (8):                   
                    printWinToys(staffController.ReadPrize());
                    System.out.println("\nВведите id игрушки, которую вы хотите получить: ");
                    int getToy = inputInt();
                    staffController.getPrize(getToy);                 
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

    public void printToys(List <Toy> toys) {
        
        for (Toy line : toys) {
            System.out.println(staffController.getInfo(line));
        }
    }

    
    public void printWinToys(List <Toy> toys) {
        
        for (Toy line : toys) {
            System.out.println(staffController.getMinInfo(line));
        }
    }

    public void intScanClose(){
        userIn.close();
    }
    
    public void strScanClose(){
        strIn.close();
    }
}
