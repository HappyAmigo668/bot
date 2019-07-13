import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static java.awt.DefaultKeyboardFocusManager.sendMessage;

public class Bot extends TelegramLongPollingBot implements Configuration{

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return API_TOKEN;
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();



//        if (update.hasMessage() && update.getMessage().hasText()) {
//
//            String message_text = update.getMessage().getText();
//            long chat_id = update.getMessage().getChatId();
//
//            SendMessage message = new SendMessage()
//                    .enableMarkdown(true)
//                    .setChatId(chat_id)
//                    .setText(message_text);
//            try {
//                execute(message);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void sendMsg(Message message, String test){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(test);
        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }


}
