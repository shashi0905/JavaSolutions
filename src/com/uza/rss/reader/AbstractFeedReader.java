/**
 * 
 */
package com.uza.rss.reader;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author shash
 *
 */
public abstract class AbstractFeedReader implements FeedReader {
	
	//protected FeedHandler feedHandler;

	@Override
	public abstract SyndFeed read();

	/*@Override
	public void setFeedHandler(FeedHandler handler) {
		this.feedHandler = handler;
	}*/
	
}
