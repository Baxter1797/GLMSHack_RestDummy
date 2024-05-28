# GLMS Dummy REST Service
## Prerequisites
You'll need to have Java installed on your machine, JDK17 or newer.

## Installation
Clone the repository to your local machine or download the .jar file directly from GitHub.
Run the .jar file on your local machine from the command line using the following command: java -jar dummyGLMS.jar. This will spin up the service on **`localhost:8080`**.

## Usage
You can make a request in the web browser to test the API response. For example: `http://localhost:8080/EEAPassport`. This will return one EEAPassport object.

You can return multiple objects if you pass the optional argument _numOfObjects_ in the request URL. For example: `http://localhost:8080/EEAPassport?numOfObjects=10`.

## How it works
Within the REST controller, there are static arraylists, which upon request use a random function to creare each element within each object.
This means every time you make a request, it will return a random combination of each arraylist.
