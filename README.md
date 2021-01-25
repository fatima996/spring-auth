# spring-simple-jdbc-auth

This application demonstrates how to make simple authentication using spring security and spring jdbc.

After running the application with spring-boot:run go to http://localhost:8080/ where a simple login form is found.
To login use either an admin or user then you will be directed to a home page. The admin user can access all routes including home(/), /admin or /user and user can access home and /user route.

In the SecurityConfig.class you can find the security configurations that are connecting the application to datasource for credentials. You can also find configurations for accessible routes per user.

In the schema.sql the data tables are initialized and in data.sql the data for users and the authority roles are initialized when the application starts.

Controller.class is for demonstrating the authorization of users where we created three previously mentioned routes home(/), /admin or /user.
