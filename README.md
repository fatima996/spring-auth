# spring-auth

This application demonstrates how to make simple authentication using spring security and spring jdbc.

# Code explanation
After running the application with spring-boot:run go to http://localhost:8080/ where a simple login form can be found.
To login use either an admin or user then you will be directed to a home page. The admin user can access all routes including home(/), /admin or /user and user can access home and /user route.


In the schema.sql the data tables are initialized, and in data.sql the data for users and the authority roles
is also initialized when the application starts.

Controller.class is for demonstrating the authorization of users where we created three previously 
mentioned routes home(/), /admin or /user.

In the SecurityConfig.class you can find the security configurations that are connecting the application to datasource for credentials.
 You can also find configurations for accessible routes per user.

There is a password encoder we are using because spring security expects us to provide an encoder for the password. 
NoOpPasswordEncoder is used here for learning purposes and should not be used in production.
```java
 @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
```

In the following configure method the usersByUsernameQuery() method will tell spring security how to retrieve users from our data source. 
```java
@Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users where username = ?")
                .usersByUsernameQuery("select username,authority from authorities where username = ?");
    }
```
Although these are the default values for this method that spring security will check they can be used to override the defaults.

# jdbc 

By default, jdbc implementation will allow you to automatically have the UserDetailsService configured and checked for your users.

#jpa

The UserDetailsService must be instantiated and used to configure user lookup. 
MyUserDetails is constructed for each user.
The @EnableJpaRepositories(basePackageClasses = UserRepository.class) annotation must be added to the main class so that spring can find it.
Properties must be added to the application.properties file to tell spring where it can find the data source.
spring.datasource.url=jdbc:mysql://localhost:db_port/your_db
