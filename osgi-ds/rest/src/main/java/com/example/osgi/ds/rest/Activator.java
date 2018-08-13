package com.example.osgi.ds.rest;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created by resulav on 13.08.2018.
 */
public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start( BundleContext context ) throws Exception {
        SampleResources exampleService = new SampleResources();
        registration = context.registerService( SampleResources.class.getName(), exampleService, null );
    }

    @Override
    public void stop( BundleContext context ) throws Exception {
        registration.unregister();
    }
}
