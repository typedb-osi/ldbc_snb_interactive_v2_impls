import os
import csv

def find_csv_files(directory):
    for dirpath, dirnames, filenames in os.walk(directory):
        for filename in filenames:
            if filename.endswith(".csv"):
                # Return the relative path
                relative_path = os.path.relpath(os.path.join(dirpath, filename), directory)
                yield relative_path

def read_first_line_of_csv(directory, rel_path):
    abs_path = os.path.join(directory, rel_path)
    try:
        with open(abs_path, 'r', encoding='utf-8', newline='') as file:
            reader = csv.reader(file)
            return next(reader, None)
    except UnicodeDecodeError:
        print(f"Unable to decode file: {abs_path}")
        return None

def main(directory):
    for csv_file in find_csv_files(directory):
        first_line = read_first_line_of_csv(directory, csv_file)
        if first_line:
            print(f"File: {csv_file}")
            print(f"First Line: {first_line}")
            print("-" * 50)

if __name__ == "__main__":
    directory = input("Enter the directory path: ")
    main(directory)
