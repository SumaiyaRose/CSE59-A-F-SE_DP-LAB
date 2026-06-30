interface MessageSender {
    void sendMessage(String message);
}

class EmailSender implements MessageSender {

    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NotificationService {
    private MessageSender messageSender;

    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void alertUser(String msg) {
        messageSender.sendMessage(msg);
    }
 
}


public class Main2 {

    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        
        NotificationService notificationService = new NotificationService(emailSender);

        notificationService.alertUser("Your order has been shipped!");
    }
    
}

