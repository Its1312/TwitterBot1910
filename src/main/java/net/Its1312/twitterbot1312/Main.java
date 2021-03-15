package net.its1312.twitterbot1312;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws TwitterException {
        System.out.println("Starting bot");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TweetTask(), 0L, 60000L);
    }

    private static class TweetTask extends TimerTask {

        public void run() {
            LocalTime now = LocalTime.now();
            if (now.getHour() == 13 && now.getMinute() == 12) {
                System.out.println("Tweeting time");
                Twitter twitter = TwitterFactory.getSingleton();
                try {
                    Status status = twitter.updateStatus("It´s 13:12");
                }
                catch (TwitterException ex) {
                    System.out.println("Error tweeting: " + ex.getMessage());
                }
            }
        }

    }

}
