#!/bin/bash
### depracated script. 
### a test script of full function. 
##

if [ $1x = locx ]; then
	addr="http://127.0.0.1:8008"
else
	addr="http://47.100.101.81:8008"
fi

### keygen with keygencode "1"
nohup node test.js keygen $addr keys1.store 1/3 1 &
sleep 0.2
nohup node test.js keygen $addr keys2.store 1/3 1 &
sleep 0.2
nohup node test.js keygen $addr keys3.store 1/3 1 &
sleep 0.2


### sign msg "e1d2" with signcode "1"
nohup node test.js sign $addr keys1.store 1/2/3 e1d2a3f1 1 &
sleep 0.1
nohup node test.js sign $addr keys2.store 1/2/3 e1d2a3f1 1 &

sleep 2
### keygen and get a final key(12 phrases), with keygencode "2"
nohup node test.js keygendunnew $addr keys1.store 1/3 2 12 pwd &
sleep 0.2
nohup node test.js keygendunnew $addr keys2.store 1/3 2 &
sleep 0.1
nohup node test.js keygendunnew $addr keys3.store 1/3 2 &
sleep 0.2


sleep 2
### keygen from phrase: now enable indicate only flavor ball pink minute ritual october news stairs
nohup node test.js keygendun $addr keys1.store 1/3 1 "now enable indicate only flavor ball pink minute ritual october news stairs" pwd &
sleep 0.1
nohup node test.js keygendun $addr keys2.store 1/3 1 &
sleep 0.1
nohup node test.js keygendun $addr keys3.store 1/3 1 &

