public class Runner {

    public static void main(String[] args) {
        if (args.length == 0) {
            // Запуск програми в режимі взаємодії з користувачем
            CLI.main(new String[]{});
        } else if (args.length == 4) {
            // Запуск програми з переданими аргументами
            CLI.main(args);
        } else {
            System.out.println("Неправильна кількість аргументів. Використання: java -jar myApp.jar command filePath key");
        }
    }
}