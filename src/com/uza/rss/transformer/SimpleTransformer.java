/**
 * 
 */
package com.uza.rss.transformer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author shash
 *
 */
public class SimpleTransformer implements FeedTransformer{
	
	private static final Logger logger = LoggerFactory.getLogger(SimpleTransformer.class);
	private SyndFeed feed;
	
	public SimpleTransformer(SyndFeed feed) {
		this.feed = feed;
	}

	
	@Override
	public SyndFeed transform() {
		
		logger.info("Transforming Feed...");
		List<SyndEntryImpl> feeds = feed.getEntries();
		feeds.forEach(s->s.setTitle(s.getTitle().replaceAll("BlackRock", "")));
		feeds.forEach(s->s.getDescription().setValue(s.getDescription().getValue().replaceAll("BlackRock", "")));
		return feed;
	
	}
	
}
