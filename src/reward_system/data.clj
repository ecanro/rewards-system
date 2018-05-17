(ns reward-system.data)

(def graph (atom {}))
(def inviteds (atom (set [])))
(def ranking (atom (sorted-map-by >)))

(defn insert! [x y]
	(when-not (some #{y} @inviteds)
		(let [conected-points (get @graph (keyword x))]
	  	(swap! graph conj (hash-map (keyword x) (conj conected-points (keyword y))))))
	(swap! inviteds conj x y))

(defn insert-ranking! [start-point reward-points]
	(swap! ranking into (hash-map reward-points start-point)))
