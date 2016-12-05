package com.team.treasure;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class MyBot{
	public static void main(String[] args) throws TwitterException {
		
	

    ConfigurationBuilder cb = new ConfigurationBuilder();
    
    
    cb.setDebugEnabled(true)
    .setOAuthConsumerKey("zbRmQD45ctlOxf1GS048INBrZ")
    .setOAuthConsumerSecret("MzLgQBVdnbJ74Ij2opA0CTV9k9z8wpZ0f8EvhfFQGgB2bFU56g")
    .setOAuthAccessToken("805785792778006528-fZ9kuMOyGEWAM8XhNYHQ4y9ymshuMTG")
    .setOAuthAccessTokenSecret("ZYYovl5YdK6Z3wH9364TxbM8Evr2QR77WhpnbwvAIbR4f");
    
    TwitterFactory tf = new TwitterFactory(cb.build());
    
    twitter4j.Twitter tw = tf.getInstance();
    
    Status stat = tw.updateStatus("Clara and the boy's it works!");
    System.out.println("Twitter updated");
    
    
    
    
    }
}