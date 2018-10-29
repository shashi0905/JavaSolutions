/**
 * 
 */
package com.uza.rss.writer;

import java.io.IOException;
import java.io.OutputStreamWriter;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

/**
 * @author smourya
 *
 */
public class ConsoleWriter implements FeedWriter {

	private SyndFeed outputFeed;
	
	public ConsoleWriter(SyndFeed feed){
		this.outputFeed = feed;
	}
	
	
	@Override
	public void write() {
		SyndFeedOutput out = new SyndFeedOutput();
		try {
		
			out.output(outputFeed, new OutputStreamWriter(System.out,"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
	}

}
