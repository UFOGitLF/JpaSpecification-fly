--Person表
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_age` int(11) DEFAULT NULL,
  `person_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `person` VALUES ('1', '18', 'fly');
--Phone表
DROP TABLE IF EXISTS `phone`;
CREATE TABLE `phone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `phone_category` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkk6uij3j6wikpnqlj9dymobs9` (`person_id`(250))
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;


INSERT INTO `phone` VALUES ('1', '1', '三星S7', '15812344321');
INSERT INTO `phone` VALUES ('2', '1', 'IphoneX', '13399997865');
--Power表
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `power_category` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `power_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnp324gnevt0rpiyy76i6utr9w` (`phone_id`(250))
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `power` VALUES ('1', '1', '小米', '小米无敌充电器');
INSERT INTO `power` VALUES ('2', '2', '苹果', '苹果垃圾充电器');
INSERT INTO `power` VALUES ('3', '2', '苹果', '苹果牛逼充电器');
