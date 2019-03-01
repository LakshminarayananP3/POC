# imported the requests library 
import requests
import sys
import re

def downloadFile(url, filename):
      
    # URL of the image to be downloaded is defined as image_url 
    r = requests.get(url) # create HTTP response object 
      
    # send a HTTP request to the server and save 
    # the HTTP response in a response object called r 
    with open(filename,'wb') as f: 
      
        # Saving received content as a png file in 
        # binary format 
      
        # write the contents of the response (r.content) 
        # to a new file in binary mode. 
        f.write(r.content) 
        
if len(sys.argv) != 2 + 1:
    print("Argument length ", len(sys.argv))
    for x in sys.argv:
        print("args ",x)
    sys.exit("Input arguments missing <Url> <downloadPath>")

#url = "https://unsplash.com/collections/2563375/cars"
url = sys.argv[1]
urlFileName = "unsplashCars.html"
downloadFile(url, urlFileName)
    
urlContent = open(urlFileName, 'r').read()
#print(urlContent)

#find all matching string in a given string
imageList =  (re.findall('href="/photos/(.*?)">', urlContent))

#downloadPath = "/Users/admin/Downloads/image/MotivationalQuotesWallpaper/cars/"
downloadPath = sys.argv[2]
if downloadPath.endswith("/"):
    print("/ present")    
for x in imageList:
    filename = downloadPath + x + ".png";
    print("Downloading and saving file to ", filename)
    url = "https://unsplash.com/photos/" + x + "/download?force=true"
    downloadFile(url, filename)