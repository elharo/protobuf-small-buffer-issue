Test case for protobuf issue with ```AbstractMessageLite#writeDelimitedTo``` and ```CodedOutputStream``` buffer size requirements.

To run test cases, run ```ant proto25``` and ```ant proto35```.

Uses protobuf installed by Homebrew (/usr/local/opt/protobuf@2.5/bin/protoc and /usr/local/opt/protobuf@3.5/bin/protoc).

Output from ```ant proto25``` (protobuf v2.5.0)

     [java] Serialized size: 2, writes: 1
     [java] Serialized size: 9, writes: 1
     [java] Serialized size: 11, writes: 1


Output from ```ant proto35``` (protobuf v3.5.1

     [java] Serialized size: 2, writes: 2
     [java] Serialized size: 9, writes: 2
     [java] Serialized size: 11, writes: 3

