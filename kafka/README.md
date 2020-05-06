# Documentation related to Apache Kafka

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

## List all the topics
```
$ kafka-topics --list --zookeeper localhost:2181
```

## Delete a topic
```
# This command will have no effect if in the Kafka server.properties file, if delete.topic.enable is not set to true.

$ kafka-topics --zookeeper localhost:2181 --delete --topic test
```

## Describe a topic
```
$ kafka-topics --describe --topic test --zookeeper localhost:2181
```

