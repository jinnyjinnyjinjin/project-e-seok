DROP TABLE IF EXISTS expense_items;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE expense_items
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT,
    `spent_date`   date       NOT NULL,
    `created_at`   datetime   NOT NULL default NOW(),
    `updated_at`   datetime   NOT NULL default NOW(),
    `description` varchar(200),
    `spent`       int        NOT NULL,
    `income`      int                 DEFAULT NULL,

    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

LOCK TABLES expense_items WRITE;

INSERT INTO expense_items (`spent_date`, `description`, `spent`)
VALUES ('2023-05-01', '월급', 250000);
INSERT INTO expense_items (`spent_date`, `description`, `spent`)
VALUES ('2023-05-13', '전기세', 20000);
INSERT INTO expense_items (`spent_date`, `description`, `spent`)
VALUES ('2023-05-20', '식대', 10000);
INSERT INTO expense_items (`spent_date`, `description`, `spent`)
VALUES ('2023-04-02', '식대', 2000);

UNLOCK TABLES;