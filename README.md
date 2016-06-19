# SMSLib-MongoDB-Voting-App

Install MongoDb to your computer and add properties to config.properties<br />

mongoClientLocalhost=localhost (hosting server)
mongoClientPort=27017 (port that use mongodb)
database=talentShow (database name)

Add your SMSLib configurations properties to config.properties
(These values are will be changed according to your modem)

serialModemGateway.id=modem.com9
serialModemGateway.comPort=COM9
serialModemGateway.baudRate=115200
serialModemGateway.manufacturer=huawei
serialModemGateway.model=E173
simPin=0000
storageLocation=SM

By using this simple SMSLib-MongoDB-Voting-Application:

Voter can vote only one vote per person.
Can run only one voting event.
Can add Groups or individual participants.
Participants details are sorting according to the vote count.
Can view previous voting events history details.
Can re run previous events as well.
