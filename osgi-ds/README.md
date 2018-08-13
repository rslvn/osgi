```
resulav@resula-pc:~$ karaf clean
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

karaf@root()> list                                                                                                                                                                                                                    
START LEVEL 100 , List Threshold: 50
ID │ State  │ Lvl │ Version │ Name
───┼────────┼─────┼─────────┼────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
21 │ Active │  80 │ 4.2.0   │ Apache Karaf :: OSGi Services :: Event
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> feature:install scr                                                                                                                                                                                                     
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> bundle:install -s mvn:com.example/osgi-ds-api
Bundle ID: 46
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> bundle:install -s mvn:com.example/osgi-ds-core/1.0-SNAPSHOT 
Bundle ID: 47
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> bundle:install -s mvn:com.example/osgi-ds-cli/1.0-SNAPSHOT
Bundle ID: 48
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> osgi-ds:sample-command 
com.example.osgi.ds.core.SampleManager
karaf@root()>                                                                                                                                                                                                                         
karaf@root()> list                                                                                                                                                                                                                    
START LEVEL 100 , List Threshold: 50
ID │ State  │ Lvl │ Version        │ Name
───┼────────┼─────┼────────────────┼─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
21 │ Active │  80 │ 4.2.0          │ Apache Karaf :: OSGi Services :: Event
46 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-ds-api
47 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-ds-core
48 │ Active │  80 │ 1.0.0.SNAPSHOT │ osgi-ds-cli
karaf@root()> scr:list                                                                                                                                                                                                                
 BundleId Component Name Default State
    Component Id State      PIDs (Factory PID)
 [  44]   ServiceComponentRuntimeMBean  enabled
    [   0] [active      ] 
 [  47]   com.example.osgi.ds.core.SampleManager  enabled
    [   1] [active      ] 
karaf@root()>          
```