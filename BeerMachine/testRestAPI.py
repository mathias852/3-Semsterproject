import requests

url1 = 'http://localhost:8081/batch/add'
batch = {'amount': 16,
        'type_id': 1}

x = requests.post(url1, json = batch)


#url2 = 'http://localhost:8081/type/add'
#type = {'name': 'Pilsner'}

#x = requests.post(url2, json = type)

print(x.text)
