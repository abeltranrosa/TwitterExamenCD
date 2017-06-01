package miaplicaciontwiter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author antonio
 */
public class ClaseTwitter {

    /**
     * metodo para publicar el twit que desees
     * @param twitter 
     */
    public void mensajeDirecto(Twitter twitter) {

        DirectMessage message;
        try {
            message = twitter.sendDirectMessage("buenos dias chicos", "hoy hace un dia estupendo");
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
        } catch (TwitterException ex) {
            Logger.getLogger(MiaplicacionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para que twitter muestre los primeros twits
     *
     * @throws TwitterExcepcion
     */
    public void verTimelime(Twitter twitter) {

        try {
            List<Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText() + status.getCreatedAt());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(MiaplicacionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo para publicar un Tweet que desees escribir
     *
     * @throws TwitterExcepcion
     */
    public void postearTweet(Twitter twitter) {

        try {
            twitter.updateStatus(JOptionPane.showInputDialog("Escribe tu tweet"));
        } catch (TwitterException ex) {
            Logger.getLogger(MiaplicacionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * metodo buscar que sirve para localizar twits por letas, palabras o del modo que desees
 * @param twitter 
 */
    public void buscar(Twitter twitter) {
        try {
            Query query = new Query("#hola mundo");
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(MiaplicacionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
