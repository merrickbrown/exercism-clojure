(ns prime-factors)

(defn of
  [n]
  (loop [number n
         currdivisor 2
         divisors []]
    (cond
     (= 1 number) divisors
     (= 0 (mod number currdivisor)) (recur
                                     (/ number currdivisor)
                                     currdivisor
                                     (conj divisors currdivisor))
     :default (recur
               number
               (inc currdivisor)
               divisors))))
