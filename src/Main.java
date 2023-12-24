import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ИгрушечныйРозыгрыш розыгрыш = new ИгрушечныйРозыгрыш();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить игрушку\n2. Изменить вес игрушки\n3. Провести розыгрыш\n4. Получить призовую игрушку\n5. Выход");
            int выбор = scanner.nextInt();

            switch (выбор) {
                case 1:
                    scanner.nextLine(); // очистка буфера
                    int id = вводЦелогоЧисла(scanner, "Введите ID (только цифры): ");
                    String название = вводСтроки(scanner, "Введите название (только буквы): ");
                    int количество = вводЦелогоЧисла(scanner, "Введите количество (только цифры): ");
                    double вес = вводДробногоЧисла(scanner, "Введите вес (только цифры): ");

                    Игрушка новаяИгрушка = new Игрушка(id, название, количество, вес);
                    розыгрыш.добавитьИгрушку(новаяИгрушка);
                    System.out.println("Добавлена игрушка: " + новаяИгрушка);
                    break;
                case 2:
                    System.out.println("Введите ID игрушки и новый вес:");
                    int idИгрушки = scanner.nextInt();
                    double новыйВес = scanner.nextDouble();
                    розыгрыш.изменитьВес(idИгрушки, новыйВес);
                    break;
                case 3:
                    розыгрыш.розыгрыш();
                    break;
                case 4:
                    Игрушка призовая = розыгрыш.получитьПризовуюИгрушку();
                    if (призовая != null) {
                        System.out.println("Призовая игрушка: " + призовая.getНазвание());
                        записатьВФайл(призовая); // Метод для записи в файл
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    public static void записатьВФайл(Игрушка игрушка) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("призы.txt", true))) {
            String info = String.format("ID: %d, Название: %s, Количество: %d, Вес: %.2f%n",
                    игрушка.getId(), игрушка.getНазвание(),
                    игрушка.getКоличество(), игрушка.getВес());
            writer.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int вводЦелогоЧисла(Scanner scanner, String сообщение) {
        System.out.print(сообщение);
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите число!");
            scanner.next(); // очистка некорректного ввода
            System.out.print(сообщение);
        }
        return scanner.nextInt();
    }

    private static double вводДробногоЧисла(Scanner scanner, String сообщение) {
        System.out.print(сообщение);
        while (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введите число!");
            scanner.next(); // очистка некорректного ввода
            System.out.print(сообщение);
        }
        return scanner.nextDouble();
    }

    private static String вводСтроки(Scanner scanner, String сообщение) {
        System.out.print(сообщение);
        String ввод = scanner.nextLine();
        while (!ввод.matches("[А-Яа-яA-Za-z ]+")) {
            System.out.println("Ошибка: используйте только буквы!");
            System.out.print(сообщение);
            ввод = scanner.nextLine();
        }
        return ввод;
    }
}
