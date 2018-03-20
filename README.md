# StoreManagerForConsumer
Design a key/value store that allows a consumer to store/retrieve keys of different data-types and query them.

A consumer, via a single class, must be able to:

1. Store a key and a value. The value can either be a String or a Float.
2. Retrieve a value for a key. Multiple keys could also be provided.
3. Query for values matching a particular pattern (regex). This method should only return the key, value pairs which are Strings. Any entry holding a Float should be skipped.
4. Query for values greater than a given number. This method should only return the key, value pairs which are Floats. Any entry holding a String should be skipped.

An example interaction (in a pseudo-language); Lines beginning with a '>' indicate server response.

StoreManager.store("hello", "world")
StoreManager.get("hello") // returns List["world"]

StoreManager.store("mykey", 1000)
StoreManager.get("hello", "mykey") // returns List["world", 1000]

StoreManager.store("anotherkey", "anothervalue")
StoreManager.query("another.*") // returns List["anothervalue"]

StoreManager.queryGt(50) // returns List[1000]

The interaction above is purely illustrative. You are free to make design changes and change the representations, names and data structures as you wish.

