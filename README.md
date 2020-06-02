# java-selfconsole
Double-clicking a jar file to open it is commonly associated with the "javaw" command and does not show a console upon start.
Yet in some cases,
* you don't want the end user to have to open the jar directly through a console,
* it might not be possible or allowed to implement a custom console using Swing, JavaFX or other GUI-related libraries,
* shipping bridge starting files (like bat, sh, etc.) can suck.

This code snippet is exactly for those cases, where you need to make sure that double clicking the jar does actually open a console window where the program runs. It basically works by getting the path of the executed jar during run and then creating a new process by opening itself with OS dependent commands / terminals. Afterwards the original process is destroyed. This usually works nicely across Windows (cmd) and Mac (terminal). For Linux, as there are many distributions containing different terminal binaries, there is some terminal detection work to do.

Small but nice extra: Setting the terminal title (Windows and Mac only as of now)

Note: When shipping, take care of the compiler compatibility level / compiler version.
If you want to execute your program from an IDE simply add any program run argument, otherwise it will fail to launch.

**Currently on Linux, only xfce4-terminal is supported. Feel free to start a pull request with additional terminal commands / solution for detecting binaries.**

Mac commands are untested but should work for most systems. Feedback would be appreciated,

Use as you like lol
