(ns strain)

(defn retain-transducer
  [pred]
  (fn [xf]
    (fn
      ([] xf)
      ([result] (xf result))
      ([result input]
       (if (pred input)
         (xf result input)
         (xf result))))))

(defn retain
  [pred coll]
  (into [] (retain-transducer pred) coll))

(defn discard
  [pred coll] (retain (complement pred) coll))
