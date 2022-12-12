use groooshoppingmall;
create table category (
                          `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                          `name` VARCHAR(255) DEFAULT NULL,
                          `code` VARCHAR(255) DEFAULT NULL,
                          `is_deleted` BIT DEFAULT 0,
                          `created_at` DATETIME(6) DEFAULT NULL,
                          `updated_at` DATETIME(6) DEFAULT NULL,
                          PRIMARY KEY (`id`)
);

create table product (
                         `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(255) DEFAULT NULL,
                         `description` varchar(255) DEFAULT NULL,
                         `price` Float DEFAULT NULL,
                         `image` VARCHAR(255) DEFAULT NULL,
                         `is_deleted` BIT DEFAULT 0,
                         `created_at` DATETIME(6) DEFAULT NULL,
                         `updated_at` DATETIME(6) DEFAULT NULL,
                         `category_id` BIGINT(20) NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `fk_category` (`category_id`),
                         CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);

create table user (
                      `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                      `username` VARCHAR(255) DEFAULT NULL,
                      `password` varchar(255) DEFAULT NULL,
                      `fullname` varchar(255) DEFAULT NULL,
                      `is_deleted` BIT DEFAULT 0,
                      `created_at` DATETIME(6) DEFAULT NULL,
                      `updated_at` DATETIME(6) DEFAULT NULL,
                      PRIMARY KEY (`id`)
);
create table `order` (
                         `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                         `total_price` Float DEFAULT NULL,
                         `total_amount` INT DEFAULT NULL,
                         `is_deleted` BIT DEFAULT 0,
                         `created_at` DATETIME(6) DEFAULT NULL,
                         `updated_at` DATETIME(6) DEFAULT NULL,
                         `user_id` BIGINT(20) NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `fk_user` (`user_id`),
                         CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);
create table order_item (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `quantity` INT DEFAULT NULL,
                            `is_deleted` BIT DEFAULT 0,
                            `created_at` DATETIME(6) DEFAULT NULL,
                            `updated_at` DATETIME(6) DEFAULT NULL,
                            `product_id` BIGINT(20) NOT NULL,
                            `order_id` BIGINT(20) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_product` (`product_id`),
                            CONSTRAINT `fk_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
                            KEY `fk_order` (`order_id`),
                            CONSTRAINT `fk_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`)
);
