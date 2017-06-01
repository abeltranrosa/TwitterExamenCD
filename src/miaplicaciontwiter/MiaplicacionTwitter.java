package miaplicaciontwiter;

/**
 *
 * @author antonio
 */
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.DirectMessage;  
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MiaplicacionTwitter {

    /**
     * 
     * @param args
     * @throws TwitterException 
     */
    public static void main(String[] args) throws TwitterException {

        //Creacion del objeto Builder de config.
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("TzMVTDWP5sul9yC6TL8B4gWbP")
                .setOAuthConsumerSecret("TVAN6wpJaDqrZqABHAxt8kGaqUTcmAYep7x75tfdfXiy3jg7Rw")
                .setOAuthAccessToken("848798219320643584-JsTBXEn9IAxyZtd00tAQK395DENULOi")
                .setOAuthAccessTokenSecret("rTn1gYeVQuSW5zF8T2M5Xgu6Hl97JnQqSdLocs2cX4BIV");
        TwitterFactory tf = new TwitterFactory(cb.build());
        //sin configuration builder

        Twitter twitter = new TwitterFactory().getInstance();

        ClaseTwitter tw = new ClaseTwitter();
        tw.postearTweet(twitter);
        tw.verTimelime(twitter);
        tw.mensajeDirecto(twitter);
        tw.buscar(twitter);
    }

}
