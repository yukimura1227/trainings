import requests
import lxml.html

response = requests.get('http://sample.scraping-book.com/dp')
root = lxml.html.fromstring(response.content)
root.make_links_absolute(response.url)

for a in root.cssselect('a[itemprop="url"]'):
    url = a.get('href')
    print(url)
