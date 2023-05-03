# AlabsCoreAnalytics
## Content
* [Introduction](#introduction)
* [Setup](#setup)
* [Example](#example)
## Introduction

This library is used to create instances of analytics in order to send events. Works with:
* AppMetrica
* Firebase

## Setup
First you need to add this line in your gradle file
```
implementation 'com.github.azimutlabsmobile:AlabsCoreAnalytics:1.0'
```
After that we need to specify wich metrics we want to use
``` kotlin

//Creating our builder
val builder = Analytics.Builder(app)
  .registerFirebaseAdapter() //registering firebase
  .registerAppMetricaAdapter(APP_METRICS_API_DEV) //registering app metrica
  .build()
  
//Letting our facade know wich metrics we use
val facade = DefaultAnalyticsFacade().apply { 
  registerAdapters(builder.getAdapters())
}
``` 
Then we are ready to send events with or without params
``` kotlin
//creating params
val params: MutableMap<String, String> = mutableMapOf()
params.put(key = "key", value = "value")
facade.sendEvent(eventName = "event without params") // sending event without params
facade.sendEvent(eventName = "event with params", parametersMap = params) // sending event with params
```
