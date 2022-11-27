#!/bin/bash

REPO=/home/ec2-user/actions-runner/_work/java-todo
PROJECT=java-todo

CURR_PID=$(pgrep -f ${PROJECT}.*.jar)
if [ -n "$CURR_PID" ]; then
  echo "already running java process ---> kill -15 $CURR_PID"
  kill -15 "$CURR_PID"
  sleep 8
fi

# extract the largest size jar
JAR=$(ls -S $REPO/$PROJECT/build/libs/*.jar | head -n 1)

echo "application start: $JAR"
echo "log path: $REPO/$PROJECT.log"

# When nohup errors, output errors to log file
echo "nohup java -jar $JAR > $REPO/$PROJECT.log 2>&1 &"
RUNNER_TRACKING_ID="" # prevent the github action from cleaning up orphan processes
nohup java -jar "$JAR" > $REPO/$PROJECT.log 2>&1 &
