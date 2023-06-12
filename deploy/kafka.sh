docker run --name kafka -p 9092:9092 \
   -e KAFKA_ADVERTISED_HOST_NAME=192.168.65.0 -e KAFKA_ZOOKEEPER_CONNECT=192.168.65.0/24 \
   -e KAFKA_CREATE_TOPICS="account-events:4:1" \
   -d wurstmeister/kafka