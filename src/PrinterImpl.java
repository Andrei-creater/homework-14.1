public class PrinterImpl implements Printer {
    @Override
    public void print(Message message) {
        if ((message.getText() == null || message.getText().isEmpty()) &&
                (message.getSender() == null || message.getSender().isEmpty())) {

            new Object() {
                void processEmptyMessage() {
                    System.out.println("Опрацьовується пусте повідомлення від анонімного користувача...");
                }
            }.processEmptyMessage();
        } else if (message.getSender() == null || message.getSender().isEmpty()) {
            System.out.println("Анонімний користувач відправив повідомлення: " + message.getText());
        } else {
            System.out.println("Користувач " + message.getSender() + " відправив повідомлення: " + message.getText());
        }
    }

    public static void main(String[] args) {
        Printer printer = new PrinterImpl();

        Printer.Message anonymousMessage = new Printer.Message("Привіт!", null);
        printer.print(anonymousMessage);

        Printer.Message userMessage = new Printer.Message("Доброго дня!", "Іван");
        printer.print(userMessage);

        Printer.Message emptyMessage = new Printer.Message(null, null);
        printer.print(emptyMessage);
    }
}
