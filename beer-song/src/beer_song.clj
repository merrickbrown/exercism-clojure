(ns beer-song (:require [clojure.string :as string]))

(defn verse
  [n]
  (let [beer-quantity (fn [n] (cond
                             (= 0 n) "no more bottles of beer"
                             (= 1 n) "1 bottle of beer"
                             :default (str n " bottles of beer")))]
    (str
     (string/capitalize (beer-quantity n))
     " on the wall, "
     (beer-quantity n)
     ".\n"
     (if (= 0 n)
       "Go to the store and buy some more, "
       (str "Take " (if (= 1 n) "it" "one") " down and pass it around, "))
     (beer-quantity (mod (dec n) 100))
     " on the wall.\n"
      )))

(defn sing
  ([start] (sing start 0))
  ([start end]
   (string/join
    "\n"
    (for [n (range start (dec end) -1)]
      (verse n))))
)
