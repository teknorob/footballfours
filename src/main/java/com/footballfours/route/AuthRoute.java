package com.footballfours.route;

import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.Connection;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.footballfours.core.route.RegistrableRoute;
import com.footballfours.core.user.User;
import com.j256.ormlite.support.ConnectionSource;

public class AuthRoute extends RegistrableRoute
{
    public AuthRoute( final Connection connection )
    {
        super( connection );
    }

    @Override
    public void register()
    {
        get( "/logout", "application/json", ( request, response ) -> {
            request.session().removeAttribute( "user" );
            Map<String, Object> page = getNewPageModel( request );
            return page;
        }, getJsonTransformer() );

        post( "/login", "application/json", ( request, response ) -> {
            request.session( true ).attribute( "user", new User( "password" ) );
            Map<String, Object> page = getNewPageModel( request );
            
//            ObjectMapper mapper = new ObjectMapper();
//            User user = mapper.readValue( request.bodyAsBytes(), User.class );
            
            
            return page;
        }, getJsonTransformer() );

    }
}
