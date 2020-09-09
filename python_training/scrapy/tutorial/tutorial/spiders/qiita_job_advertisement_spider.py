import scrapy

class QutesSpider(scrapy.Spider):
    name = "qiita"

    def start_requests(self):
        # エンジニア・技術職(システム/ネットワーク)から抽出してきている
        urls = [
            'https://jobs.qiita.com/postings',
        ]
        for url in urls:
            yield scrapy.Request(url=url, callback=self.parse)

    def parse(self, response):
        # page = response.url.split("/")[-2]
        # filename = 'quotes-%s.html' % page
        # with open(filename, 'wb') as f:
        #     f.write(response.body)
        # self.log('Saved file %s' % filename)
        for job_card in response.css('div.p-postings__postingWrap'):
            job_card.css('.fa.fa-yen-sign.p-postings__tagIcon')[0].xpath('following-sibling::text()[1]').get()
            yield {
                'position': job_card.css('.p-postings__postingProfession::text').get(),
                'title': job_card.css('.p-postings__postingName::text').get(),
                'salary':  ''.join(job_card.css('.fa.fa-yen-sign.p-postings__tagIcon')[0].xpath('following-sibling::span/text()').getall()),
                'abstraction': '',
                'company_name': job_card.css('.p-postings__postingEmployerName::text').get(),
            }

        next_page = response.css('a.fa.fa-angle-right.c-pagination__item::attr(href)').get()
        if next_page is not None:
            next_page = response.urljoin(next_page)
            yield scrapy.Request(next_page, callback=self.parse)

