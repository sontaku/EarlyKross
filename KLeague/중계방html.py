import time
import pymysql
from bs4 import BeautifulSoup
from selenium.webdriver import Edge

f = open('경기일정.txt', 'r', encoding='utf-8')

driver = Edge('driver/msedgedriver.exe')

for i in f:
    f_id = i
    driver.get('https://m.sports.naver.com/game/{}/relay'.format(i))
    # driver.implicitly_wait(3)
    time.sleep(1)

    ha = driver.find_element_by_xpath('//*[@id="content"]/div/div/section[2]/div[2]/div[2]/div[2]/h3/a')
    ha.click()

    # 더보기 계속 클릭하기
    while True:
        try:
            more1 = driver.find_element_by_xpath('//*[@id="content"]/div/div/section[2]/div[2]/div[2]/div[1]/div/a')
            more1.click()
            time.sleep(1)
        except:
            break

    while True:
        try:
            more2 = driver.find_element_by_xpath('//*[@id="content"]/div/div/section[2]/div[2]/div[2]/div[2]/div/a')
            more2.click()
            time.sleep(1)
        except:
            break

    soup = BeautifulSoup(driver.page_source, 'html.parser')

    times = []
    texts = []

    for t in soup.select('.TimeLine_time__11YMk'):
        times.append(t.text)

    for t in soup.select('.TimeLine_inner__1JnKT'):
        texts.append(t.text)

    # MySQL Connection 연결
    conn = pymysql.connect(host='earlykross.cuopsz9nr7wp.ap-northeast-2.rds.amazonaws.com', user='ek',
                           password='siattiger',
                           db='earlykross', charset='utf8')

    # conn = pymysql.connect(host='localhost', user='ek',
    #                        password='ek',
    #                        db='earlykross', charset='utf8')

    for ttime, text in zip(times, texts):
        sql = 'insert into relay(f_id, r_date, r_text) values (%s, %s, %s)'

        curs = conn.cursor()
        curs.execute(sql, (f_id, ttime, text))
        conn.commit()

    conn.close()
