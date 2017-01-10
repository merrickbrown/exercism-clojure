(ns word-count (:require [clojure.string :as string]))

(defn word-count [s]
  (let [
        word-vec (string/split
                  (string/replace
                   (string/lower-case s)
                   #"[^a-zA-Z0-9\s]" "")
                  #"\s+")]
    (reduce (fn [m k] (update m k #(inc (or % 0)))) {} word-vec))
)
