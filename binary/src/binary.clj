(ns binary)

(defn to-decimal
  [bitstring]
  (if (re-matches #"[^01]+" bitstring)
    0
    (loop [
           bits bitstring
           value 0]
      (if (empty? bits)
        value
        (recur
         (rest bits)
         (+ (* 2 value) (if (= \0 (first bits)) 0 1)))))))
