# Java Web Application Starter with Gradle

This is the starter set to start Java application development with Gradle using
Gretty.

## Runtime dependencies

You will need Java, Node.js, Gradle to run this project (or simply Docker).

## Get Started

You can run `./script/start.sh` to start application and go to http://localhost:8080/hello
to see HelloServlet working.

You can start adding more Java Servlets under `src/main/java` folder to continue
hacking!

## Development

In brief, there are two side of story in this project: **front end development**
and **back end development**.

### File Structure

```
client/                         -> Front end resources
	src/                        -> Source codes
		app.js                  -> JavaScript entry/main file
	test/                       -> Test folder
	.babelrc                    -> JavaScript transpiling configuration (through BabelJS)
	package.json                -> Front end dependencies in npm packages (if any)
	webpack.config              -> Bundler configuration
src/main/
	/java/                  -> Your java classes
		edu/csula/web/HelloServlet.java -> HelloServlet for example
	/webapp/                -> Your front end resources
		js/                 -> JavaScript assets
			app.bundle.js   -> Bundled JavaScript code from `client/src`
build.gradle                    -> necessary gradle definition
build/                          -> built files
	classes                     -> compiled java classes
```
