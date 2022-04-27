<h1 align="center">Coffee Shop</h1> 

<a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
[![Medium](https://img.shields.io/badge/-Medium-000000?style=for-the-badge&logo=Medium&logoColor=white)]
[![Github](https://img.shields.io/badge/-Github-000000?style=for-the-badge&logo=Github&logoColor=white)](https://github.com/jnpallav1991)

<p align="center">  
Coffee Shop is a small demo application based on modern Android application tech-stacks and MVVM architecture. Fetching data from the network and render data via Paging 3.
</p>
</br>

<p align="center">
<img src="/previews/screenshot.jpg" width="50%"/>
</p>


<img src="/previews/preview.gif" align="right" width="32%"/>

## Tech stack & Open-source libraries
- Minimum SDK level 28
- [Kotlin](https://kotlinlang.org/) based.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- [Dagger](https://developer.android.com/training/dependency-injection/dagger-android) for dependency injection.
- Android Jetpack
    - Lifecycle - dispose of observing data when lifecycle state changes.
    - ViewModel - UI related data holder, lifecycle aware.
    - DataBinding - write code that interacts with views.
    - Navigation - navigate in the app.
    - Paging 3 - render list.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - Repository pattern
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
  <br>

## MAD Score
<img src="/previews/summary.png"/>
<img src="/previews/jetpack.png"/>

## Architecture
Coffee Shop is based on MVVM architecture and a repository pattern.
<p align="center">
  <img src="/previews/architecture.png"/>
</p>

## Open API
Coffee Shop using the [Yelp API](https://www.yelp.com/developers/documentation/v3) for constructing RESTful API.<br>

<b>How to run application</b>
- Register [Yelp API](https://www.yelp.com/developers/documentation/v3)
- Open local.properties file
- Add `bearer_token` line also add your api key like
~~~ 
bearer_token = CKmDi8usoyvnzdKZAvvEBG7s9OQNF9QIP3OGqVjk
~~~ 

## Blog
#[Android Paging 3 library with Limit and Offset parameters, MVVM, LiveData, Dagger, and Coroutine]

# License
```xml
Designed and developed by 2022 Pallav

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
