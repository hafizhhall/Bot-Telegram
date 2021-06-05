import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class BotClass extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "ngantukan_bot";
    }

    public String getBotToken() {
        return "1475556829:AAHCjKG3_KGBMd89TWMoONDGGI2R1cWBVWY";
    }

    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        if(command.equals("/fristname")){
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        }
        if(command.equals("/lastname")){
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        }
        if(command.equals("/fullname")){
            System.out.println(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName()+" "+update.getMessage().getFrom().getLastName());
        }
        if(command.equals("/id")){
            System.out.println(update.getMessage().getFrom().getId());
            message.setText(String.valueOf(update.getMessage().getFrom().getId()));
        }

        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
