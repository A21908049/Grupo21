This is a simple Java application
that loads configuration values from a property file in resources.

The properties file follows the name=value syntax,
explained in http://en.wikipedia.org/wiki/.properties

The min and max values are simple properties.


Instructions using Maven:
-----------------------

To compile and copy resources to the output directory:
  mvn package
  (compare the properties file in src/main with
  the file in target/classes/ after executing)

To generate launch scripts for Windows and Linux:
  (appassembler:assemble is attached to install phase)
  mvn install

To run using appassembler plugin:
  On Windows:
    target\appassembler\bin\java-app_config
  On Linux:
    ./target/appassembler/bin/java-app_config

Or run as a normal application.

java -cp target/ConfigHelper-0.0.1-SNAPSHOT.jar pt.ulusofona.cd.ConfigHelper

Find the problem to run this program and fix it. 

To configure the Maven project in Eclipse:
-----------------------------------------

'File', 'Import...', 'Maven'-'Existing Maven Projects'
'Select root directory' and 'Browse' to the project base folder.
Check that the desired POM is selected and 'Finish'.


