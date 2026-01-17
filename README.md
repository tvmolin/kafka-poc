# kafka-poc

🚀 Core PoC Features (Order Placement App)
These items form a minimal but realistic end‑to‑end Kafka workflow:

Create an orders topic with sensible partitions

Build a Java producer that publishes OrderCreated events

Implement a consumer service that processes incoming orders

Add a second consumer group to simulate multiple downstream systems

Use keys to ensure ordering per customer

Add basic error handling and retries

Persist processed orders to an in‑memory store (H2/Map) for visibility

Expose a simple REST endpoint to place orders and trigger events

Add logging to trace message flow end‑to‑end

These steps give you a clean, testable pipeline: REST → Producer → Kafka → Consumers → Storage.

🔥 Advanced Kafka Topics to Explore
Once the basics are running, these challenges push you toward production‑grade thinking:

Schema evolution and breaking changes using Avro/Protobuf + Schema Registry

Handling extremely high throughput with batching, compression, and partition tuning

Idempotent producers and exactly‑once semantics

Dead‑letter queues and poison‑pill handling

Consumer lag monitoring and rebalancing behavior

Transactional messaging across multiple topics

Using Kafka Streams for order enrichment or validation

Event sourcing patterns and replaying historical events

Multi‑cluster replication with MirrorMaker 2

Security: TLS, SASL, ACLs, and client authentication
