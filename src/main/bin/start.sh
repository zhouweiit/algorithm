#!/usr/bin/env bash
PRG="$0"
BIN=`cd $(dirname "$PRG"); pwd`
HOME=`dirname "$BIN"`
PORT="$1"

if [ ! $PORT  ];then
	PORT=9090
fi

if [ "$PORT" -gt 0 ] 2>/dev/null ;then 
   echo "port=$PORT"  
else
   echo "PORT must a num"
   exit
fi


LIB=`find ${HOME}/lib -name "*.jar"`
LOG=${HOME}/log/
CONF=${HOME}/conf/
PIDFILE=${HOME}/pidfile
WEBAPP=${HOME}/webapp

if [ "$PORT" -ne 8080  ];then
    PIDFILE=${HOME}/pidfile_$PORT
fi

echo $PIDFILE

classpath="."
classpath=$classpath:$CONF:$WEBAPP
for item in $LIB
do
    classpath=$classpath:$item
done
echo $classpath


JVM_OPTS="-server -Xms4G -Xmx4G -XX:MaxMetaspaceSize=250M -XX:MetaspaceSize=100M -Xloggc:$LOG/gc_$PORT.log -XX:NewRatio=4 -XX:SurvivorRatio=2 -XX:PretenureSizeThreshold=5M -XX:CMSFullGCsBeforeCompaction=3 -XX:+UseParNewGC -XX:+PrintClassHistogram -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+PrintPromotionFailure  -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSDumpAtPromotionFailure -XX:+UseCMSCompactAtFullCollection -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG/dump.log -Dhttp.proxyPort=80"
IP=`ifconfig  | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}'|grep -E '^10\.'`

#JVM_JMX=" -Dcom.sun.management.jmxremote  -Dcom.sun.management.jmxremote.port=2$PORT -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Djava.rmi.server.hostname=$IP"

if [ -f $PIDFILE ];then
   PID=`cat $PIDFILE`
   tr=`jps -v | grep $PID | grep $PORT | grep $HOME`
   echo "tr:"$tr
   if [ "$tr" != "" ] ; then
      echo "kill $PID"
      kill $PID
   fi
fi
                                                                                                
sleep 5
java $JVM_OPTS $JVM_JMX -Dport=$PORT -Dlogdir=$LOG -Dwebapp=$WEBAPP -cp $classpath org.zhouwei.algorithm.Entrance > ${LOG}t1 2>${LOG}t2 &
PID=$!
echo $PID > $PIDFILE
