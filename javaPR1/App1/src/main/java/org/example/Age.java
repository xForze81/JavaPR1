package org.example;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class Age {
    private static LocalDate birthDate;
    private static Scanner in = new Scanner(System.in);
    public static void app() {
        System.out.println("Введите своё ФИО");
        String[] info = InputPersonalInfo();
        System.out.println(info[1] + info[2] + "\nВведите дату своего рождения в формате ГГГГ-ММ-ДД:");
        while (true) {
            System.out.print("Введите дату своего рождения в формате ГГГГ-ММ-ДД: ");
            String dateBorn = in.nextLine();
            try {
                birthDate = LocalDate.parse(dateBorn);
                break;
            } catch (Exception a) {
                System.out.println("Что-то не так. Попробуйте снова. \nДату рождения нужно ввести в формате ГГГГ-ММ-ДД");
            }
        }
        int age = calcAge(birthDate);
        if (age >= 18) {
            System.out.println("Вам есть 18 лет +");
        } else {
            System.out.println("Вам нет 18 лет -");
        }
    }
    private static int calcAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        int age = period.getYears();
        return age;
    }
    private static String[] InputPersonalInfo() {
        System.out.print("Введите свою фамилию: ");
        String SurName = in.nextLine();
        System.out.print("Введите свое имя: ");
        String Name = in.nextLine();
        System.out.print("Введите свое отчество: ");
        String MiddleName = in.nextLine();
        String[] info = {SurName, Name, MiddleName};
        return info;
    }
}