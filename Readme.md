# Bank Account validation 

### project work flow
- Kafka Listner configured which continuesly reads messages from accounts topic.
- AccountService will check the length of an account number if it is less than 10 digits then this service will append leading 0's and persists object into mongodb.


