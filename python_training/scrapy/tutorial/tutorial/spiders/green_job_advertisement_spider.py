import scrapy

class QutesSpider(scrapy.Spider):
    name = "green"

    def start_requests(self):
        # エンジニア・技術職(システム/ネットワーク)から抽出してきている
        urls = [
            'https://www.green-japan.com/search_key/01?key=ssfn4s07skvmdv6ue2fn&keyword=',
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # page = response.url.split("/")[-2]
        # filename = 'quotes-%s.html' % page
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        # self.log('Saved file %s' % filename)
        for job_card in response.css('div.card-info__wrapper'):
            yield {
                'position': job_card.css('.job-offer-icon::text').get(),
                'title': job_card.css('.card-info__heading-area__title::text').get(),
                'salary': job_card.css('.icon-salary')[0].xpath('following-sibling::text()[1]').get() if job_card.css('.icon-salary') else '',
                'abstraction': job_card.css('.card-info__detail-area__text::text').get(),
                'company_name': job_card.css('.card-info__detail-area__box__title::text').get(),
            }

        next_page = response.css('a.next_page::attr(href)').get()
        if next_page is not None:
            next_page = response.urljoin(next_page)
            yield scrapy.Request(next_page, callback=self.parse)

