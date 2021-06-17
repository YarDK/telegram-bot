package src.oneclass;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());

            ChromeChek cc = new ChromeChek();
            String url = "https://www.citilink.ru/product/igrovaya-konsol-playstation-5-digital-edition-ps719398806-belyi-cherny-1476354/";
            cc.init(url);
            System.out.println("init gone");
            cc.checker();
            System.out.println("checker gone");
            message.setText(cc.getResult());

            try {
                execute(message); // Call method to send the message
                cc.stop();
            } catch (TelegramApiException e) {
                e.printStackTrace();
                cc.stop();
            }
        }
    }

    /*@Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }*/

    @Override
    public String getBotUsername() {
        return "Ps5yardk_bot";
    }

    @Override
    public String getBotToken() {
        return "1850446193:AAFPb7mzekHn1oHoQpENdy6cm9o2MvBZRH4";
    }
}
