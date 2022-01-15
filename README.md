#Task

Application : A string reply service is implemented with Spring boot Annotation. 
Why SpringBoot: Many Spring Boot developers like their apps to use auto-configuration, component scan and be able to define extra configuration on their "application class". 

Features Added: 

Two components comprised to a string : Rule and String [separated by '-']

Rules **always** contain two numbers. Each number represents a string operation.

The supported numbers are: 1 and 2

- `1`: reverse the string

   E.g. `kbzw9ru` becomes `ur9wzbk`

- `2`: encode the string via MD5 hash algorithm and display as hex

   E.g. `kbzw9ru` becomes `0fafeaae780954464c1b29f765861fad`

Resulting in conversion of the string based on the reply format:

Like
```
GET /v2/reply/11-kbzw9ru
{
    "data": "kbzw9ru"
}
```
```
GET /v2/reply/12-kbzw9ru
{
    "data": "5a8973b3b1fafaeaadf10e195c6e1dd4"
}
```
```
GET /v2/reply/22-kbzw9ru
{
    "data": "e8501e64cf0a9fa45e3c25aa9e77ffd5"
}
```


It also returns response status for a valid or invalid input. If an invalid number other than 1 or 2 is entered, 400 message will be displayed.


## To build this project

Go the the work directory and simply run the below command:
```
./gradlew build
```

## To start the project

To start run below command:
```
./gradlew bootRun
```

> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.2.RELEASE)



Once the service started, the endpoint will be available at `localhost:8080`, so you can make request to the service endpoint