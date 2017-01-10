(ns anagram (:require [clojure.string :as string]))


(defn anagrams-for
  [word word-list]
  (let [letters (sort (string/lower-case word))]
    (into [] (filter
              #(and
                (not= (string/lower-case %) (string/lower-case word))
                (= letters (sort (string/lower-case %)))) word-list)))
  )
