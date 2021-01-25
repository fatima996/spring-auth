# spring-auth

This application demonstrates how to make simple authentication using spring security and spring jdbc.

# Code explanation
After running the application with spring-boot:run go to http://localhost:8080/ where a simple login form can be found.
To login use either an admin or user then you will be directed to a home page. The admin user can access all routes including home(/), /admin or /user and user can access home and /user route.

In the SecurityConfig.class you can find the security configurations that are connecting the application to datasource for credentials. You can also find configurations for accessible routes per user.

In the schema.sql the data tables are initialized and in data.sql the data for users and the authority roles are initialized when the application starts.

Controller.class is for demonstrating the authorization of users where we created three previously mentioned routes home(/), /admin or /user.
```java
@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .userByUsernameQuery("select username,password,enabled from users where username = ?")
                .userByUsernameQuery("select username,authority from authorities where username = ?");
    }
```

In this method the two following lines will tell spring security how to retrieve users from our data source. 
Although these are the default values for this method that spring security will check they can be used to override the defaults.
```java 
.userByUsernameQuery("select username,password,enabled from users where username = ?")
.userByUsernameQuery("select username,authority from authorities where username = ?");
```