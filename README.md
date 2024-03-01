```bash
# first build te aggregaton-demo image

cd aggregation-demo
docker build -t aggregation-demo .

# then run docker-compose (make sure your 8080 and 8081 ports are free)
docker-compose up -d

# go to http://localhost:8081/ to see kafka-manager
# go to http://localhost:9090/ to see the prometheus dashboard

#close the containers
docker-compose down
```