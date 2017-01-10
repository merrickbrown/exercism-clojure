(ns phone-number (:require [clojure.string :as string]))

(defn number
  [s]
  (let [digits (string/replace s #"[^0-9]" "")
        num-digits (count digits)]
    (if (= 10 num-digits)
      digits
      (if (and (= 11 num-digits) (= \1 (first digits)))
        (subs digits 1 11)
        "0000000000"))))

(defn area-code
  [s]
  (subs (number s) 0 3))

(defn pretty-print
  [s]
  (let [cleaned-number (number s)]
    (str
     "(" (subs cleaned-number 0 3) ") "
     (subs cleaned-number 3 6) "-" (subs cleaned-number 6 10))))
