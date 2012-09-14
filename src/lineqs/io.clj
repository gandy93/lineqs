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
    (if (> r (count matrix))
      (println text)
      (let [root (m/get-value matrix r (inc (count matrix)))
            new-text (str text root (if (ratio? root) (format " = %.3f" (float root)) ""))
            new-r (inc r)]
        (if (= r (count matrix))
          (recur (str new-text "}") new-r)
          (recur (str new-text "; ") new-r))))))
