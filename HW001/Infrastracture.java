package HW001;

import java.util.ArrayList;

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

        return String.format("%d %s, %s, год рождения: %s, зарплата тыс.руб: %s, телефон: %s, место проживания: %s",
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
}