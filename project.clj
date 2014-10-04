(defproject url-short-clj "0.1.0-SNAPSHOT"
  :description "Clojure Wrapper around some common URL Shortener services"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "1.0.0"]
                 [org.clojure/data.json "0.2.5"]]
  :plugins [[lein-ancient "0.5.4"]]
  :profiles
    {:dev
      {:dependencies [[midje "1.6.3"]]
       :plugins [[lein-midje "3.1.3"]]}}
  :resource-paths ["shared" "resources"])
