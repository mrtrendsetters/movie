-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2018 at 09:33 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `movie-shovie`
--

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE IF NOT EXISTS `genre` (
  `genre_id` int(2) NOT NULL AUTO_INCREMENT,
  `genre` varchar(30) NOT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `movie_name` varchar(100) NOT NULL,
  `genre1` varchar(25) NOT NULL,
  `genre2` varchar(25) DEFAULT NULL,
  `genre3` varchar(25) DEFAULT NULL,
  `release_year` int(4) DEFAULT NULL,
  `rating` float(3,1) DEFAULT NULL,
  `tobedownloaded` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tobewatched` timestamp NULL DEFAULT NULL,
  `watched` timestamp NULL DEFAULT NULL,
  `pg` int(1) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;
