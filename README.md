# ScientificJavaLibrary

### To contribute, fork the repo, make changes, and submit a Pull Request.
 
Maven should be installed on your machine.

## Using NetBeans
* Fork a copy of the project and clone the project to a local workspace directory
* Open Netbeans. Select File > Open project..., select the project folder
* Select Run > Test Project. NetBeans handles Maven and will run the tests
* Commit changes to your fork of the project
* The .gitignore file should ignore nbactions.xml, /target/ when committing
* Once you have made changes to your fork, submit a pull request

## Using Eclipse
* Fork a copy of the project and clone the project into your workspace
* Open Eclipse in your workspace. Select File > Import Project from Folder..., select the folder, click Next, Next
* Select Project > Properties > Java Compiler, configure the build path to use the 1.8 compiler.
* Right-click the project, select Java Build Path, change to use JDK8 in the Library tab and click OK
* To run the Maven project, select Run > Run As > Maven Build... and type 'clean install' into Goals field
* Commit changes to your fork of the project
* The .gitignore file should ignore /bin, /target, .settings, .project, .classpath when committing
* Once you commit changes to your fork, submit a pull request
