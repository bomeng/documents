# Documentation related to Apache Zookeeper

## Installation

```
$ brew install kafka
```

## Start Kafak

```
$ kafka-server-start /usr/local/etc/kafka/server.properties
```

## Stop Kafka

```
$ kafka-server-stop
```

## Create a topic (topic: test)

```
$ kafka-topics --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
```

## Send a message
```
$ kafka-console-producer --broker-list localhost:9092 --topic test
>HELLO Kafka
```

## Receive a message
```
$ kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning
HELLO Kafka
```

