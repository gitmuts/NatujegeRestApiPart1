The docker file defined is a multi step build.

_Line 2-9_, we download maven and build our code.
Same case as manually:
i) Downloading maven and installing it.
ii) Running mvn install to fetch our dependencies
iii) Unzip our jar file(This is to improve performance when code is running)

In _line 11 to 17_, we are creating our deployment image.

In _line 11_, we specify that we will be using a JAVA 11 image that comes with alphine as the OS(Very light weight)
We then copy the various files from our previous build(line 2-9)
In _line 17_ we define the command to be used to start our application.

To Build:
1) In windows install docker desktop or linux docker engine
2) Login to docker hub (Create a docker account if you don't have one)
3) Run:  `docker build -t YOUR_DOCKER_USERNAME/NatujengeRestApiSample .`

**Replace YOUR_DOCKER_USERNAME, with your docker username**


After build has completed, run `docker run YOUR_DOCKER_USERNAME/NatujengeRestApiSample`