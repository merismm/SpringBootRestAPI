CREATE TABLE `teams` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `foundationYear` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
);
 
CREATE TABLE `players` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `goals` int(3) NOT NULL,
  `age` int(2) NOT NULL,
  `team_id` int(6) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `players team` (`team_id`),
  CONSTRAINT `players team` FOREIGN KEY (`team_id`) REFERENCES `teams` (`id`)
);