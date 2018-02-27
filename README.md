## RDW_Common
RDW modules used by at least two apps.

Additional documentation:
1. RDW_Common is part of the RDW suite of projects and applications. For all things RDW please refer to 
[RDW repo](https://github.com/SmarterApp/RDW)
1. [License](LICENSE)

#### Building Modules
Java 8.

This is a gradle project so you can use the gradle wrapper `./gradlew clean build` or 
local gradle (v3.3+) `gradle clean build`.

Resulting module jars can be found in `./build/libs`

Jacoco code coverage is included as part of the module test task, `./build/reports/jacoco/test/html/index.html`.

Maven plugin is turned on so `gradle build install` will put a dependency artifact in your local repo.


