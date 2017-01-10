(ns grade-school)

(defn add
  [db name grade]
  (update db grade (fn [names] (conj (or names []) name))))

(defn grade
  [db gr] (or (db gr) []))

(defn sorted
  [db]
  (apply sorted-map (reduce into (for [[k v] db] [k (sort v)]))))
