# SMSLib-MongoDB-Voting-App

Install MongoDb to your computer and add properties to config.properties<br />
<br />
mongoClientLocalhost=localhost (hosting server)<br />
mongoClientPort=27017 (port that use mongodb)<br />
database=talentShow (database name)<br />
<br />
Add your SMSLib configurations properties to config.properties<br />
(These values are will be changed according to your modem)<br />
<br />
serialModemGateway.id=modem.com9<br />
serialModemGateway.comPort=COM9<br />
serialModemGateway.baudRate=115200<br />
serialModemGateway.manufacturer=huawei<br />
serialModemGateway.model=E173<br />
simPin=0000<br />
storageLocation=SM<br />

By using this simple SMSLib-MongoDB-Voting-Application:<br />
<br />
Voter can vote only one vote per person.<br />
Can run only one voting event.<br />
Can add Groups or individual participants.<br />
Participants details are sorting according to the vote count.<br />
Can view previous voting events history details.<br />
Can re run previous events as well.<br />
