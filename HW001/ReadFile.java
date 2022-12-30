package HW001;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    Db db = new Db();

    public List<String> readAllLines() throws IOException {
        List<String> lines = new ArrayList<>();
        // try {
        File file = new File("staff.txt");
        // создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        // создаем BufferedReader с существующего FileReader для построчного считывания
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
        return lines;

    }

    public Employee map(String line) {

        String[] lines = line.split(", |: |:");

        int id = Integer.parseInt(lines[1]);
        String name = lines[3];
        int position = PositionGetId(lines[5]);
        int birthdate = Integer.parseInt(lines[7]);
        int salary = Integer.parseInt(lines[9]);
        int phone = Integer.parseInt(lines[11]);
        int residence = ResidenceGetId(lines[13]);

        Employee newEmpl = new Employee(id, name, position, birthdate, salary, phone, residence);

        return newEmpl;

    }

    public ArrayList<Employee> readList(List<String> list) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (String line : list) {
            Employee employee = map(line);
            employees.add(employee);
        }

        return employees;
    }

    public int PositionGetId(String word) {        
        int newpos = 0;
        for (Position pos : db.positions)
            if (pos.post.contains(word)) {
                newpos = pos.id;
            }
        return newpos;
    }

    public int ResidenceGetId(String word) {
        int newres = 0;
        for (Residence res : db.residences)
            if (res.city.contains(word)) {
                newres = res.id;
            }
        return newres;
    }

}