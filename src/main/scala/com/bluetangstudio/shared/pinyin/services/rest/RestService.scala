/*
 * Copyright 2010 Blue Tang Studio. All rights reserved.
 * Date: Aug 17, 2010 3:28:15 PM
 *
 */
package com.bluetangstudio.shared.pinyin.services.rest

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/rest/")
@Produces( Array(MediaType.APPLICATION_JSON))
trait RestService {

    @GET
    @Path("/tongyong/{input}")
    def toTongYong(@PathParam("input") input: String): String;

        @GET
    @Path("/wadegiles/{input}")
    def toWadegiles(@PathParam("input") input: String): String;

}