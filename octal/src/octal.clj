(ns octal)


(defn to-decimal
  [s]
  (if (re-find #"[^0-7]" s)
    0
    (let [char-val
          (into {} (map #(vector (first (str %)) %)) (range 8))]
      (reduce +
              (map *
                   (reverse (map char-val s))
                   (iterate #(* 8 %) 1))))))
