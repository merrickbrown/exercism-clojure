(ns sieve)

(defn sieve
  [max]
  (cond
   (> 2 max) []
   (= 2 max) [2]
   :default (loop [curr 3
          prev [2]]
     (if (> curr max)
       prev
       (if (some #(= 0 (mod curr %)) prev)
         (recur (+ 2 curr) prev)
         (recur (+ 2 curr) (conj prev curr)))))))
