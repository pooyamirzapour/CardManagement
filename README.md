# CardManagement
The project has 6 main packages:
1) In the API package, there are two packages with their own domain and APIs: notification and payment.
2) In the controller package, there is a class that is an entry point for the requests.
3) In the internal package, there are interfaces and classes that we need for implementing card and transfer services, the main usage of these classes is FacadeService.
4) In the repository service, there are some classes for working the database.
5) In the usecase package, there is the implementation of FacadeService that call internal package's services.
6) In the util package, every util useful class has been placed.

