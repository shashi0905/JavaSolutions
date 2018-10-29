/**
 * 
 */
package com.uza.rss.reader;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author shash
 *
 */
public interface FeedReader {
	
	public SyndFeed read();
	
	//public void setFeedHandler(FeedHandler handler);

}
