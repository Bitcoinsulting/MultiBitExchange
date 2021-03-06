## The Vision

MultiBit Exchange is an exchange platform that can be leveraged as a starting point for creating an exchange of any
kind.

## What is it?

MultiBit Exchange is a platform that consists of a REST API front-end and trading engine back-end that
can be leveraged to manage markets, orders, accounts, and trades. It also aims to be very well tested and
clean making it easy to extend to support additional order types and matching algorithms.

## What can I do with it?

There is an endless variety of types of exchanges that can be created using MultiBit Exchange. Here are a few ideas:
* An exchange company such as Mt.Gox for trading USD for BTC
* An exchange centered around BTC with multiple markets for exchanging BTC for cell phone minutes, gift cards, gold, etc.
* A precious medal exchange: gold, silver, platinum, etc.
* A traditional currency exchange
* A test platform for experimenting with HFT algorithms, experimental order types, algorithmic trading, etc.
* An Inter-exchange arbitrage platform

## What are the major characteristics of MultiBit Exchange?

MultiBit Exchange aims to be more that just a functioning exchange, but a well crafted codebase that is:
* Well tested
* Well structured
* High-throughput / Low-latency by leveraging event sourcing and the [LMAX Disruptor pattern](http://martinfowler.com/articles/lmax.html).
* Extensible (not necessarily configurable or pluggable, but definitely malleable)

## What development methodology is used?

> "Clean code always looks like it was written by someone who cares."
> Michael Feathers

Great software doesn't just happen. It requires a disciplined approach. The following methodology is
used to develop MultiBit Exchange:

* Focus on the core domain and application of Domain Driven Design principles
* Application of Test Driven Development
* Disciplined development of well-structured layered code
* Leveraging proven existing technology wherever possible

## Architecture

MultiBit Exchange follows the hexagonal architecture. See: http://alistair.cockburn.us/Hexagonal+architecture

## Ultimate goals of MultiBit Exchange

MultiBit Exchange is relatively new, but I have ambitious plans:

* Decentralized - be resistant to shutdown and DDoS attacks.
* Reliable - be able to run with as close to zero downtime as possible.
* Reusable - be simple to understand, leverage, and extend.
* Robust - be thoroughly tested and publicly scrutinized.
* Performant - be able to handle huge volumes without low latency.
* Magical - do all of this without being difficult to use.

## Standing on the Shoulders of Giants

Many thanks to all the hard work that was put into the many ideas, libraries, and systems that MultiBit Exchange
is built on:

Domain Driven Design lies at the core of MultiBit Exchange. This is one of the most important contributions
to the software development craft.
Thank you Eric Evans! (http://skillsmatter.com/expert-profile/home/eric-evans)

google-guice - Guice is used for dependency injection throughout.
Thank you! https://code.google.com/p/google-guice/people/list

guava-libraries - Guava is used throughout and makes Java just a little nicer to work with.
Thank you! https://code.google.com/p/guava-libraries/people/list

Dropwizard - Dropwizard serves as the front-end for REST API and web interfaces.
Thank you! http://dropwizard.codahale.com/about/contributors/

LMAX Disruptor - The Disruptor pattern is used to help with speedy production and consumption of events.
Thank you! Michael Barker (https://github.com/mikeb01)

AXON Framework - The AXON Framework is used to help with CQRS.
Thank you AXON Framework Team! (

MongoDB - Much of the persistence is provided by MongoDB.
Thank you MongoDB Team! (http://www.mongodb.org/)

Heroku - Used as a hosting environment during development.
Thank you Heroku Team! (https://www.heroku.com/)

## Installing MongoDB

MongoDB is used to support [Read Models](http://martinfowler.com/bliki/CQRS.html).
Follow the usual [MongoDB installation instructions](http://docs.mongodb.org/manual/installation/), such as

```
$ brew update
$ brew install mongo
```

Start MongoDB as a background process with

```
$ mongod &
```

Then create the following collections through the Mongo CLI

```
$ mongo
> use mbexchange
> db.createCollection("market_read");
```

## Building and running

From the console you can do the following
```
$ cd <project root>
$ mvn clean install
$ java -jar target/web-develop-SNAPSHOT.jar server mbexchange-demo.yml
```

If startup was successful, then navigate to [localhost:8080/markets](http://localhost:8080/markets) to
see some JSON output.

Next, using a browser plugin like [POSTMAN](https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm?hl=en)
POST a JSON document to /markets to create a new market.

Include the following header
```
Content-type: application/json
```

The format should be
```
{
  "marketSymbol": "mbexchangeITMCUR",
  "itemSymbol": "ITM",
  "currencySymbol": "CUR"
}
```

Navigate back to [localhost:8080/markets](http://localhost:8080/markets) to
see the newly created market.

## Which branch?
Use `master` for the latest production release. Use `develop` for the latest release candidate.

If you wish to contribute, please start with `develop`.

## How was the startup banner generated?

http://patorjk.com/software/taag/#p=display&f=Doom&t=MultiBit%20Exchange


