package HW001;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
// import java.util.ArrayList;
// import java.util.List;


public class StaffController {
    Employee newem = new Employee(0, null, 0, 0, 0, 0, 0);

    private Db db;    
    private WriteFile writeF;
    ReadFile ReadFile = new ReadFile();

    public Db getDb() {
        return db;
    }

    public StaffController(Db db, WriteFile writeF) {
        this.db = db;
        this.writeF = writeF;
    }

    
    public String getInfo(Employee em) {      
        return db.getAllInfo(em);
    }

    public void findAll(String word) {
        // List<Employee> employees = new ArrayList<>();
        int count = 0;
        for (Employee employee : db.employees) {
            if (employee.name.toLowerCase().indexOf(word.toLowerCase()) != -1) {
                // employees.add(employee);
                System.out.println(getInfo(employee));
                count++;
            }
        }
        if (count < 1) {
            System.out.println("Совпадения не найдены"); // to do exceptions
        }
    }

    public int lastIndex() {
        int maxId = 0;
        for (Employee employee : db.employees) {
            if (employee.id > maxId) {
                maxId = employee.id;
            }
        }
        return maxId;
    }

    public void addEmployee(Employee em) throws FileNotFoundException, UnsupportedEncodingException {
        int newid = lastIndex() + 1;
        em.setId(newid);
        db.employees.add(em);
        writeF.writeF();
    }

    public void deleteEmployee(int id) throws FileNotFoundException, UnsupportedEncodingException {
        Employee foundEm = ResetEmployee(id);
        db.employees.remove(foundEm);
        writeF.writeF();
    }

    //Обнуление сотрудника перед удалением
    public Employee ResetEmployee(int id) {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }

    public void printEmployers (){            
        for (Employee line: db.employees){
            System.out.println(getInfo(line));
        }    

    }   

// Методы замены параметров сотрудников
    public void nameChange(int id, String newName) throws FileNotFoundException, UnsupportedEncodingException{           
        for (Employee em: db.employees){
            if (em.id == id){
                em.name = newName;                           
            }      
        writeF.writeF();       
        }
    }

    public void positionChange(int id, int newPosition) throws FileNotFoundException, UnsupportedEncodingException{
        for (Employee em: db.employees){
            if (em.id == id){
                em.position = newPosition;               
            }  
       
        writeF.writeF();       
        }
    }

    public void dateChange(int id, int newDate) throws FileNotFoundException, UnsupportedEncodingException{
        for (Employee employee: db.employees){
            if (employee.id == id){
                employee.birthdate = newDate;               
            }      
        writeF.writeF();       
        }
    }

    public void salaryChange(int id, int newSalary) throws FileNotFoundException, UnsupportedEncodingException{
        for (Employee employee: db.employees){
            if (employee.id == id){
                employee.salary = newSalary;               
            }      
        writeF.writeF();       
        }
    }

    public void phoneChange(int id, int newPhone) throws FileNotFoundException, UnsupportedEncodingException{
        for (Employee employee: db.employees){
            if (employee.id == id){
                employee.phone = newPhone;               
            }      
        writeF.writeF();       
        }      
    }

    public void residenceChange(int id, int newResidence) throws FileNotFoundException, UnsupportedEncodingException{
        for (Employee employee: db.employees){
            if (employee.id == id){
                employee.residence = newResidence;               
            }      
        writeF.writeF();       
        }     
    }

}

// alt shift f - автоформат