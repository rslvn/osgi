<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [ds](#ds)
  - [deployment to karaf](#deployment-to-karaf)
    - [bundle deployment](#bundle-deployment)
      - [dependent feature deployment](#dependent-feature-deployment)
      - [ds-api](#ds-api)
      - [ds-core](#ds-core)
      - [ds-cli](#ds-cli)
    - [feature deployment](#feature-deployment)
      - [add feature.xml](#add-featurexml)
      - [osgi-ds-base](#osgi-ds-base)
      - [osgi-ds-cli](#osgi-ds-cli)
      - [osgi-ds-rest](#osgi-ds-rest)
      - [osgi-ds-all](#osgi-ds-all)
    - [REST test](#rest-test)
      - [/ds/sample/hello](#dssamplehello)
      - [/ds/sample/name](#dssamplename)
      - [/ds/sample/config](#dssampleconfig)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# osgi-ds

## deployment to karaf

### bundle deployment

#### dependent feature deployment
```
feature:install scr
```
#### ds-api
```
bundle:install -s mvn:com.example/osgi-ds-api/1.0-SNAPSHOT

list
bundle:list
```

#### ds-core
```
bundle:install -s mvn:com.example/osgi-ds-core/1.0-SNAPSHOT

list
bundle:list
```

#### ds-cli
```
bundle:install -s mvn:com.example/osgi-ds-cli/1.0-SNAPSHOT

list
bundle:list

osgi-ds:echo -p engineer resul
osgi-ds:echo -p engineer resul avan
osgi-ds:echo -p engineer -a 35 resul avan

```

### feature deployment

#### add feature.xml
```
feature:repo-add mvn:com.example/osgi-ds-features/1.0-SNAPSHOT/xml
 
feature:repo-list | grep osgi-ds
```

#### osgi-ds-base
```
feature:install osgi-ds-base

feature:list | grep osgi-ds
```

#### osgi-ds-cli
```
feature:install osgi-ds-cli

feature:list | grep osgi-ds

osgi-ds:echo -p engineer resul
osgi-ds:echo -p engineer resul avan
osgi-ds:echo -p engineer -a 35 resul avan
```

#### osgi-ds-rest
```
feature:install osgi-ds-rest

feature:list | grep osgi-ds

cxf:list-endpoints

```

#### osgi-ds-all
```
feature:install osgi-ds-all

feature:list | grep osgi-ds

```

### REST test

#### /osgi-ds/sample/hello
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/osgi-ds/sample/hello
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:38:52 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

Hello com.example.osgi.ds.rest.SampleResources
```

#### /osgi-ds/sample/name
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/osgi-ds/sample/name
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:39:05 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

com.example.osgi.ds.core.SampleManager
```

#### /osgi-ds/sample/config
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/osgi-ds/sample/config
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:39:23 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

{"name":"bar","maxSize":10,"number":0}
```