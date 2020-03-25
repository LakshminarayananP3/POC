#!/usr/bin/python
import psmysql

# Open database connection
db = psmysql.connect("localhost","root","secret","CLAIMS_SYS" )

# prepare a cursor object using cursor() method
cursor = db.cursor()

# execute SQL query using execute() method.
cursor.execute("SELECT * from address")

# Fetch a single row using fetchone() method.
data = cursor.fetchone()
print(data)

# disconnect from server
db.close()