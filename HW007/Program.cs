using System;


public class Program {
    static void Main() {
          Person grandma1 = new Person(1, "Иванова Анна Павловна", 2, 1910, 1);
        Person grandpa1 = new Person(2, "Иванов Иван Иванович", 1, 1908, 1);
        Person grandma2 = new Person(1, "Петрова Инна Валерьевна", 2, 1912, 2);
        Person grandpa2 = new Person(2, "Петров Петр Петрович", 1, 1911, 2);
        Person ma = new Person(1, "Петрова Мария Ивановна", 2, 1958, 3, grandma1, grandpa1);
        Person pa = new Person(1, "Петров Игорь Петрович", 2, 1955, 3, grandma2, grandpa2);
        Person me = new Person(1, "Петров Василий Игоревич", 2, 1980, 3, ma, pa);

        Console.WriteLine(me);
    }
}