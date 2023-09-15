# Scientific Java Library

<br><br>
:mailbox_with_mail: To contribute, fork the repo, make changes, and submit a pull request. Maven should be installed on your machine.

<br><br>
## Using Intellij

:one: Fork a copy of the project and clone the project to a local workspace directory

:two: Open Intellij and Open..., select the project folder

:three: In the Maven view, click 'Execute Maven Goal' and run 'mvn test' to run the unit tests

:four: Commit changes to your fork of the project and submit a pull request

<br><br>

## Using Eclipse

:one: Fork a copy of the project and clone the project into your workspace

:two: Open Eclipse in your workspace. Select File > Import Project from Folder..., select the folder, click Next, Next

:three: Select Project > Properties > Java Compiler, configure the build path to use the 1.8 compiler.

:four: Right-click the project, select Java Build Path, change to use JDK8 in the Library tab and click OK

:five: To run the Maven project, select Run > Run As > Maven Build... and type 'clean install' into Goals field

:six: Commit changes to your fork of the project

:seven: The .gitignore file should ignore /bin, /target, .settings, .project, .classpath when committing

:eight: Once you commit changes to your fork, submit a pull request


<br><br>
## Using NetBeans

:one: Fork a copy of the project and clone the project to a local workspace directory

:two: Open Netbeans. Select File > Open project..., select the project folder

:three: Select Run > Test Project. NetBeans handles Maven and will run the tests

:four: Commit changes to your fork of the project

:five: The .gitignore file should ignore nbactions.xml, /target/ when committing

:six: Once you have made changes to your fork, submit a pull request

