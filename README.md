# Shop Android - A Case Study
If you have not already, please checkout the [base repo](https://github.com/niccorder/Shop) which goes over much more detailed information regarding this project.

This repository is the setup of our Android client which will interface with our [restful microservices](https://github.com/niccorder/shop-server) and will show how client engineers architect, and implement restful api's in the client programming paradigm. The stack of this application uses the following:
- RxJava - an awesome implementation of the Gang of Four's Observable pattern. A must have.
- Android support/design libraries - Awesome libraries for UI, and managing/handling older API's.
- Retrofit2 - A beautifully designed library to ease the implementation of RESTful endpoints.
- Realm - An awesome library for interacting with persistent databases on device.
- Dagger2 - Googles extention of Square's Dagger... used for dependency injection in the most awesome way.

### The Architecture
So what the fuck is going on here? Well - I'll help you figure things out!

#### Required Reading
I decided to use one of the newer design pattern's created by my boy Uncle Bob! **Clean Architecture**, as he called it, is a way to help segregate business logic, application logic, and platform logic into separate testable layers. My opinion is that this is the most proper way to implement an android application as just works, and once you understand the flow... you will see how awesome it is.

[We have a few rules we need to follow](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html), but the most important thing for now is **The Dependency Rule**.

> The Dependency Rule

> The concentric circles represent different areas of software. In general, the further in you go, the higher level the software becomes. The outer circles are mechanisms. The inner circles are policies.

> The overriding rule that makes this architecture work is The Dependency Rule. This rule says that source code dependencies can only point inwards. Nothing in an inner circle can know anything at all about something in an outer circle. In particular, the name of something declared in an outer circle must not be mentioned by the code in the an inner circle. That includes, functions, classes. variables, or any other named software entity.

> By the same token, data formats used in an outer circle should not be used by an inner circle, especially if those formats are generate by a framework in an outer circle. We don’t want anything in an outer circle to impact the inner circles.

**TL;DR -** Dependencies should only flow inwards. I digress that if I see your domain layer add `compile project(':shop-app')` I might just flip a bitch. If your unaware of what inwards is... check this out:

![Dependency flow chart](https://8thlight.com/blog/assets/posts/2012-08-13-the-clean-architecture/CleanArchitecture-8b00a9d7e2543fa9ca76b81b05066629.jpg)

#### How It's Implemented
With you understanding the basics of Clean Architecture... let me explain how it is honored in this application.

- The outer layer
  - UI - This is our android view's, activities, and fragments.
  - DB - This is where Realm steps in. Beautifully abstracts our android specific dependencies from our presenters.
  - Networking - This is where retrofit2 steps in. This awesome library allows us to serve up our services for the network.
- The middle layer
  - Presenters - Our core application logic is handled here. Please that our presenters should never be dependant on the android platform itself. This allows us to only truly require unit testing for our presenters to ensure we are preforming correct application specific logic.
  - Services - Our data layer provides an interface which our presenters can implement. This still allows our presenter to be negligent to the actual implementation.
- The inner layer
  - Use Cases (Interactors) - Our use cases are what actually drive our business logic. I call them interactors since it just seems to make more sense to me. It's the interaction of our business use case, and the actual execution of it.

So lets take a look shall we...
> Our GetItemInteractor (Inner Layer) is dependent on our ItemRepository (Inner Layer). Dependencies neither flow inward or outward, but they flow horizontally. :heavy_check_mark:

> Our ItemListPresenter(Middle Layer) depends on our GetItemInteractor(Inner Layer) and our ListItemView (Middle Layer). Dependencies here flow Inward :heavy_check_mark:, and also flow horizontally :heavy_check_mark:

> Our ItemListFragment(Outer Layer) implements our ListItemView(Middle Layer), and depends on ItemListPresenter(Middle Layer). Dependencies here only flow inward :heavy_check_mark:

I hope this example clears up the architecture in general. In the future I will explain more in depth about clean architecture, and how it relates to this project in it's current state.