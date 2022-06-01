CREATE DATABASE `espm.ms.cabin`

CREATE TABLE `cabin` (
  `id` char(36) NOT NULL,
  `max_people` int NOT NULL,
  `price_person` decimal(2,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




