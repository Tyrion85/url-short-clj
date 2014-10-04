(ns url-short-clj.google
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn- shorten-via-google-api [url apiKey]
  (client/post
   (str "https://www.googleapis.com/urlshortener/v1/url?key=" apiKey)
   {:content-type :json
    :body (str "{\"longUrl\":\"" url "\"}")}))

(defn- expand-via-google-api [url]
  (client/get
   (str "https://www.googleapis.com/urlshortener/v1/url?shortUrl=" url)))

(defn- parse-response-body [response-body]
  (json/read-str
   response-body
   :key-fn keyword))

(defn shorten [url apiKey]
  (let [response (shorten-via-google-api url apiKey)
        response-body (parse-response-body (:body response))]
   (:id response-body)))

(defn expand [url]
  (let [response (expand-via-google-api url)
        response-body (parse-response-body (:body response))]
    (:longUrl response-body)))


