#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Feb 23 18:41:50 2019

@author: admin
"""


import re

#find all matching string in a given string
print (re.findall('AAA(.*?)ZZZ', 'gfAAA---ZZZdAAA1234ZZZuijjk'))