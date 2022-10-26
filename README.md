# Examples of use of the udata API in Java

Data.public.lu relies on the [udata platform](https://github.com/opendatateam/udata) and provides an [API](https://data.public.lu/fr/docapi/) to give access to most of the features of the platform.

This repository contains for now one example showing how to update a resource in a dataset. It will be extended at a later stage with other use cases.
This example shows how to use the udata API to update a file in a dataset.

This example is compatible with Java 8 and requires maven to build the project.


## How to build the project

```
mvn package
```

## How to configure the tool

Create a .env file based on the .env.example file. Set the correct values in this file. The API key can be found on your account on data.public.lu in the "Profil" section.
The id of the dataset can be found on the page of the dataset, in the metadata tab.
The id of the resource can be found in the details of the resource, at the end of the permalink.

## How to run the tool

```
java -jar ./target/udata-client-1.0.jar
```

## License

This project is published by the [luxembourgish Open Data](https://data.public.lu) team under the MIT license.
