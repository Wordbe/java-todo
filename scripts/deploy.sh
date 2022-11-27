#!/bin/bash

REPO=/home/ec2-user/app/step1
PROJECT=java-todo

# CURR_PID=$(pgrep -f ${PROJECT}.*.jar)
CURR_PID=$(pgrep -f java)

if [ -n "$CURR_PID" ]; then
  echo "alreay running java process ---> kill -15 $CURR_PID"
  kill -15 "$CURR_PID"
  sleep 8
fi

# extract the largest size jar
JAR=$(ls -S $REPO/$PROJECT/build/libs/*.jar | head -n 1)

echo "application start: $JAR"
echo "log path: $REPO/$PROJECT.log "

# When nohup errors, output errors to log file
nohup java -jar "$JAR" > $REPO/$PROJECT.log 2>&1 &
