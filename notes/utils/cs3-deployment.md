# Deployment to CSULA CS3 Server

In this article, we will cover the notes for deploying to CSULA CS3 server.

## Prerequisites

* CS3 Account (ask professor for one)
* SFTP Client
    * Windows:
        * https://filezilla-project.org/
        * https://winscp.net/eng/index.php
    * MacOS:
        * https://cyberduck.io/
    * Linux:
        * `scp -r {folder_name} {username}@cs3.calstatela.edu:/home/{username}/{folder}`

## Files to Transfer

* `*.class` should go under `~/www/WEB-INF/classes`
* all static contents `*.jsp`, `*.css` & `*.js` goes under `~/www`
* `web.xml` goes under `~/www/WEB-INF`

> Transferring `web.xml` tells CS3 Tomcat server to reload your application

> Sometimes, uploading `web.xml` is not enough and it will not trigger a reload.
> In this case, please *delete and upload* the `web.xml` to force reload.

Example:

From Eclipse project, you can upload everything under `build/classes` to be under
`~/www/WEB-INF/classes` and everything under `WebContent` to be under `~/www`

From Gradle project, you can upload `build/classes` to be under
`~/www/WEB-INF/classes` and everything under `src/main/webapp` to be under `~/www`

## URL to Application

After you have uploaded the necessary files to the CS3 Server, you can access your
application under the following URL:

http://cs3.calstatela.edu:8080/{username}/{servlet_or_jsp_pattern}
