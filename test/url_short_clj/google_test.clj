(ns url-short-clj.google-test
  (:use midje.sweet url-short-clj.google))

(fact "Long url of shortened http://www.google.com should remain the same after shorening"
      (:long-url (shorten-url
       "http://www.google.com"
       "AIzaSyA0YzaajSNy2r6Tp8jaXzQOLp1-B1uWsk4")
      ) => "http://www.google.com/")
