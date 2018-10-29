/**
 * 
 */
package com.uza.rss.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.SyndFeedOutput;
import com.sun.syndication.io.XmlReader;
import com.uza.rss.transformer.SimpleTransformer;

/**
 * @author shash
 *
 */
public class RssFeedReader extends AbstractFeedReader {

	//private String source;
	final URL url;
	
	public RssFeedReader(String feedUrl) {
		  try {
	            this.url = new URL(feedUrl);
	        } catch (MalformedURLException e) {
	            throw new RuntimeException(e);
	        }
	}
	
	
	@Override
	public SyndFeed read() {
		
		SyndFeed feed = null;
		SyndFeedInput input = new SyndFeedInput();
		
        try {
			 feed = input.build(new FileReader(new File("C://Users//smourya//sample.xml")));
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feed;
	}
	
	

}
