from googletrans import Translator
import datetime

def printCurrentDateTime(string):
	x = datetime.datetime.now()
	print(string, x)
	return x

def timeDiff(start, end):
	print (end-start)
	return end-start

startTime = printCurrentDateTime("start=")

translator = Translator(service_urls=[
      'translate.google.com'
    ])

translator = Translator()
print(translator.translate("pal bhar Theher jaao", dest='ta'))

endTime = printCurrentDateTime("End Time=")

timeDiff(startTime, endTime)



	
