<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [felix-scr](#felix-scr)
  - [deployment to karaf](#deployment-to-karaf)
    - [bundle deployment](#bundle-deployment)
      - [dependent feature deployment](#dependent-feature-deployment)
      - [felix-scr-api](#felix-scr-api)
      - [felix-scr-core](#felix-scr-core)
      - [felix-scr-cli](#felix-scr-cli)
    - [feature deployment](#feature-deployment)
      - [add feature.xml](#add-featurexml)
      - [osgi-felix-scr-base](#osgi-felix-scr-base)
      - [osgi-felix-scr-cli](#osgi-felix-scr-cli)
      - [osgi-felix-scr-rest](#osgi-felix-scr-rest)
      - [osgi-felix-scr-all](#osgi-felix-scr-all)
    - [REST test](#rest-test)
      - [/felix-scr/sample/hello](#felix-scrsamplehello)
      - [/felix-scr/sample/name](#felix-scrsamplename)
      - [/felix-scr/sample/config](#felix-scrsampleconfig)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# felix-scr

## deployment to karaf

### bundle deployment

#### dependent feature deployment
```
feature:install scr
```
#### felix-scr-api
```
bundle:install -s mvn:com.example/osgi-felix-scr-api/1.0-SNAPSHOT

list
bundle:list
```

#### felix-scr-core
```
bundle:install -s mvn:com.example/osgi-felix-scr-core/1.0-SNAPSHOT

list
bundle:list
```

#### felix-scr-cli
```
bundle:install -s mvn:com.example/osgi-felix-scr-cli/1.0-SNAPSHOT

list
bundle:list

osgi-felix-scr:echo -p engineer resul
osgi-felix-scr:echo -p engineer resul avan
osgi-felix-scr:echo -p engineer -a 35 resul avan

```

### feature deployment

#### add feature.xml
```
feature:repo-add mvn:com.example/osgi-felix-scr-features/1.0-SNAPSHOT/xml
 
feature:repo-list | grep osgi-felix-scr
```

#### osgi-felix-scr-base
```
feature:install osgi-felix-scr-base

feature:list | grep osgi-felix-scr
```

#### osgi-felix-scr-cli
```
feature:install osgi-felix-scr-cli

feature:list | grep osgi-felix-scr

osgi-felix-scr:echo -p engineer resul
osgi-felix-scr:echo -p engineer resul avan
osgi-felix-scr:echo -p engineer -a 35 resul avan
```

#### osgi-felix-scr-rest
```
feature:install osgi-felix-scr-rest

feature:list | grep osgi-felix-scr

cxf:list-endpoints

```

#### osgi-felix-scr-all
```
feature:install osgi-felix-scr-all

feature:list | grep osgi-felix-scr

```

### REST test

#### /felix-scr/sample/hello
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/felix-scr/sample/hello
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:34:08 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

Hello com.example.osgi.felix.scr.rest.SampleResources
```

#### /felix-scr/sample/name
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/felix-scr/sample/name
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:34:26 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

com.example.osgi.felix.scr.core.SampleManager
```

#### /felix-scr/sample/config
```
curl -i -X GET -H "Content-Type: application/json" http://localhost:8181/cxf/felix-scr/sample/config
HTTP/1.1 200 OK
Content-Type: application/json
Date: Thu, 16 Aug 2018 10:34:40 GMT
Transfer-Encoding: chunked
Server: Jetty(9.4.6.v20170531)

{"name":"nameVal","maxSize":10,"number":100}
```