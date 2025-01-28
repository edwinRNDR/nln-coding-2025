#!/usr/bin/env bash

SCREEN="Capture screen 0"
CAMERA="FaceTime HD Camera"
DURATION=5
TAKES=2

ffmpeg -y -r 30  -f avfoundation -i "$CAMERA" -t $DURATION  "vid-000.mp4"
for i in $(seq 1 $TAKES)
do
  echo $i
  ffplay -autoexit "vid-$(printf "%03d" "$((i-1))").mp4" &
  ffmpeg -y -f avfoundation -i "$SCREEN" -t $DURATION "vid-$(printf "%03d" "$((i))").mp4" &
  wait
done