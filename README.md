# Prometheus kafka demo

In this project, we have created a Prometheus instance and a Kafka system. Raw data from Prometheus is fed into Kafka using the Prometheus Kafka Adapter. This data is then read by a KumuluzEE Java microservice, which also produces four topics that aggregate the collected data. Additionally, we have a Kafka UI for easy management of the Kafka system.

We have created 5 Kafka topics - one with raw data and 4 with aggregated data.

![image](https://github.com/AnejVovcak/prometheus-kafka-demo/assets/79155108/bbf48cf0-25e6-41bd-bc5f-f7ffa5ced14c)

This is how the stream of metrci_values_WMA looks like:

![image](https://github.com/AnejVovcak/prometheus-kafka-demo/assets/79155108/56ca405f-8801-422c-bbaf-4a44f795d206)



## Services

- **Prometheus**: Monitoring and alerting toolkit. It's configured with a custom configuration file and accessible on port 9090.

- **Kafka**: A distributed streaming platform. It's set up with a Zookeeper instance and accessible on port 9092.

- **Zookeeper**: A centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services.

- **Prometheus Kafka Adapter**: An adapter to push Prometheus metrics to Kafka. It's configured to connect to the Kafka broker and push data to the `prometheus_raw_data` topic.

- **Kafka UI**: A user interface for Kafka for easy management. It's configured to connect to the Kafka broker and Zookeeper instance and accessible on port 8081.

- **Aggregation Demo**: A demo service that produces and consumes from the Kafka broker. It's accessible on port 8080.

## Getting Started

To start the project, ensure you have Docker and Docker Compose installed, then run:

```bash
# first build te aggregaton-demo image
cd aggregation-demo
docker build -t aggregation-demo .
cd ..
```

```bash
# run docker-compose (make sure your 8080 and 8081 ports are free)
docker-compose up
```

This will pull the necessary images and start the services.

## Accessing the Services

- Prometheus: [http://localhost:9090](http://localhost:9090)
- Kafka UI: [http://localhost:8081](http://localhost:8081)
- Aggregation Demo: [http://localhost:8080](http://localhost:8080)

## Stopping the Services

To stop the services, run:

```bash
docker-compose down
```

This will stop and remove the containers.
