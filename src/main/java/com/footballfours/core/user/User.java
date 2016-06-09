package com.footballfours.core.user;

import javax.persistence.Column;

public class User
{
    @Column
    private String username;
    
    @Column
    private String password;
    
    private boolean authenticated = false;
            
    public User()
    {
    }
    
    @Column
    public boolean isAuthenticated()
    {
        return authenticated;
    }
    
    public void setAuthenticated( boolean authenticated )
    {
        this.authenticated = authenticated;
    }

    public String getPassword()
    {
        return password;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

}
