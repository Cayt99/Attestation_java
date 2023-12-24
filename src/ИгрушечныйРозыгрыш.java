import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ИгрушечныйРозыгрыш {
    private List<Игрушка> игрушки;
    private List<Игрушка> призы;

    public ИгрушечныйРозыгрыш() {
        игрушки = new ArrayList<>();
        призы = new ArrayList<>();
    }

    public void добавитьИгрушку(Игрушка игрушка) {
        игрушки.add(игрушка);
    }

    public void изменитьВес(int id, double новыйВес) {
        for (Игрушка игрушка : игрушки) {
            if (игрушка.getId() == id) {
                игрушка.setВес(новыйВес);
                break;
            }
        }
    }

    public void розыгрыш() {
        if (игрушки.isEmpty()) {
            System.out.println("Список игрушек пуст. Невозможно провести розыгрыш.");
            return;
        }

        double totalWeight = 0.0;
        for (Игрушка игрушка : игрушки) {
            totalWeight += игрушка.getВес();
        }

        double randomValue = new Random().nextDouble() * totalWeight;
        for (Игрушка игрушка : игрушки) {
            randomValue -= игрушка.getВес();
            if (randomValue <= 0.0) {
                призы.add(игрушка);
                System.out.println("Призовая игрушка: " + игрушка.getНазвание());
                return;
            }
        }

        System.out.println("Не удалось выбрать призовую игрушку.");
    }

    public Игрушка получитьПризовуюИгрушку() {
        if (!призы.isEmpty()) {
            Игрушка призовая = призы.remove(0);
            призовая.setКоличество(призовая.getКоличество() - 1);
            return призовая;
        }
        return null; // Или обработка ситуации, когда призов нет
    }
}
