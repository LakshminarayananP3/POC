import json

json_string = json.loads(open(
    "/Users/admin/Work/waste/JAVA_POC/python_poc/sample.json").read())


def printStartElem(key):
    print("<" + str(key) + ">")


def printEndElem(key):
    print("</" + str(key) + ">")

def printElem(key, value):
    print("<" + str(key) + ">" + str(value) + "</" + str(key) + ">")


def iterateData(jsonContent):
    # print(jsonContent)
    for key, value in jsonContent.items():
        if(type(value) is dict):
            printStartElem(key)
            iterateData(value)
            printEndElem(key)
        elif(type(value) is list):
            printStartElem(key)
            iterateList(value)
            printEndElem(key)
        else:
            printElem(key, value)

def iterateList(jsonList):
    for value in jsonList:
        if (type(value) is dict):
            iterateData(value)
        elif (type(value) is list):
            iterateList(value)
        else:
            print("<LIST_ELEM>" + str(value) + "</LIST_ELEM>")



iterateData(json_string)
