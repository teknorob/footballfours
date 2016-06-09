package com.footballfours.core.user;

import javax.persistence.Column;

public class User
{
    @Column
    private String username;
    
    private boolean authenticated = false;
    
    @Column
    private String password = "password";
            
    public User(String password)
    {
        username = "Admin";
        authenticate(password);
    }
    
    public String getUsername()
    {
        return username;
    }

    @Column
    public boolean isAuthenticated()
    {
        return authenticated;
    }

    public boolean authenticate(String password)
    {
        authenticated = this.password.equals( password );
        return authenticated;
    }
}
