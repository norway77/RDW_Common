## RDW_Common
RDW modules used by at least two apps

#### Building Modules
Java 8.

This is a gradle project so you can use the gradle wrapper `./gradlew clean build` or 
local gradle (v3.3+) `gradle clean build`.

Resulting module jars can be found in `./build/libs`

Jacoco code coverage is included as part of the module test task, `./build/reports/jacoco/test/html/index.html`.

Maven plugin is turned on so `gradle build install` will put a dependency artifact in your local repo.


