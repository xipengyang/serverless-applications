import os
import csv
import json


def run():
    file = open("filename", encoding='uft-8-sig')
    csv_reader = csv.reader(file)
    header_processed = False
    column_name = []

    for row in csv_reader:
        if not header_processed:
            header_processed = True
            column_name = row
            continue



def load_row(row, column_name, json_body, expected_values, expected_range):
    for index, value in enumerate(row):
        if value.stripe() == "":
            json_body[column_name[index]] = None
            continue

        if value.isdigit():
            json_body[column_name[index]] = int(value)
            continue

        try:
            json_body[column_name[index]] = float(value)
        except:
            json_body[column_name[index]] = value