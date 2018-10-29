/**
 * 
 */
package com.uza.rss.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;

/**
 * @author smourya
 *
 */
public class RssFileReader implements FeedReader{
	
	private File file;
	
	public RssFileReader(String path){
		this.file = new File(path);
	
	}

	@Override
	public SyndFeed read() {
		
		SyndFeed feed = null;
		SyndFeedInput input = new SyndFeedInput();

		try {
			Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			
			//input.build(reader);
			// feed = input.build(file);
			feed = input.build(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
		return feed;
	}
	
	

}
