/*
 * Copyright 2010 Blue Tang Studio. All rights reserved.
 * Date: Aug 17, 2010 3:09:09 PM
 */
package com.bluetangstudio.shared.pinyin.services

import org.apache.tapestry5.ioc.{Configuration, MappedConfiguration,OrderedConfiguration,ServiceBinder,ObjectLocator}

import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector
import org.codehaus.jackson.jaxrs.JacksonJsonProvider
import org.apache.tapestry5.ioc.annotations.{SubModule, InjectService, EagerLoad}

import com.bluetangstudio.shared.jersey.services.JerseyModule
import rest.{RestServiceImpl, RestService}


@SubModule(Array(classOf[JerseyModule]))
object AppModule  {
    def bind(binder : ServiceBinder) = {
        binder.bind[RestService](classOf[RestService], classOf[RestServiceImpl]);
    }

    
    def buildJacksonJsonProvider : JacksonJsonProvider = {
        val mapper = new ObjectMapper;
        val introspector = new JaxbAnnotationIntrospector;
        mapper.getDeserializationConfig.setAnnotationIntrospector(introspector);
        mapper.getSerializationConfig().setAnnotationIntrospector(introspector);
        return new JacksonJsonProvider(mapper);

    }
    def contributeJerseyRootResources(
            configuration: Configuration[Object], 
            objectLocator: ObjectLocator,
            jsonProvider: JacksonJsonProvider) {
        configuration.add(objectLocator.getService(classOf[RestService]));
        configuration.add(jsonProvider);
    }


}