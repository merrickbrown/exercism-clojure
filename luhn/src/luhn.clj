(ns luhn)

(defn- two-digit-checksum
  [n] ;; 10b + a
  (let [a (mod n 10)
        two-b (* 2 (int (/ n 10)))]
    (if (> two-b 9)
      (mod (+ a two-b -9) 10)
      (mod (+ a two-b)    10))))

(defn checksum
  [n]
  (loop [running 0
         partial n]
    (if (= 0 partial)
      (mod running 10)
      (recur
       (+ running (two-digit-checksum (mod partial 100)))
       (bigint (/ partial 100))))))

(def valid? #(= 0 (checksum %)))

(defn add-check-digit
  [n]
  (+ (* 10 n) (mod (- (checksum (* 10 n))) 10)))
