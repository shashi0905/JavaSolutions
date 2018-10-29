/**
 * 
 */
package com.uza.rss.transformer;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author shash
 *
 */
public interface FeedTransformer {
	
	public SyndFeed transform();

}
