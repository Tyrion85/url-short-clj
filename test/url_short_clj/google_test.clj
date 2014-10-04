(ns url-short-clj.google-test
  (:use midje.sweet url-short-clj.google))

(fact "Short url of shortened 'http://www.google.com' for api key '' should be 'http://goo.gl/fbsS'"
      (shorten
       "http://www.google.com"
       "AIzaSyA0YzaajSNy2r6Tp8jaXzQOLp1-B1uWsk4")
      => "http://goo.gl/fbsS")

(fact "Lengthening a short url 'http://goo.gl/fbsS' should produce 'http://www.google.com/'"
      (expand "http://goo.gl/fbsS")
      => "http://www.google.com/")
