(ns grains)

(defn square
  [n]
  (if (= 1 n)
    (bigint 1)
    (* 2 (square (dec n)))))

(defn total []
  (dec (square 65)))
