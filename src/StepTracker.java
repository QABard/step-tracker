
import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt(); // ввод и проверка номера месяца
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Введите число от 1 до 12");
            return;
        }
        MonthData monthData = monthToData[monthNumber - 1]; // получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц " + monthData.sumStepsFromMonth()); // вывод суммы шагов за месяц
        System.out.println("Максимальное количество шагов за день " + monthData.maxSteps()); // вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов за месяц " + (monthData.sumStepsFromMonth() / 30)); // вывод среднего пройденного количества шагов за месяц
        System.out.println("За месяц вы прошли " + converter.convertToKm(sumSteps) + " км"); // вывод пройденной за месяц дистанции в км
        System.out.println("За месяц вы потратили " + converter.convertStepsToKilocalories(sumSteps) + " Ккал"); // вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия за месяц " + monthData.bestSeries(goalByStepsPerDay) + " дней"); // вывод лучшей серии
        System.out.println(); //дополнительный перенос строки
    }

    void changeStepGoal() {
        System.out.println("Введите новое количество шагов в день");
        int stepGoal = scanner.nextInt();
        if (stepGoal < 1) {
            System.out.println("Введите число больше нуля");
            return;
        }
        goalByStepsPerDay = stepGoal;
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int monthNumber = scanner.nextInt();
        if (monthNumber > 12 || monthNumber < 1) {
            System.out.println("Введите число от 1 до 12");
        return;} // ввод и проверка номера месяца

        System.out.println("Введите день от 1 до 30 (включительно)");
        int dayNumber = scanner.nextInt();
        if (dayNumber > 30 || dayNumber < 1) {
        System.out.println("Вы ввели неправильное число. Введите день от 1 до 30 (включительно)");
        return;} // ввод и проверка дня

        System.out.println("Введите количество шагов");
        int stepNumber = scanner.nextInt();
        if (stepNumber < 0) {
            System.out.println("Количество шагов не может быть меньше нуля");
        return;}// ввод и проверка количества шагов

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1];
        // Сохранение полученных данных
        monthData.days[dayNumber - 1] = stepNumber;
    }
}
