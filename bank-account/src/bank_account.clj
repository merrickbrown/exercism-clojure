(ns bank-account)

(defn open-account
  []
  (atom {:balance 0}))

(defn get-balance
  [acct]
  (:balance @acct))

(defn update-balance
  [acct amt]
  (swap! acct #(update % :balance (partial + amt))))

(defn close-account
  [acct]
  (swap! acct #(update % :balance (constantly nil))))
