(ns nucleotide-count)

(defn nucleotide-counts
  [dna-seq]
  (reduce #(update %1 %2 inc) {\A 0, \T 0, \G 0, \C 0} dna-seq))

(defn count
  [base dna-seq]
  (or ((nucleotide-counts dna-seq) base) (throw (Throwable.))))


