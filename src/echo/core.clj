(ns echo.core
  (:gen-class))


(import '[java.net
          ServerSocket
          InetSocketAddress])


(defn setup-server [& {:keys [port]
                       :or {port 8000}}]
  (let [sock (new ServerSocket)]
    (.bind sock (new InetSocketAddress port))
    (try
      (let [conn (.accept sock)
            in (.getInputStream conn)
            out (.getOutputStream conn)]

        (loop []
          (println "RECVING")
          (let [buf (.read in)]
            (.write out buf)
            (println buf)
            (when (not (= buf 113))
              (recur)))))

      (finally
        (println "FINISHING")
        (.close sock)
        (println "FINISHED")))))


(defn -main
  "Echo server entry point"
  [& args]
  (println "Starting...")
  (setup-server))
