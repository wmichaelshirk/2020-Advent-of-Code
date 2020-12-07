(ns day2
  (:require [clojure.java.io :as io]))

(defn parse-line [line]
  (let [[_ min max ch password] (re-matches #"(\d+)-(\d+) (\w): (\w+)" line)]
  {:min (Integer/parseInt min)
   :max (Integer/parseInt max)
   :ch (nth ch 0)
   :password password}
  ))

(defn read-database [filename]
  (with-open [rdr (io/reader filename)]
    (->> rdr
         line-seq
        (mapv parse-line))))

(defn valid-password? [{:keys [min max ch password]}]
  (let [times (get (frequencies password) ch 0)]
    (<= min times max)))

(defn valid-password2? [{:keys [min max ch password]}]
  (not= 
   (= ch (nth password (dec min)))
   (= ch (nth password (dec max)))))

(defn part-1 []
  (->> "./src/main/resources/input_day_2.txt"
       read-database
       (filter valid-password?)
       count))

(defn part-2 []
  (->> "./src/main/resources/input_day_2.txt"
       read-database
       (filter valid-password2?)
       count))

(defn run [_]
  (println "Part 1: " (part-1))
  (println "Part 2: " (part-2)))
