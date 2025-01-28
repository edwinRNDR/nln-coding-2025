#!/usr/bin/env bash

SCREEN="Capture screen 0"
CAMERA="FaceTime HD Camera"
DURATION=5
TAKES=2
for i in $(seq 1 $TAKES)
do
  ffmpeg -y -f avfoundation -i "$SCREEN" -t $DURATION "vid-$(printf "%03d" "$((i*2-1))").mp4"
  ffmpeg -y -r 30  -f avfoundation -i "$CAMERA" -t $DURATION  "vid-$(printf "%03d" "$((i*2))").mp4"
done