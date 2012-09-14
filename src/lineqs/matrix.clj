(ns lineqs.matrix)

(defn inverse
  "Inverse the [number] (e.g. 5 to 1/5, 10 to 1/10)."
  [number]
  (/ number (* number number)))

(defn get-value
  "Return the value at the position in the matrix."
  [mat row col]
  (let [r (nth mat (dec row))
        v (nth r (dec col))]
    v))

(defn lineqs?
  "Check if the matrix is a system of linear equations."
  [matrix]
  (let [rows (count matrix)
        zero-diagonal (filter #(= % 0) (map #(nth % %2) matrix (range 0 (count matrix))))
        bad-eqs (filter #(not= (count %) (inc rows)) matrix)
        bad-nums (some #(not (number? %)) (apply concat matrix))]
    (and (empty? bad-eqs) (empty? zero-diagonal) (nil? bad-nums))))

(defn multiply-row
  "Multiply the [row] in the [mat]rix by the [number]."
  [mat row number]
  (let [eq (nth mat (dec row))
        meq (into [] (map #(* % (rationalize number)) eq))
        m (replace {eq meq} mat)]
    m))

(defn sum-rows
  "Add one row muliplied by a quotient to another row."
  ([mat row1 row2] (sum-rows mat row1 row2 1))
  ([mat row1 row2 q]
     (let [eq (if (= q 1) (nth mat (dec row1)) (into [] (map #(* % (rationalize q)) (nth mat (dec row1)))))
           neq (into [] (map + eq (nth mat (dec row2))))
           m (replace {(nth mat (dec row2)) neq} mat)]
       m)))
