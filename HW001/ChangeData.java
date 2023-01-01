package HW001;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ChangeData {

    private Db db;
    WriteFile writeFile = new WriteFile(db);

    public ChangeData(Db db, WriteFile writeFile) {
        this.db = db;
        this.writeFile = writeFile;

    }

    public void nameChange(int id, String newName) throws IOException {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.name = newName;

            }
            writeFile.writeF();
        }
    }

    public void positionChange(int id, int newPosition) throws FileNotFoundException, UnsupportedEncodingException {

        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.position = newPosition;
            }

            writeFile.writeF();
        }
    }

    public void dateChange(int id, int newDate) throws FileNotFoundException, UnsupportedEncodingException {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.birthdate = newDate;
            }
            writeFile.writeF();
        }
    }

    public void salaryChange(int id, int newSalary) throws FileNotFoundException, UnsupportedEncodingException {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.salary = newSalary;
            }
            writeFile.writeF();
        }
    }

    public void phoneChange(int id, int newPhone) throws FileNotFoundException, UnsupportedEncodingException {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.phone = newPhone;
            }
            writeFile.writeF();
        }
    }

    public void residenceChange(int id, int newResidence) throws FileNotFoundException, UnsupportedEncodingException {
        for (Employee employee : db.employees) {
            if (employee.id == id) {
                employee.residence = newResidence;
            }
            writeFile.writeF();
        }
    }

}
