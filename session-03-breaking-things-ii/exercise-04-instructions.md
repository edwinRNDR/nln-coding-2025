# Instructions for exercise 4

## Terminal

on macOS you can open the terminal application by typing `terminal` in Spotlight search (command-space on most setups, 
search icon top right otherwise).

Make yourself familiar with the concepts of paths and current working directory.

## Install brew:
Visit https://brew.sh/ and follow the instructions offered there.

## Install ffmpeg

If brew is installed type `brew install ffmpeg` in the terminal.


On windows try: https://winstall.app/apps/Gyan.FFmpeg
## Install yt-dlp

If brew is installed type `brew install yt-dlp` in the terminal.

## Using yt-dlp

To download a video from e.g. YouTube
```shell
cd ~/Downloads
yt-dlp "https://www.youtube.com/watch?v=01rXk7iRDwg"
```

Test your download:
```shell
ffplay "tmpHQ7DwF [01rXk7iRDwg].webm"
```

# Recompress video using a very low bitrate

A basic re-encoding to 1000 bits per second for video

```shell
ffmpeg -i "tmpHQ7DwF [01rXk7iRDwg].webm" -b:v 1000 kapot.mp4
```

With 100 bits per second for audio
```shell
ffmpeg -i "tmpHQ7DwF [01rXk7iRDwg].webm" -b:v 1000 -b:a 100 kapot.mp4
```


A re-encoding using very few keyframes and disabled scene cut detection.

```shell
ffmpeg -i "tmpHQ7DwF [01rXk7iRDwg].webm" -b:v 1000 -x264-params keyint=1200:scenecut=0 kapot.mp4
```


## List video devices (macOS)

```shell
ffmpeg -f avfoundation -list_devices true -i null
```

## Record your screen

```shell
ffmpeg -f avfoundation -i "Capture screen 0" screen1.mp4
```

## Record your camera
```shell
ffmpeg -r 30  -f avfoundation -i "FaceTime HD Camera" -t 30  bla.mp4
```
