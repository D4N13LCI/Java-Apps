import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class AnonymousSMS {

    // Tu Account SID y Auth Token de twilio.com/console
    public static final String ACCOUNT_SID = "ACxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; // Reemplaza
    public static final String AUTH_TOKEN = "your_auth_token"; // Reemplaza

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Numero de telefono proporcionado por Twilio
        String twilioPhoneNumber = "+1234567890"; //Reemplaza
        // Numero al que enviaremos el SMS
        String recipientPhoneNumber = "+11234567890"; //Reemplaza
        String messageBody = "Mensaje SMS anonimo (casi)";


        Message message = Message.creator(
                new PhoneNumber(recipientPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                messageBody)
            .create();

        System.out.println(message.getSid());
    }
}