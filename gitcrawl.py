
import requests
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
import lxml
import json


endpoint_json = dict()
endpoint_json = list()

with open ('data.json') as json_file:
    json_data = json.load(json_file)

    for i in json_data["commit"]:
        endpoint = i['endpoint']

        print(endpoint[5:30])

        value = dict(endpoint = endpoint[5:30])
        endpoint_json.append(value)
        
        endpoint_data = json.dumps(endpoint_json)

        with open ('endpoint.json','w') as f:
            f.write(endpoint_data)
