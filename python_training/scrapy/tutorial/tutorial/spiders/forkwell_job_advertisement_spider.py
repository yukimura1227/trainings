import scrapy

class QutesSpider(scrapy.Spider):
    name = "forkwell"

    def start_requests(self):
        # エンジニア・技術職(システム/ネットワーク)から抽出してきている
        urls = [
            'https://jobs.forkwell.com/jobs',
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # page = response.url.split("/")[-2]
        # filename = 'quotes-%s.html' % page
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        # self.log('Saved file %s' % filename)
        for job_card in response.css('.job-list .card'):
            yield {
                'position': job_card.css('.card__body ul.list-inline')[1].css('li')[1].xpath('text()')[1].get(),
                'title': job_card.css('a.link-inherit.job-list__link span::text').get(),
                'salary': ''.join(job_card.css('.card__body ul.list-inline')[2].css('li')[0].xpath('*/text()').getall()),
                'abstraction': '',
                'company_name': job_card.css('.avatar__detail::text').get(),
            }

        next_page = response.css('.pagination')[0].xpath('li/a[@rel="next"]/@href').get()
        if next_page is not None:
            next_page = response.urljoin(next_page)
            yield scrapy.Request(next_page, callback=self.parse)

