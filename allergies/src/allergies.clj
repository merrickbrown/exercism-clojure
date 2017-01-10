(ns allergies)


;; eggs (1)
;; peanuts (2)
;; shellfish (4)
;; strawberries (8)
;; tomatoes (16)
;; chocolate (32)
;; pollen (64)
;; cats (128)


(defn allergies
  [score]
  (let [score (mod score 256)]
    (loop [n score
           results []
           possibilities '(:eggs :peanuts :shellfish
                                 :strawberries :tomatoes
                                 :chocolate :pollen :cats)]
      (if (= 0 n)
        results
        (recur
         (if (odd? n)
           (/ (dec n) 2)
           (/ n 2))
         (if (odd? n)
           (conj results (first possibilities))
           results)
         (rest possibilities))))))

(defn allergic-to?
  [score allergen]
  (true? (some #(= % allergen) (allergies score))))
