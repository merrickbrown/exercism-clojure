(ns bob (:require [clojure.string :as str]))

(defn response-for
  [input]
  (let [trimmed (str/trim input)]
    (cond
     (str/blank? trimmed) "Fine. Be that way!"
     (and
      (some #(Character/isLetter %) trimmed)
      (= trimmed (str/upper-case trimmed)))
      "Whoa, chill out!"
     (str/ends-with? trimmed "?") "Sure."
     :else "Whatever.")))
