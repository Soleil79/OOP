package HW001;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class StaffController {
    private Db db;
    private WriteFile writeF;
    ChangeData changeData = new ChangeData(db, writeF);

    public Db getDb() {
        return db;
    }

    public StaffController(Db db, WriteFile writeF, ChangeData changeData) {
        this.db = db;
        this.writeF = writeF;
        this.changeData = changeData;
    }

    public String getInfo(Employee em) {
        return db.getAllInfo(em);
    }

    public List<Employee> findAll(String word) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : db.employees) {
            if (employee.name.toLowerCase().indexOf(word.toLowerCase()) != -1) {
                foundEmployees.add(employee);                
            }
        }
        return foundEmployees;
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

    // Обнуление сотрудника перед удалением
    public Employee ResetEmployee(int id) {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                return employee;
            }
        }
        return null;
    }


    public void dataChange(int choice, int id, int data) throws FileNotFoundException, UnsupportedEncodingException {

        if (choice == 2) {
            changeData.positionChange(id, data);
        }
        if (choice == 3) {
            changeData.dateChange(id, data);
        }
        if (choice == 4) {
            changeData.salaryChange(id, data);
        }
        if (choice == 5) {
            changeData.phoneChange(id, data);
        }
        if (choice == 6) {
            changeData.residenceChange(id, data);
        }

    }

    public void stringChange(int choice, int id, String data) throws IOException {
        if (choice == 1) {
            changeData.nameChange(id, data);
        }
    }

    public List<Employee> getAllEmployees() {
        return db.employees;
    }

}

// alt shift f - автоформат