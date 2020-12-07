(ns day1
  (:require ;;[clojure.string :as s]
            [clojure.java.io :as io]))

;; slurp reads the whole file;
;; it's a little slower.
;; (defn read-numbers [filename]
;;   (->> filename
;;        slurp
;;        s/split-lines
;;        (map #(Integer/parseInt %))))

(defn read-numbers [filename]
  (with-open [rdr (io/reader filename)]
    (->> rdr
    line-seq
    (map #(Integer/parseInt %))
    set)))

(defn find-entries []
  (let [numbers (read-numbers "./src/main/resources/input_day_1.txt")]
    (for [a numbers
          :let [b (- 2020 a)]
          :when (< a b )
          :when (contains? numbers b)]
      (* a b))))

(defn find-entries2 []
  (let [numbers (read-numbers "./src/main/resources/input_day_1.txt")]
    (for [a numbers
          b numbers
          :let [c (- 2020 a b)]
          :when (< a b c)
          :when (contains? numbers c)]
      (* a b c))))

(defn run [_]
  (println "Part 1: " (find-entries))
  (println "Part 2: " (find-entries2)))
