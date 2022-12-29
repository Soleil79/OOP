package HW001;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File("staff.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    
    public Employee map(String line) {
        String[] lines = line.split(",");
        int id = Integer.parseInt(lines[0]);
        int position = Integer.parseInt(lines[2]);
        int birthdate = Integer.parseInt(lines[3]);
        int salary = Integer.parseInt(lines[4]);
        int phone = Integer.parseInt(lines[5]);
        int residence = Integer.parseInt(lines[6]);


        return new Employee(id, lines[1], position, birthdate, salary, phone, residence);
    }
    
    public ArrayList<Employee> readList (List<String> list){
        ArrayList<Employee> employees = new ArrayList<>();
        for (String line: list){
            Employee employee = map(line);
            employees.add(employee);
        }
                
        return employees;        
    }

    public void PrintEmplList (List<Employee> empList){
        for (Employee line: empList){
            System.out.println(line);
        }
    }
        
}