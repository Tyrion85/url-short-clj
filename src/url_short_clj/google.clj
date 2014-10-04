(ns url-short-clj.google
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn- call-google-api [url apiKey]
  (client/post
   (str "https://www.googleapis.com/urlshortener/v1/url?key=" apiKey)
   {:content-type :json
    :body (str "{\"longUrl\":\"" url "\"}")}))

(defn- parse-response-body [response-body]
  (json/read-str
   response-body
   :key-fn keyword))

(defn shorten-url [url apiKey]
  (let [response (call-google-api url apiKey)
        response-body (parse-response-body (:body response))]
   (hash-map :body response-body
             :status (:status response)
             :kind (:kind response-body)
             :id (:id response-body)
             :long-url (:longUrl response-body))))


