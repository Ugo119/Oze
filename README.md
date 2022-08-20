# Oze
A quick test to fetch users on github

App uses MVVM architecture supported by Single Source of Truth (SSOT).
We treat persistence layer as a SSOT  which is composed of Shared Preferences and SQLite Database.

Room is used as database abstraction library
https://developer.android.com/training/data-storage/room

Retrofit is used for network calls

RxJava is used for the asynchronous and event-based calls.

For Dependency Injection - Dagger is used.
Each of the gradle modules contains a general dagger module (for Persistence - PersistenceModule, 
Network - NetworkModule etc.) Purpose of those modules is to aggregate other dagger modules within the gradle library.

Application uses Traits. Traits are used to extract some of the features of the Fragments
In this way making them reusable. Some functionalities they are used to extract include Navigation 
methods, Bottom Sheet Management, Work Manager Helpers, etc.


Services / Modules
Project is composed of 5 modules.
(persistence, network, domain, utility,and app)

Shared modules responsibilities
utility - various utils such as logger, view or animations util classes also things used across 
other modules (e.g. secure storage used both in network an domain)
persistence - implements persistence models, converters and managers
network - implements network dtos and managers
domain - hides modules below, incl. domain models and managers, provides logics for processing data 
between network module and persistence module.
application-shared - shared module for abstract base screen and view models classes. In this way
the screen might have shared logic and ui with options to alter those on inherited classes. 

Network call
Flows from the Api interfaces in the network module through the network managers to the 
domain managers and then to the viewmodels.

All image resources are SVG files in order to minimize app size.

