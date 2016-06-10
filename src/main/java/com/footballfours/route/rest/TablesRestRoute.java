package com.footballfours.route.rest;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.Connection;
import java.util.Map;

import com.footballfours.core.route.RegistrableRoute;
import com.footballfours.model.table.Tables;
import com.footballfours.model.table.builder.TablesModelBuilder;

public class TablesRestRoute extends RegistrableRoute
{
    public TablesRestRoute( final Connection connection )
    {
        super( connection );
    }

    @Override
    public void register()
    {
        get( "/tables", "application/json", ( request, response ) -> {
            Map<String, Object> page = getNewPageModel( request );
            
            final Tables tables  =
                    TablesModelBuilder.getTablesFromConnection( getConnection() );
            
            page.put( "tables", tables );
            
            return page;
        }, getJsonTransformer() );

        get( "/tables/:tableId", "application/json", ( request, response ) -> {
            Map<String, Object> page = getNewPageModel( request );
            return page;
        }, getJsonTransformer() );

        delete( "/tables/:tableId", "application/json", ( request, response ) -> {
            Map<String, Object> page = getNewPageModel( request );
            return page;
        }, getJsonTransformer() );

        post( "/tables", "application/json", ( request, response ) -> {
            Map<String, Object> page = getNewPageModel( request );
            return page;
        }, getJsonTransformer() );

    }
}
