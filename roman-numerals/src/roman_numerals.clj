(ns roman-numerals)

(def base-value
  {\I  1, \V   5, \X  10,
   \L 50, \C 100, \D 500, \M 1000})

(def values
  [[1000 "M"],
   [900  "CM"],
   [500  "D"],
   [400  "CD"]
   [100  "C"],
   [90   "XC"]
   [50   "L"],
   [40   "XL"],
   [10   "X"],
   [9    "IX"],
   [5    "V"],
   [4    "IV"],
   [1    "I"]])

(defn numerals
  [n]
  (let [value-map (into {} values)]
    (apply str
           (flatten
            (map
             #(repeat (% 1) (% 0))
             (loop [number n
                    numers []
                    pv (map #(% 0) values)]
               (if (empty? pv)
                 numers
                 (recur
                  (mod number (first pv))
                  (conj
                   numers
                   [(value-map (first pv)) (int (/ number (first pv)))])
                  (rest pv)))))))))

(defn read-numerals
  [s]
  (let [firs (for [c s] (base-value c))
        secs (drop 1 (concat firs '(0)))]
    (reduce + (map #(if (> %2 %1) (- %1) %1) firs secs))))
