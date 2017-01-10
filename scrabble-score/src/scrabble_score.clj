(ns scrabble-score (require [clojure.string :as string]))

(def score
  (into {}
        (apply concat
               (for [[point letters]
                     {1 '(\A, \E, \I, \O, \U, \L, \N, \R, \S, \T)
                      2 '(\D, \G)
                      3 '(\B, \C, \M, \P)
                      4 '(\F, \H, \V, \W, \Y)
                      5 '(\K)
                      8 '(\J, \X)
                      10 '(\Q, \Z)}]
                 (map #(vector % point) letters)))))

(defn score-word
  [s]
  (reduce + (for [c (string/upper-case s)] (score c))))

(def score-letter score-word)
