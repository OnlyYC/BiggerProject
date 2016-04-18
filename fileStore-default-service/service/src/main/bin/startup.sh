#!/bin/sh

if [ -z "$1" ]; then
	echo "请在参数中指定进程Id文件的名称！"
	exit 1
fi

CURRENT_DIR=$(pwd)
PROJECT_DIR=$CURRENT_DIR"/.."

CLASSPATH=
CLASSPATH=$CLASSPATH:$PROJECT_DIR

CLASSPATH=$CLASSPATH:$CURRENT_DIR"/../lib/*"

# echo $CLASSPATH

APPNAME=com.liaoyb.Application

java -Xms4096m -Xmx4096m -classpath "$CLASSPATH" $APPNAME start >/dev/null 2>&1 &

echo $! > "/iflytek/pid/TLsys-job-$1.pid"

echo "started"

