package com.uza.rss.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.syndication.feed.synd.SyndFeed;
import com.uza.rss.reader.RssFileReader;
import com.uza.rss.reader.RssFeedReader;
import com.uza.rss.transformer.FeedTransformer;
import com.uza.rss.transformer.SimpleTransformer;
import com.uza.rss.writer.ConsoleWriter;
import com.uza.rss.writer.FeedWriter;
import com.uza.rss.writer.FileWriter;

@SpringBootApplication
public class RssReaderApp implements CommandLineRunner{
	
	private static Logger LOG = LoggerFactory
		      .getLogger(RssReaderApp.class);

	public static void main(String[] args) {
		SpringApplication.run(RssReaderApp.class, args);
	}
	
	 @Override
	    public void run(String... args) {
	        LOG.info("EXECUTING : command line runner");
	  
	      //RssFeedReader reader = new RssFeedReader("https://www.blackrockbkcc.com/rss/news-releases.xml?items=15");
	      
	        RssFileReader reader = new RssFileReader("C://Users//smourya//sample.xml");
	        SyndFeed inputFeed = reader.read();
	        
	        FeedTransformer transformer = new SimpleTransformer(inputFeed);
	        SyndFeed transformedFeed = transformer.transform();
	        
	        //FeedWriter writer = new ConsoleWriter(transformedFeed);
	        FeedWriter writer = new FileWriter(transformedFeed);
	        writer.write();
	    }
}
