Commandes pour lancer le projet (communication avec kafka) :
Il faut avoir au préalable docker.
1. Lancer zookeeper : docker run -d --name zookeeper -p 2181:2181 zookeeper:3.8
2. Lancer kafka avec confluent : docker run -d --name kafka -p 9092:9092 -e KAFKA_ZOOKEEPER_CONNECT=host.docker.internal:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka:7.5.0
3. Vérifier que vous avez bien les 02 images de zookeeper et kafka tous les deux "Up" avec : docker ps
4. Lancer l'application de gestion de stock
5. Lancer l'application de gestion de commandes
6. Ajouter un article au stock
7. Créer une commande et la soumettre.

Dans le terminal de gestion de stock, vous aurez comme message : "Message reçu : nomArticle,quantiteArticle
le stock sera automatiquement mis à jour
