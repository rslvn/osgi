```
resulav@resula-pc:/tools/apache-karaf-4.2.0$ bin/karaf clean
karaf: Ignoring predefined value for KARAF_HOME
        __ __                  ____      
       / //_/____ __________ _/ __/      
      / ,<  / __ `/ ___/ __ `/ /_        
     / /| |/ /_/ / /  / /_/ / __/        
    /_/ |_|\__,_/_/   \__,_/_/         

  Apache Karaf (4.2.0)

Hit '<tab>' for a list of available commands
and '[cmd] --help' for help on a specific command.
Hit '<ctrl-d>' or type 'system:shutdown' or 'logout' to shutdown Karaf.

karaf@root()> feature:repo-add mvn:com.example/osgi-felix-scr-features/1.0-SNAPSHOT/xml
Adding feature url mvn:com.example/osgi-felix-scr-features/1.0-SNAPSHOT/xml
karaf@root()>  
karaf@root()> feature:install osgi-felix-scr-rest
karaf@root()>  
karaf@root()>  
karaf@root()> cxf:list-endpoints 
Name            │ State   │ Address │ BusID
────────────────┼─────────┼─────────┼─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
SampleResources │ Started │ /       │ com.example.osgi-felix-scr-rest-cxf1513072369
karaf@root()>  
karaf@root()>  
karaf@root()> feature:install osgi-felix-scr-cli 
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> osgi-felix-scr:sample-command                                                                                                                                                                                           
com.example.osgi.felix.scr.core.SampleManager
karaf@root()>  
karaf@root()>  
karaf@root()> list                                                                                                                                                                                                                    
START LEVEL 100 , List Threshold: 50
 ID │ State  │ Lvl │ Version        │ Name
────┼────────┼─────┼────────────────┼────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
 21 │ Active │  80 │ 4.2.0          │ Apache Karaf :: OSGi Services :: Event
 43 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-felix-scr-api
 44 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-felix-scr-core
 45 │ Active │  80 │ 1.0.0.SNAPSHOT │ Apache Karaf :: Examples :: REST :: Provider
 46 │ Active │  80 │ 2.9.4          │ Jackson-annotations
 47 │ Active │  80 │ 2.9.4          │ Jackson-core
 48 │ Active │  80 │ 2.9.4          │ jackson-databind
 49 │ Active │  80 │ 2.9.4          │ Jackson-JAXRS-base
 50 │ Active │  80 │ 2.9.4          │ Jackson-JAXRS-JSON
 85 │ Active │  80 │ 1.1.1          │ geronimo-jms_1.1_spec
 94 │ Active │  80 │ 2.0.19         │ Apache MINA Core
118 │ Active │  80 │ 4.6.0          │ Apache XBean OSGI Bundle Utilities
119 │ Active │  80 │ 4.6.0          │ Apache XBean :: Classpath Resource Finder
158 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-felix-scr-cli
karaf@root()>  
karaf@root()>  
karaf@root()> scr:list
 BundleId Component Name Default State
    Component Id State      PIDs (Factory PID)
 [  44]   com.example.osgi.felix.scr.core.SampleManager  enabled
    [   2] [active      ] 
 [  92]   ServiceComponentRuntimeMBean  enabled
    [   1] [active      ] 
 [ 155]   org.ops4j.pax.web.service.internal.WhiteboardDtoService  enabled
    [   0] [active      ] 
karaf@root()>                         
```