(ns raindrops)

(defn convert
  [n]
  (let [s (str
           (if (= 0 (mod n 3)) "Pling")
           (if (= 0 (mod n 5)) "Plang")
           (if (= 0 (mod n 7)) "Plong"))]
    (if (empty? s)
      (str n)
      s)))
