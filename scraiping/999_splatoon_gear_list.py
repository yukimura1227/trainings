from urllib.request import urlopen
from bs4 import BeautifulSoup

url = 'https://game8.jp/splatoon-2/164683'
html = urlopen(url).read()
html = urlopen(url).read()
soup = BeautifulSoup(html, "html.parser")
table = soup.findAll("table", {"class":"a-table"})[3]
rows = table.findAll("tr")
for row in rows:
    array = []
    for cell in row.findAll('td'):
        if len(cell) != 0:
            array.append(cell)

    if len(array) != 0:
        brand = array[0]
        brand_name = brand.findAll("a", {"class":"a-link"})[0].get_text()
        brand_image_path = brand.findAll("img")[0]['src']
        print(brand_image_path + ' : ' + brand_name)

# https://game8.jp/splatoon-2/158463 -> 頭用のギア一覧
url = 'https://game8.jp/splatoon-2/158463'
html = urlopen(url).read()
soup = BeautifulSoup(html, "html.parser")

table = soup.findAll("table", {"class":"a-table"})[1]
# table = soup.findAll("table")[0]
rows = table.findAll("tr")
for row in rows:
    array = []
    for cell in row.findAll('td'):
        if len(cell) != 0:
            array.append(cell.get_text().strip())

    if len(array) != 0:
        link = array[0]
        rarelity = array[1]
        if rarelity == '星1':
            rarelity_str = '☆'
        elif rarelity == '星2':
            rarelity_str = '☆☆'
        elif rarelity == '星3':
            rarelity_str = '☆☆☆'

        skill = array[2]
        if skill == 'スペシャル性能アップ':
            skill_img_link = 'https://img.game8.jp/1075310/3742aae2b6828d7ff75229eb63562bfe_2017-07-28.png/show?1501208693'
        else:
            skill_img_link = ''

        brand = array[3]
        # print(link + rarelity_str + skill_img_link)

