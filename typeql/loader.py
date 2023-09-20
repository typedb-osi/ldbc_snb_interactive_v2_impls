from typedb.client import *
import csv
from typedb.api.connection.transaction import TypeDBTransactionType

# Connect to the TypeDB server
with TypeDB.core_client("localhost:1729") as client:
    with client.session("try2", SessionType.DATA) as session:
        ## creating a write transaction
        pass

def insert_data(tx, data):
    query = f"""
    insert $person isa person,
        has creationDate "{data['creationDate']}",
        has id {data['id']},
        has firstName "{data['firstName']}",
        has lastName "{data['lastName']}",
        has gender "{data['gender']}",
        has birthday "{data['birthday']}",
        has locationIP "{data['locationIP']}",
        has browserUsed "{data['browserUsed']}",
        has language "{data['language']}",
        has email "{data['email']}";
    """
    tx.query().insert(query)

    

csv_data = """
creationDate|id|firstName|lastName|gender|birthday|locationIP|browserUsed|LocationCityId|language|email
2010-01-31T13:13:03.929+00:00|16|Jan|Zakrzewski|female|1986-07-05|31.41.169.140|Chrome|1284|pl;en|Jan16@hotmail.com;Jan16@gmx.com;Jan16@gmail.com;Jan16@chemist.com;Jan16@yahoo.com
"""

lines = csv_data.strip().split("\n")
headers = lines[0].split("|")

for line in lines[1:]:
    values = line.split("|")
    data = {headers[i]: values[i] for i in range(len(headers))}
    with session.transaction(TypeDBTransactionType.WRITE) as tx:
        insert_data(tx, data)
        tx.commit()

session.close()
client.close()
