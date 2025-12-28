from RPLCD.i2c import CharLCD
import feedparser
import time

lcd = CharLCD('PCF8574', 0x27)

feed = feedparser.parse('http://feeds.bbci.co.uk/news/rss.xml')
headline = feed.entries[0].title[:16]

lcd.write_string(headline)
time.sleep(5)
lcd.clear()
