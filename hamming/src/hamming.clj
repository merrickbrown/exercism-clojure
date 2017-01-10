(ns hamming)

(defn distance
  [dna-seq-1 dna-seq-2]
  (if (not= (count dna-seq-1) (count dna-seq-2))
    nil
    (loop [diffs 0
           rest-seq-1 dna-seq-1
           rest-seq-2 dna-seq-2]
      (cond
       (empty? rest-seq-1) diffs
       (= (first rest-seq-1) (first rest-seq-2)) (recur
                                                  diffs
                                                  (rest rest-seq-1)
                                                  (rest rest-seq-2))
       :default (recur
                 (inc diffs)
                 (rest rest-seq-1)
                 (rest rest-seq-2))))))
