(ns lineqs.io)

(require '[clojure.string :as s] '[lineqs.matrix :as m])

(defn read-matrix
  "Read a matrix from the file."
  [filename]
  (let [content (slurp filename)
        rows (s/split content #"\n")
        matrix (into [] (map #(into [] (map read-string (s/split (s/trim %) #"[^\-/\d]+"))) rows))]
    matrix)
  )

(defn print-roots
  "Print roots found by the Gaussian method."
  [matrix]
  (loop [text "Roots = {"
         r 1]
    (cond
      (= r (count matrix)) (recur (str text (m/get-value matrix r (inc (count matrix))) "}") (inc r))
      (= r (inc (count matrix))) (println text)
      :else (recur (str text (m/get-value matrix r (inc (count matrix))) ", ") (inc r)))))
