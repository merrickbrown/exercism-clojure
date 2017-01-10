(ns trinary)

(defn to-decimal
  [bitstring]
  (if (re-find #"[^012]+" bitstring)
    0
    (loop [
           bits (map {\0 0 \1 1 \2 2} bitstring)
           value 0]
      (if (empty? bits)
        value
        (recur
         (rest bits)
         (+ (* 3 value) (first bits)))))))
