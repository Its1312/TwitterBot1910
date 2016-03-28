package net.struwi.twitterbot1910;

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
            if (now.getHour() == 19 && now.getMinute() == 10) {
                System.out.println("Tweeting time");
                Twitter twitter = TwitterFactory.getSingleton();
                try {
                    Status status = twitter.updateStatus("It´s 19:10");
                }
                catch (TwitterException ex) {
                    System.out.println("Error tweeting: " + ex.getMessage());
                }
            }
        }

    }

}
