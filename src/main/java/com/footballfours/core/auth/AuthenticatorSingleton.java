package com.footballfours.core.auth;

import com.footballfours.core.user.User;

public final class AuthenticatorSingleton
{
    private static AuthenticatorSingleton instance = null;

    private String username;

    private String password;

    private AuthenticatorSingleton()
    {
    }

    private void setUsername( String username )
    {
        this.username = username;
    }

    private void setPassword( String password )
    {
        this.password = password;
    }

    public static AuthenticatorSingleton getInstance()
    {
        return instance;
    }

    /*
     * Sets up s-auth (stupid-authentication) while I think of how we're really
     * going to handle auth.
     */
    public static AuthenticatorSingleton initialize( String username, String password )
    {
        if ( instance == null )
        {
            instance = new AuthenticatorSingleton();
            instance.setPassword( password );
            instance.setUsername( username );
        }
        else
        {
            throw new RuntimeException(
                "AuthenticatorSingleton already initialized." );
        }
        return instance;
    }

    public void authenticate( User user )
    {
        user.setAuthenticated ( this.username.equals( user.getUsername() )
                && this.password.equals( user.getPassword() ) );
    }

}
